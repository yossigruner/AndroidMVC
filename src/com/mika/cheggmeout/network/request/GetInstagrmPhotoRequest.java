package com.mika.cheggmeout.network.request;

import org.springframework.http.HttpMethod;

import android.text.TextUtils;

import com.google.inject.Inject;
import com.mika.cheggmeout.dtos.Result;
import com.mika.cheggmeout.utils.threads.NetworkThread;

/**
 * The Class GetInstagrmPhoto.
 */
public class GetInstagrmPhotoRequest extends BaseRequest<Void, Result> {

	/** The Max item. */
	private int mMaxItem;

	/** The Token. */
	private String mToken;

	private String mUrl;

	/**
	 * Instantiates a new gets the instagrm photo.
	 * 
	 * @param networkThread
	 *            the network thread
	 */
	@Inject
	public GetInstagrmPhotoRequest(NetworkThread networkThread) {
		super(networkThread);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mika.cheggmeout.network.request.BaseRequest#getMethod()
	 */
	@Override
	public HttpMethod getMethod() {
		return HttpMethod.GET;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mika.cheggmeout.network.request.BaseRequest#getUrl()
	 */
	@Override
	public String getUrl() {

		if (TextUtils.isEmpty(mUrl) == false) {
			return mUrl;
		}

		StringBuilder builder = new StringBuilder(
				"https://api.instagram.com/v1/tags/cheggmeout/media/recent");

		builder.append("?").append("access_token=").append(mToken)
				.append("&count=").append(mMaxItem);

		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mika.cheggmeout.network.request.BaseRequest#getRequestBody()
	 */
	@Override
	public Void getRequestBody() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mika.cheggmeout.network.request.BaseRequest#getResponseClass()
	 */
	@Override
	public Class<Result> getResponseClass() {
		return Result.class;
	}

	/**
	 * Sets the max item per request.
	 * 
	 * @param maxItem
	 *            the new max item per request
	 */
	public void setMaxItemPerRequest(int maxItem) {
		mMaxItem = maxItem;
	}

	/**
	 * Sets the token.
	 * 
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		mToken = token;

	}

	public void setUrl(String url) {
		mUrl = url;

	}

}
