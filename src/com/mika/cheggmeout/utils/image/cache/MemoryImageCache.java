package com.mika.cheggmeout.utils.image.cache;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;

import android.graphics.Bitmap;

/**
 * The Class ImageCache.
 */
@Singleton
public class MemoryImageCache implements IImageCache {

	/** The Cache bit map. */
	private Map<String, Bitmap> mCacheBitMap;

	/**
	 * Instantiates a new image cache.
	 */
	public MemoryImageCache() {
		mCacheBitMap = new HashMap<String, Bitmap>();
	}

	@Override
	public void put(String key, Bitmap value) {
		mCacheBitMap.put(key, value);
	}

	@Override
	public boolean containsKey(String key) {
		return mCacheBitMap.containsKey(key);
	}

	@Override
	public Bitmap get(String key) {
		return mCacheBitMap.get(key);
	}

}
