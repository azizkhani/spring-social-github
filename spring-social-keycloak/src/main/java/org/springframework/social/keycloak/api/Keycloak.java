/*
 * Copyright 2013 the original author or authors.
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
package org.springframework.social.keycloak.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * Interface specifying a basic set of operations for interacting with Keycloak.
 * Implemented by {@link org.springframework.social.keycloak.api.impl.KeycloakTemplate}.
 *
 * Many of the methods contained in this interface require OAuth authentication
 * with Keycloak. When a method's description speaks of the "current user", it is
 * referring to the user for whom the access token has been issued.
 *
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface Keycloak extends ApiBinding {


	 KeycloakUser getUserProfile();


	/**
	 * Returns the underlying {@link RestOperations} object allowing for consumption of Keycloak endpoints that may not be otherwise covered by the API binding.
	 * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
	 *
	 * @return REST operations
	 */
	RestOperations restOperations();

}
