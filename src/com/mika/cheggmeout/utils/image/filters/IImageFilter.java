package com.mika.cheggmeout.utils.image.filters;

import android.graphics.Bitmap;

/**
 * The Interface IImageFilter.
 */
public interface IImageFilter {

	/**
	 * Execute.
	 * 
	 * @param bitmap
	 *            the bitmap
	 * @param outWidth
	 * @param outHeight
	 * @return the bitmap
	 */
	public Bitmap execute(Bitmap bitmap, Integer... params);

}
