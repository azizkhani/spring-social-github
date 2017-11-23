/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.keycloak.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.keycloak.api.KeycloakUser;

/**
 * Annotated mixin to add annotations to {@link KeycloakUser}
 *
 * @author ali akbar azizkhani
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class KeycloakUserMixin  {

    String name;

    String email;

    String bio;

    KeycloakUserMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email) {}
}
