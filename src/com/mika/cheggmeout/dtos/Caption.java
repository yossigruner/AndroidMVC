package com.mika.cheggmeout.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Caption {

	@JsonProperty("created_time")
	private String mCreatedTime;

	@JsonProperty("text")
	private String mText;

	public String getCreatedTime() {
		return mCreatedTime;
	}

	public void setCreatedTime(String createdTime) {
		mCreatedTime = createdTime;
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		mText = text;
	}

}
