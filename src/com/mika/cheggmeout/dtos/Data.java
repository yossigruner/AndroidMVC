package com.mika.cheggmeout.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	/** The Profile. */
	@JsonProperty("user")
	private UserProfile mProfile;

	/** The Caption. */
	@JsonProperty("caption")
	private Caption mCaption;

	/** The Images. */
	@JsonProperty("images")
	private Image mImages;

	/**
	 * Gets the profile.
	 *
	 * @return the profile
	 */
	public UserProfile getProfile() {
		return mProfile;
	}

	/**
	 * Sets the profile.
	 *
	 * @param profile the new profile
	 */
	public void setProfile(UserProfile profile) {
		mProfile = profile;
	}

	/**
	 * Gets the caption.
	 *
	 * @return the caption
	 */
	public Caption getCaption() {
		return mCaption;
	}

	/**
	 * Sets the caption.
	 *
	 * @param caption the new caption
	 */
	public void setCaption(Caption caption) {
		mCaption = caption;
	}

	/**
	 * Gets the images.
	 *
	 * @return the images
	 */
	public Image getImages() {
		return mImages;
	}

	/**
	 * Sets the images.
	 *
	 * @param images the new images
	 */
	public void setImages(Image images) {
		mImages = images;
	}
	
	
	
}
