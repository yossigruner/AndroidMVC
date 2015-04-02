package com.mika.cheggmeout.managers;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.google.inject.Inject;
import com.mika.cheggmeout.R;
import com.mika.cheggmeout.utils.image.cache.IImageCache;
import com.mika.cheggmeout.utils.image.filters.IImageFilter;

/**
 * The Class DownloadManager.
 */
public class DownloadManager {

	@Inject
	private IImageCache mImageCache;

	/**
	 * Instantiates a new download manager.
	 */
	public DownloadManager() {
	}

	/**
	 * Start download image with out cache.
	 * 
	 * @param imageView
	 *            the image view
	 * @param url
	 *            the url
	 */
	public void startDownloadImageWithOutCache(ImageView imageView, String url) {

		new DownloadImageTask(imageView, null, false).execute(url);

	}

	/**
	 * Start download image.
	 * 
	 * @param imageView
	 *            the image view
	 * @param url
	 *            the url
	 */
	public void startDownloadImage(ImageView imageView, String url) {

		if (mImageCache.containsKey(url) == true) {
			imageView.setImageBitmap(mImageCache.get(url));
		} else {
			new DownloadImageTask(imageView, null, true).execute(url);
		}

	}

	/**
	 * Start download image.
	 * 
	 * @param imageView
	 *            the image view
	 * @param url
	 *            the url
	 * @param imageFilter
	 *            the image filter
	 */
	public void startDownloadImage(ImageView imageView, String url,
			IImageFilter imageFilter) {

		if (mImageCache.containsKey(url) == true) {
			imageView.setImageBitmap(mImageCache.get(url));
		} else {
			new DownloadImageTask(imageView, imageFilter, true).execute(url);
		}

	}

	/**
	 * The Class DownloadImageTask.
	 */
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

		/** The bm image. */
		ImageView bmImage;

		/** The Image filter. */
		private IImageFilter mImageFilter;

		/** The Do cache. */
		private boolean mDoCache;

		/**
		 * Instantiates a new download image task.
		 * 
		 * @param bmImage
		 *            the bm image
		 * @param imageFilter
		 *            the image filter
		 */
		DownloadImageTask(ImageView bmImage, IImageFilter imageFilter,
				boolean doCache) {
			this.bmImage = bmImage;
			mImageFilter = imageFilter;
			mDoCache = doCache;
			bmImage.setImageResource(R.drawable.ic_launcher);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.os.AsyncTask#doInBackground(Params[])
		 */
		protected Bitmap doInBackground(String... urls) {
			String url = urls[0];
			Bitmap mImage = null;
			try {

				final DefaultHttpClient client = new DefaultHttpClient();

				HttpGet getRequest = new HttpGet(url);
				HttpResponse response = client.execute(getRequest);
				HttpEntity entity = response.getEntity();

				BufferedInputStream bufferedInputStream = new BufferedInputStream(
						entity.getContent());

				bufferedInputStream.mark((int) entity.getContentLength());

				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeStream(bufferedInputStream, null, options);

				try {
					bufferedInputStream.reset();
				} catch (IOException ioException) {
					ioException.printStackTrace();
					return null;
				}

				// performs the actual image decoding (in reduced resolution)
				options.inJustDecodeBounds = false;
				options.inSampleSize = 1;
				mImage = BitmapFactory.decodeStream(bufferedInputStream, null,
						options);

				if (mImageFilter != null) {
					mImage = mImageFilter.execute(mImage, options.outHeight,
							options.outWidth, (int) (255 * 0.5));
				}
				if (mDoCache == true) {
					mImageCache.put(url, mImage);
				}

			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mImage;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
		 */
		protected void onPostExecute(Bitmap result) {

			bmImage.setImageBitmap(result);
		}
	}

}
