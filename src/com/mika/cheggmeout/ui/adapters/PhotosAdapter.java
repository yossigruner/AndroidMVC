package com.mika.cheggmeout.ui.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mika.cheggmeout.R;
import com.mika.cheggmeout.dtos.Data;
import com.mika.cheggmeout.managers.DownloadManager;
import com.mika.cheggmeout.utils.image.filters.CropImageCenterAndAddOverlayFilter;
import com.mika.cheggmeout.utils.image.filters.IImageFilter;

public class PhotosAdapter extends ArrayAdapter<Data> {

	/** holds a layout inflater to inflate a ride view */
	private LayoutInflater mLayoutInflater;

	/** The Download manager. */
	private DownloadManager mDownloadManager;

	private IImageFilter mCropCenterImageFilter;

	public PhotosAdapter(Context context, List<Data> objects,
			DownloadManager downloadManager) {
		super(context, -1, objects);
		mDownloadManager = downloadManager;
		mLayoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mCropCenterImageFilter = new CropImageCenterAndAddOverlayFilter();
	}

	// @Override
	// public int getCount() {
	// return super.getCount() + 1;
	// }

	@Override
	public View getView(int position, View eventView, ViewGroup parent) {

		// if (position == super.getCount()) {
		//
		// return mLayoutInflater.inflate(R.layout.adapter_loading_more,
		// parent, false);
		// }

		dataViewHolder viewHolder;

		// in case a previously used event view doesn't exist
		if (eventView == null) {
			eventView = mLayoutInflater.inflate(R.layout.list_item_view,
					parent, false);

			viewHolder = new dataViewHolder();

			// sets driver name
			viewHolder.userName = (TextView) eventView
					.findViewById(R.id.name_textView);
			viewHolder.dataTextTime = (TextView) eventView
					.findViewById(R.id.text_textView);
			viewHolder.dataImage = (ImageView) eventView
					.findViewById(R.id.image_imageView);

			viewHolder.userImage = (ImageView) eventView
					.findViewById(R.id.user_imageView);

			eventView.setTag(viewHolder);

		} else {
			viewHolder = (dataViewHolder) eventView.getTag();
		}

		Data data = getItem(position);

		viewHolder.userImage.setImageResource(R.drawable.ic_launcher);
		viewHolder.dataImage.setImageResource(R.drawable.ic_launcher);

		viewHolder.dataTextTime.setText(data.getCaption().getText());
		viewHolder.userName.setText(data.getProfile().getUsername());

		mDownloadManager.startDownloadImage(viewHolder.userImage, data
				.getProfile().getProfilePicture());

		mDownloadManager.startDownloadImage(viewHolder.dataImage, data
				.getImages().getStandardResolution().getUrl(),
				mCropCenterImageFilter);

		return eventView;

	}

	static class dataViewHolder {

		TextView userName;
		ImageView userImage;
		TextView dataTextTime;
		ImageView dataImage;

	}

}
