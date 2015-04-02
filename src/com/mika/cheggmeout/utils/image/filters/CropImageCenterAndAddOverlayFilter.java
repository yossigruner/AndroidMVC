package com.mika.cheggmeout.utils.image.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

public class CropImageCenterAndAddOverlayFilter implements IImageFilter {

	@Override
	public Bitmap execute(Bitmap bitmap, Integer... params) {

		int height = params[0];
		int width = params[1];
		int alpha = params[2];

		Bitmap dstBmp;
		Bitmap overlayBmp;

		dstBmp = Bitmap.createBitmap(bitmap, 0, height / 2, width, height / 2);
		overlayBmp = Bitmap.createBitmap(width, height / 2, bitmap.getConfig());

		Canvas canvas = new Canvas(overlayBmp);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(overlayBmp, 0, 0, null);

		Canvas canvas2 = new Canvas(dstBmp);
		Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
		paint.setAlpha(alpha);
		canvas2.drawBitmap(overlayBmp, new Matrix(), paint);

		return dstBmp;

	}
}
