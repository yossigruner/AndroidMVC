package com.mika.cheggmeout.ui.controllers;

import android.text.TextUtils;

import com.google.inject.Inject;
import com.mika.cheggmeout.managers.DownloadManager;
import com.mika.cheggmeout.ui.controllers.interfaces.IDisplayImageController;
import com.mika.cheggmeout.ui.views.interfaces.IDisplayImageView;

public class DisplayImageController extends BaseController<IDisplayImageView>
		implements IDisplayImageController {

	/** The Constant IMAGE_URL_PARAM_NAME. */
	public static final String IMAGE_URL_PARAM_NAME = "IMAGE URL";

	/** The Image url. */
	private String mImageUrl;

	@Inject
	private DownloadManager mDownloadManager;

	@Override
	public void onActivityCreated() {
		super.onActivityCreated();

		mImageUrl = getView().getViewActivity().getIntent()
				.getStringExtra(IMAGE_URL_PARAM_NAME);

		if (TextUtils.isEmpty(mImageUrl)) {
			getView().finish();
		}
	}

	@Override
	public void onResume() {
		super.onResume();

		mDownloadManager.startDownloadImageWithOutCache(getView()
				.getImageView(), mImageUrl);

	}
}
