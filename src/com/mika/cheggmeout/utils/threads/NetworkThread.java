package com.mika.cheggmeout.utils.threads;

import android.os.HandlerThread;

import com.google.inject.Singleton;

/**
 * The Class Network.
 */
@Singleton
public class NetworkThread extends HandlerThread {

	/** The network thread name. */
	private static String NETWORK_THREAD_NAME = "NETWORK_THREAD";

	/**
	 * Instantiates a new Network thread.
	 */
	public NetworkThread() {
		super(NETWORK_THREAD_NAME);
		start();
	}

}
