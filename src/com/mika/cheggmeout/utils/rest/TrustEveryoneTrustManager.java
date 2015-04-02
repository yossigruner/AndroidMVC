/**
 * 
 */
package com.mika.cheggmeout.utils.rest;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class TrustEveryoneTrustManager implements X509TrustManager {

	private static TrustManager[] mTrustManagers;
	private static final X509Certificate[] mAcceptedIssuers = new X509Certificate[] {};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.net.ssl.X509TrustManager#checkClientTrusted(java.security.cert.
	 * X509Certificate[], java.lang.String)
	 */

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// no exception is thrown, so all clients are trusted
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.
	 * X509Certificate[], java.lang.String)
	 */
	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// no exception is thrown, so all servers are trusted
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return mAcceptedIssuers;
	}

	public boolean isClientTrusted(X509Certificate[] chain) {
		return true;
	}

	public boolean isServerTrusted(X509Certificate[] chain) {
		return true;
	}

	public static void makeAllNewInstancesAcceptAllSSL()
			throws KeyManagementException, NoSuchAlgorithmException {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		SSLContext context = null;
		if (mTrustManagers == null) {
			mTrustManagers = new TrustManager[] { new TrustEveryoneTrustManager() };
		}
		try {
			context = SSLContext.getInstance("TLS");
			context.init(null, mTrustManagers, new SecureRandom());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		// HttpsURLConnection.setDefaultSSLSocketFactory(AttSslSocketFactory.getInstance());
		if (context == null || context.getSocketFactory() == null) {
			throw new NullPointerException("Couldn't get SSL context");
		}
		HttpsURLConnection.setDefaultSSLSocketFactory(context
				.getSocketFactory());
	}
}
