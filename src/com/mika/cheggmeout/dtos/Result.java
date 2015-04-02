package com.mika.cheggmeout.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Result.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	/** The Car model. */
	@JsonProperty("pagination")
	private Pagination mPagination;

	/** The Data list. */
	@JsonProperty("data")
	private List<Data> mDataList;

	/**
	 * Gets the pagination.
	 * 
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return mPagination;
	}

	/**
	 * Sets the pagination.
	 * 
	 * @param pagination
	 *            the new pagination
	 */
	public void setPagination(Pagination pagination) {
		mPagination = pagination;
	}

	/**
	 * Gets the data list.
	 * 
	 * @return the data list
	 */
	public List<Data> getDataList() {
		return mDataList;
	}

	/**
	 * Sets the data list.
	 * 
	 * @param dataList
	 *            the new data list
	 */
	public void setDataList(List<Data> dataList) {
		mDataList = dataList;
	}

}
