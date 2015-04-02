package com.mika.cheggmeout.ui.views;

import roboguice.inject.InjectView;
import android.widget.ImageView;

import com.google.inject.Inject;
import com.mika.cheggmeout.R;
import com.mika.cheggmeout.ui.controllers.interfaces.IDisplayImageController;
import com.mika.cheggmeout.ui.views.interfaces.IDisplayImageView;

public class DisplayImageView extends
		BaseView<IDisplayImageController, IDisplayImageView> implements
		IDisplayImageView {

	@Inject
	private IDisplayImageController mController;

	/** The Image view. */
	@InjectView(R.id.image)
	private ImageView mImageView;

	@Override
	public IDisplayImageController getController() {
		return mController;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.view_image;
	}

	@Override
	public ImageView getImageView() {
		return mImageView;
	}

}
