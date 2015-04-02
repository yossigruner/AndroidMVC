package com.mika.cheggmeout.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

	@JsonProperty("standard_resolution")
	private StandardResolution mStandardResolution;

	public StandardResolution getStandardResolution() {
		return mStandardResolution;
	}

	public void setStandardResolution(StandardResolution standardResolution) {
		mStandardResolution = standardResolution;
	}

}
