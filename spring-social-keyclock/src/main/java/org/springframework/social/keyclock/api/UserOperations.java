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
package org.springframework.social.keyclock.api;

import java.util.List;

/**
 * Interface defining the operations for working with Keyclock users.
 *
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface UserOperations {

	/**
	 * Retrieves the user's Keyclock profile ID.
	 *
	 * @return the user's Keyclock profile ID.
	 */
	String getProfileId();

	/**
	 * Retrieves the user's Keyclock profile details.
	 *
	 * @return the user's Keyclock profile
	 */
	KeyclockUserProfile getUserProfile();

	/**
	 * Retrieve the URL to the user's Keyclock profile.
	 *
	 * @return the URL to the user's Keyclock profile.
	 */
	String getProfileUrl();

	/**
	 * Public operation to return a given user's followers.
	 *
	 * @param user Keyclock user
	 * @return list of followers
	 */
	List<KeyclockUser> getFollowers(String user);

	/**
	 * Public operation to return the users that a given user is following.
	 *
	 * @param user Keyclock user
	 * @return list of users the given user is following
	 */
	List<KeyclockUser> getFollowing(String user);
}
