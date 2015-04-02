package com.mika.cheggmeout.utils.image.cache;

import android.graphics.Bitmap;

public interface IImageCache {

	/**
	 * Put.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public abstract void put(String key, Bitmap value);

	/**
	 * Contains key.
	 * 
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public abstract boolean containsKey(String key);

	/**
	 * Gets the.
	 * 
	 * @param key
	 *            the key
	 * @return the bitmap
	 */
	public abstract Bitmap get(String key);

}