/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.plugin.common.tools;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for path operations.
 */
public final class PathUtil {

  private PathUtil() {
    // Utility class
  }

  /**
   * Checks if a file path is absolute. An absolute path is platform-dependent: - On Windows: C:\\path, D:\\path, \\\\server\\share (UNC) - On Unix/Linux: /path
   *
   * @param filePath the file path to check
   * @return true if the path is absolute, false if relative or invalid
   */
  public static boolean isAbsolutePath(final String filePath) {
    if (StringUtils.isEmpty(filePath)) {
      return false;
    }
    try {
      return Paths.get(filePath).isAbsolute();
    } catch (final InvalidPathException e) {
      // If the path is invalid, treat it as not absolute
      return false;
    }
  }

  /**
   * Checks whether a spec path points to a remote/URL location that must be fetched via a
   * {@link java.net.URL} stream rather than the filesystem or classpath. Enables loading
   * specifications from HTTP(S) endpoints such as an Apicurio Registry artifact.
   *
   * @param filePath the spec path to check
   * @return true if the path uses an http, https, ftp or file scheme
   */
  public static boolean isRemoteUri(final String filePath) {
    return StringUtils.isNotEmpty(filePath)
           && filePath.matches("^(?i)(https?|file)://.*");
  }

  /** Connection timeout (ms) applied when fetching a remote specification. */
  public static final int REMOTE_CONNECT_TIMEOUT_MS = 15_000;

  /** Read timeout (ms) applied when fetching a remote specification. */
  public static final int REMOTE_READ_TIMEOUT_MS = 30_000;

  /**
   * Opens a stream to a URL with bounded connect/read timeouts, so an unresponsive remote
   * spec server (e.g. an Apicurio Registry) cannot hang the build indefinitely. Timeouts are
   * harmless for non-network schemes such as {@code file:} and {@code jar:}.
   *
   * @param url the URL to open
   * @return the input stream
   * @throws java.io.IOException if the connection cannot be established or times out
   */
  public static java.io.InputStream openUrlStream(final java.net.URL url) throws java.io.IOException {
    final java.net.URLConnection connection = url.openConnection();
    connection.setConnectTimeout(REMOTE_CONNECT_TIMEOUT_MS);
    connection.setReadTimeout(REMOTE_READ_TIMEOUT_MS);
    return connection.getInputStream();
  }
}
