/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.plugin.common.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PathUtilTest {

  private static final String[] AUTH_PROPS = {
      "scs.multiapi.remote.host", "scs.multiapi.remote.token", "scs.multiapi.remote.user",
      "scs.multiapi.remote.password", "scs.multiapi.remote.header.name", "scs.multiapi.remote.header.value"
  };

  @AfterEach
  void clearAuthProps() {
    for (final String prop : AUTH_PROPS) {
      System.clearProperty(prop);
    }
  }

  @Test
  void isRemoteUriDetectsUrlSchemes() {
    assertTrue(PathUtil.isRemoteUri("http://registry/apis/registry/v2/groups/g/artifacts/a"));
    assertTrue(PathUtil.isRemoteUri("https://example.com/openapi.yml"));
    assertTrue(PathUtil.isRemoteUri("HTTPS://EXAMPLE.COM/openapi.yml"));
    assertTrue(PathUtil.isRemoteUri("file:///tmp/spec.yml"));
  }

  @Test
  void isRemoteUriRejectsLocalPaths() {
    assertFalse(PathUtil.isRemoteUri("ftp://host/spec.yml"));
    assertFalse(PathUtil.isRemoteUri("./src/main/resources/api/api.yml"));
    assertFalse(PathUtil.isRemoteUri("/absolute/path/api.yml"));
    assertFalse(PathUtil.isRemoteUri("contracts/event-api.yml"));
    assertFalse(PathUtil.isRemoteUri("C:\\api\\api.yml"));
    assertFalse(PathUtil.isRemoteUri(""));
    assertFalse(PathUtil.isRemoteUri(null));
  }

  @Test
  void remoteAuthHeadersEmptyWhenUnconfigured() {
    assertTrue(PathUtil.remoteAuthHeaders("registry.example.com").isEmpty());
  }

  @Test
  void remoteAuthHeadersBearerToken() {
    System.setProperty("scs.multiapi.remote.token", "abc123");
    final Map<String, String> headers = PathUtil.remoteAuthHeaders("registry.example.com");
    assertEquals("Bearer abc123", headers.get("Authorization"));
  }

  @Test
  void remoteAuthHeadersBasicAuth() {
    System.setProperty("scs.multiapi.remote.user", "alice");
    System.setProperty("scs.multiapi.remote.password", "s3cret");
    final String expected = "Basic " + Base64.getEncoder().encodeToString("alice:s3cret".getBytes(StandardCharsets.UTF_8));
    assertEquals(expected, PathUtil.remoteAuthHeaders("registry.example.com").get("Authorization"));
  }

  @Test
  void remoteAuthHeadersArbitraryHeader() {
    System.setProperty("scs.multiapi.remote.header.name", "X-Registry-ApiKey");
    System.setProperty("scs.multiapi.remote.header.value", "key-42");
    assertEquals("key-42", PathUtil.remoteAuthHeaders("registry.example.com").get("X-Registry-ApiKey"));
  }

  @Test
  void remoteAuthHeadersScopedToConfiguredHost() {
    System.setProperty("scs.multiapi.remote.token", "abc123");
    System.setProperty("scs.multiapi.remote.host", "registry.example.com");
    // Matching host receives the credentials.
    assertEquals("Bearer abc123", PathUtil.remoteAuthHeaders("registry.example.com").get("Authorization"));
    // A different host (e.g. reached via an external $ref) must NOT receive them.
    assertTrue(PathUtil.remoteAuthHeaders("evil.example.org").isEmpty());
  }
}
