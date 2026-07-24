/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.api.generator.plugin.common.files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import com.sngular.api.generator.plugin.common.tools.PathUtil;

/**
 * {@link FileLocation} for specifications loaded from a remote URL (e.g. an Apicurio Registry
 * artifact served over HTTP). Relative sibling files (external {@code $ref}s) are resolved
 * against the spec's base URI and fetched over the same protocol.
 */
public class RemoteFileLocation implements FileLocation {

  private final URI baseUri;

  public RemoteFileLocation(final URI baseUri) {
    this.baseUri = baseUri;
  }

  @Override
  public InputStream getFileAtLocation(final String filename) throws IOException {
    final URL target = baseUri.resolve(filename).toURL();
    return PathUtil.openUrlStream(target);
  }

  @Override
  public URI path() {
    return baseUri;
  }
}
