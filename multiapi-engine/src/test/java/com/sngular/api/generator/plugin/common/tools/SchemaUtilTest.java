package com.sngular.api.generator.plugin.common.tools;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

class SchemaUtilTest {

  @Test
  void shouldResolveBackslashRelativePath() throws Exception {
    final Path tmp = Files.createTempDirectory("schema-util-test");
    try {
      // Estructura: tmp/module/sub/root.yml  y  tmp/api-contract/openapi.yml
      final Path moduleSub = tmp.resolve("module").resolve("sub");
      Files.createDirectories(moduleSub);
      final Path rootFile = moduleSub.resolve("root.yml");
      Files.writeString(rootFile, "dummy: true");

      final Path apiContract = tmp.resolve("api-contract");
      Files.createDirectories(apiContract);
      final Path openapiFile = apiContract.resolve("openapi.yml");
      final String openapiContent = "components:\n  schemas:\n    Pet:\n      type: object\n";
      Files.writeString(openapiFile, openapiContent);

      final URI rootUri = rootFile.toUri();
      // Ruta relativa con backslashes (Windows style)
      final String refPath = "..\\..\\api-contract\\openapi.yml";
      final JsonNode node = SchemaUtil.getPojoFromRef(rootUri, refPath);

      assertNotNull(node, "El nodo no debe ser nulo");
      assertTrue(node.has("components"), "Debe contener 'components'");
      assertTrue(node.path("components").has("schemas"), "Debe contener 'schemas' dentro de components");
      assertTrue(node.path("components").path("schemas").has("Pet"), "Debe contener el schema 'Pet'");
    } finally {
      // Limpieza (intencionalmente silenciosa)
      try { Files.walk(tmp).map(Path::toFile).sorted((a,b)->-a.compareTo(b)).forEach(java.io.File::delete); } catch (Exception ignored) {}
    }
  }

  @Test
  void shouldLoadSpecFromUrl() throws Exception {
    // Loading a spec from a URL is the mechanism used for remote sources (e.g. an Apicurio
    // Registry artifact). A file:// URL exercises the same URL code path without network access.
    final Path tmp = Files.createTempDirectory("schema-util-url-test");
    try {
      final Path openapiFile = tmp.resolve("openapi.yml");
      Files.writeString(openapiFile, "components:\n  schemas:\n    Pet:\n      type: object\n");

      final String url = openapiFile.toUri().toString(); // file:///...
      assertTrue(PathUtil.isRemoteUri(url), "A file:// path must be detected as a remote URI");

      // rootFilePath is irrelevant for a remote URL; it is fetched directly.
      final JsonNode node = SchemaUtil.getPojoFromRef(tmp.toUri(), url);

      assertNotNull(node, "El nodo no debe ser nulo");
      assertTrue(node.path("components").path("schemas").has("Pet"), "Debe contener el schema 'Pet'");
    } finally {
      try { Files.walk(tmp).map(Path::toFile).sorted((a, b) -> -a.compareTo(b)).forEach(java.io.File::delete); } catch (Exception ignored) {}
    }
  }
}
