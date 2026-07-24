/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.plugin.common.tools;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PathUtilTest {

  @Test
  void isRemoteUriDetectsUrlSchemes() {
    assertTrue(PathUtil.isRemoteUri("http://registry/apis/registry/v2/groups/g/artifacts/a"));
    assertTrue(PathUtil.isRemoteUri("https://example.com/openapi.yml"));
    assertTrue(PathUtil.isRemoteUri("HTTPS://EXAMPLE.COM/openapi.yml"));
    assertTrue(PathUtil.isRemoteUri("ftp://host/spec.yml"));
    assertTrue(PathUtil.isRemoteUri("file:///tmp/spec.yml"));
  }

  @Test
  void isRemoteUriRejectsLocalPaths() {
    assertFalse(PathUtil.isRemoteUri("./src/main/resources/api/api.yml"));
    assertFalse(PathUtil.isRemoteUri("/absolute/path/api.yml"));
    assertFalse(PathUtil.isRemoteUri("contracts/event-api.yml"));
    assertFalse(PathUtil.isRemoteUri("C:\\api\\api.yml"));
    assertFalse(PathUtil.isRemoteUri(""));
    assertFalse(PathUtil.isRemoteUri(null));
  }
}
