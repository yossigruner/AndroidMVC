package com.mika.cheggmeout.utils.rest;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * The Class SSLRestTemplate.
 */
public class SSLRestTemplate extends RestTemplate {

	private final static int HTTP_CONNECT_TIMEOUT = 15 * 1000;
	private final static int HTTP_READ_TIMEOUT = 25 * 1000;

	public SSLRestTemplate() {

		try {
			TrustEveryoneTrustManager.makeAllNewInstancesAcceptAllSSL();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(HTTP_CONNECT_TIMEOUT);
		clientHttpRequestFactory.setReadTimeout(HTTP_READ_TIMEOUT);

		this.setRequestFactory(clientHttpRequestFactory);
	}
}
