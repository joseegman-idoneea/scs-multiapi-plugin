/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.test.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestUtils {

  public static void validateFiles(final List<String> expectedFiles, final File targetDirectory) throws URISyntaxException {
    File reader1;
    File reader2;

    List<File> outputFiles = new ArrayList<>(List.of(Objects.requireNonNull(targetDirectory.listFiles())));
    outputFiles.removeIf(File::isDirectory);
    outputFiles.sort(Comparator.comparing(File::getPath));
    assertThat(outputFiles)
        .overridingErrorMessage("Wrong Number of files %d vs %d: %s", outputFiles.size(), expectedFiles.size(), outputFiles)
        .hasSize(expectedFiles.size());
    for (int i = 0; i < outputFiles.size(); i++) {
      reader1 = outputFiles.get(i);
      assertThat(reader1).overridingErrorMessage("Generated file %s should not be null", outputFiles.get(i)).isNotNull();
      final String sourceName = expectedFiles.get(i);
      reader2 = TestUtils.resourceAsFile(sourceName);
      assertThat(reader2).overridingErrorMessage("Expected file %s should not be null", sourceName).isNotNull();
      final String generatedContent = TestUtils.normalizeContent(reader1);
      final String expectedContent = TestUtils.normalizeContent(reader2);
      assertThat(generatedContent)
          .overridingErrorMessage("Generated file %s differs from expected file %s", outputFiles.get(i), sourceName)
          .isEqualTo(expectedContent);
    }
  }

  static String normalizeContent(final File file) {
    try {
      String content = Files.readString(file.toPath());
      return Arrays.stream(content.replace("\r\n", "\n").replace("\r", "\n").split("\n", -1))
          .map(String::stripTrailing)
          .collect(Collectors.joining("\n"))
          .strip();
    } catch (IOException e) {
      throw new RuntimeException("Error reading file " + file, e);
    }
  }

  public static File resourceAsFile(String resourceName) throws URISyntaxException {
    return Paths.get(TestUtils.class.getClassLoader().getResource(resourceName).toURI()).toFile();
  }
}
