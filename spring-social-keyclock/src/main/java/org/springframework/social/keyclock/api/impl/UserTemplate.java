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
package org.springframework.social.keyclock.api.impl;

import org.springframework.social.keyclock.api.KeyclockUser;
import org.springframework.social.keyclock.api.KeyclockUserProfile;
import org.springframework.social.keyclock.api.UserOperations;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.*;

/**
 * <p>
 * User template implementation.
 * </p>
 *
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
public class UserTemplate extends AbstractKeyclockOperations implements UserOperations {

	private final RestTemplate restTemplate;

	/**
	 * @param restTemplate A RestTemplate
	 * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
	 */
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public List<KeyclockUser> getFollowers(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/followers"), KeyclockUser[].class, user));
	}

	public List<KeyclockUser> getFollowing(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/following"), KeyclockUser[].class, user));
	}

	public String getProfileId() {
		return getUserProfile().getLogin();
	}

	public KeyclockUserProfile getUserProfile() {
		return restTemplate.getForObject(buildUri("user"), KeyclockUserProfile.class);
	}

	public String getProfileUrl() {
		return "https://github.com/" + getUserProfile().getLogin();
	}



	private String buildUserUri(String path) {
		return buildUri("users/{user}" + path);
	}

	private Date toDate(String dateString, DateFormat dateFormat) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);

}
