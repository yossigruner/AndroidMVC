package com.mika.cheggmeout.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class UserProfile.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {

	/** The Username. */
	@JsonProperty("username")
	private String mUsername;

	/** The Profile picture. */
	@JsonProperty("profile_picture")
	private String mProfilePicture;

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return mUsername;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		mUsername = username;
	}

	/**
	 * Gets the profile picture.
	 * 
	 * @return the profile picture
	 */
	public String getProfilePicture() {
		return mProfilePicture;
	}

	/**
	 * Sets the profile picture.
	 * 
	 * @param profilePicture
	 *            the new profile picture
	 */
	public void setProfilePicture(String profilePicture) {
		mProfilePicture = profilePicture;
	}

}
