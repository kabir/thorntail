/**
 * Copyright 2015-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.undertow;

import org.junit.Test;
import org.wildfly.swarm.undertow.internal.DefaultWarDeploymentFactory;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Ken Finnigan
 */
public class JbossWebContainerTest {

    @Test
    public void testSettingContextRoot() throws Exception {
        WARArchive archive = DefaultWarDeploymentFactory.archiveFromCurrentApp();

        assertThat(archive.getContextRoot()).isNull();

        archive.setContextRoot("myRoot");
        assertThat(archive.getContextRoot()).isNotNull();
        assertThat(archive.getContextRoot()).isEqualTo("myRoot");

        archive.setContextRoot("/someRoot");
        assertThat(archive.getContextRoot()).isNotNull();
        assertThat(archive.getContextRoot()).isEqualTo("/someRoot");
    }

    @Test
    public void testSettingSecurityDomain() throws Exception {
        WARArchive archive = DefaultWarDeploymentFactory.archiveFromCurrentApp();

        assertThat(archive.getSecurityDomain()).isNull();

        archive.setSecurityDomain("some-security-domain");
        assertThat(archive.getSecurityDomain()).isEqualTo("some-security-domain");
    }
}
