package com.mika.cheggmeout.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {

	@JsonProperty("next_url")
	private String mNextUrl;

	public String getNextUrl() {
		return mNextUrl;
	}

	public void setNextUrl(String nextUrl) {
		mNextUrl = nextUrl;
	}

}
