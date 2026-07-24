/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.plugin.common.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for path operations.
 */
public final class PathUtil {

  /** Connection timeout (ms) applied when fetching a remote specification. */
  public static final int REMOTE_CONNECT_TIMEOUT_MS = 15_000;

  /** Read timeout (ms) applied when fetching a remote specification. */
  public static final int REMOTE_READ_TIMEOUT_MS = 30_000;

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
   * @return true if the path uses an http, https or file scheme
   */
  public static boolean isRemoteUri(final String filePath) {
    return StringUtils.isNotEmpty(filePath)
           && filePath.matches("^(?i)(https?|file)://.*");
  }

  /**
   * Opens a stream to a URL with bounded connect/read timeouts, so an unresponsive remote
   * spec server (e.g. an Apicurio Registry) cannot hang the build indefinitely. Timeouts are
   * harmless for non-network schemes such as {@code file:} and {@code jar:}. For {@code http}/
   * {@code https} URLs any configured authentication headers (see {@link #remoteAuthHeaders})
   * are applied.
   *
   * @param url the URL to open
   * @return the input stream
   * @throws IOException if the connection cannot be established or times out
   */
  public static InputStream openUrlStream(final URL url) throws IOException {
    final URLConnection connection = url.openConnection();
    connection.setConnectTimeout(REMOTE_CONNECT_TIMEOUT_MS);
    connection.setReadTimeout(REMOTE_READ_TIMEOUT_MS);
    final String protocol = url.getProtocol();
    if ("http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol)) {
      remoteAuthHeaders(url.getHost()).forEach(connection::setRequestProperty);
    }
    return connection.getInputStream();
  }

  /**
   * Resolves the authentication headers to attach when fetching a remote spec, from system
   * properties (preferred) or environment variables. Credentials are never read from the build
   * files. Supported schemes (first match wins for {@code Authorization}):
   * <ul>
   *   <li>Bearer token: {@code scs.multiapi.remote.token} / {@code SCS_MULTIAPI_REMOTE_TOKEN}</li>
   *   <li>Basic auth: {@code scs.multiapi.remote.user}(+{@code .password}) /
   *       {@code SCS_MULTIAPI_REMOTE_USER}(+{@code _PASSWORD})</li>
   * </ul>
   * plus an optional arbitrary header ({@code scs.multiapi.remote.header.name}/{@code .value} or
   * {@code SCS_MULTIAPI_REMOTE_HEADER_NAME}/{@code _VALUE}), e.g. an {@code X-Registry-ApiKey}.
   *
   * <p>When {@code scs.multiapi.remote.host} / {@code SCS_MULTIAPI_REMOTE_HOST} is set, credentials
   * are only sent to that host, so a token is never leaked to a different host reached through an
   * external {@code $ref} or a cross-host redirect.
   *
   * @param host the host of the URL being fetched
   * @return the headers to apply (empty if none configured, or scoped out by host)
   */
  public static Map<String, String> remoteAuthHeaders(final String host) {
    final Map<String, String> headers = new LinkedHashMap<>();

    final String scopedHost = config("scs.multiapi.remote.host", "SCS_MULTIAPI_REMOTE_HOST");
    if (StringUtils.isNotBlank(scopedHost) && !scopedHost.equalsIgnoreCase(host)) {
      return headers;
    }

    final String token = config("scs.multiapi.remote.token", "SCS_MULTIAPI_REMOTE_TOKEN");
    final String user = config("scs.multiapi.remote.user", "SCS_MULTIAPI_REMOTE_USER");
    if (StringUtils.isNotBlank(token)) {
      headers.put("Authorization", "Bearer " + token);
    } else if (StringUtils.isNotBlank(user)) {
      final String password = StringUtils.defaultString(
          config("scs.multiapi.remote.password", "SCS_MULTIAPI_REMOTE_PASSWORD"));
      final String credentials = user + ":" + password;
      final String basic = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
      headers.put("Authorization", "Basic " + basic);
    }

    final String headerName = config("scs.multiapi.remote.header.name", "SCS_MULTIAPI_REMOTE_HEADER_NAME");
    final String headerValue = config("scs.multiapi.remote.header.value", "SCS_MULTIAPI_REMOTE_HEADER_VALUE");
    if (StringUtils.isNotBlank(headerName) && StringUtils.isNotBlank(headerValue)) {
      headers.put(headerName, headerValue);
    }

    return headers;
  }

  private static String config(final String systemProperty, final String environmentVariable) {
    final String fromProperty = System.getProperty(systemProperty);
    return StringUtils.isNotBlank(fromProperty) ? fromProperty : System.getenv(environmentVariable);
  }
}
