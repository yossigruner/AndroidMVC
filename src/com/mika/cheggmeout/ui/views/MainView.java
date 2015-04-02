package com.mika.cheggmeout.ui.views;

import java.util.List;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.inject.Inject;
import com.mika.cheggmeout.R;
import com.mika.cheggmeout.dtos.Data;
import com.mika.cheggmeout.managers.DownloadManager;
import com.mika.cheggmeout.ui.adapters.PhotosAdapter;
import com.mika.cheggmeout.ui.controllers.interfaces.IMainController;
import com.mika.cheggmeout.ui.views.interfaces.IMainView;

public class MainView extends BaseView<IMainController, IMainView> implements
		IMainView, OnItemClickListener {

	@Inject
	private IMainController mMainController;

	@Inject
	private DownloadManager mDownloadManager;

	@InjectView(R.id.photos_listview)
	private ListView mPhotoListView;

	private PhotosAdapter mPhotosAdapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mPhotoListView.setOnItemClickListener(this);

	}

	@Override
	public IMainController getController() {
		return mMainController;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.view_main;
	}

	@Override
	public void updatePhotos(List<Data> dataCollection) {
		mPhotosAdapter = new PhotosAdapter(getActivity(), dataCollection,
				mDownloadManager);
		mPhotoListView.setAdapter(mPhotosAdapter);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Data selcetedData = (Data) mPhotoListView.getItemAtPosition(position);
		mMainController.onDataSelected(selcetedData);
		
	}

}
