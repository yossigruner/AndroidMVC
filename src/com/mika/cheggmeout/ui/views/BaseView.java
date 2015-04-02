/*
 * 
 */

package com.mika.cheggmeout.ui.views;

import roboguice.fragment.RoboFragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.inject.Inject;
import com.mika.cheggmeout.ui.activities.BaseActivity;
import com.mika.cheggmeout.ui.controllers.interfaces.IBaseController;
import com.mika.cheggmeout.ui.views.interfaces.IBaseView;

public abstract class BaseView<T extends IBaseController<V>, V extends IBaseView>
		extends RoboFragment implements IBaseView {

	/** The Context. */
	@Inject
	private Context mContext;

	/** The Base activity. */
	private BaseActivity mBaseActivity;

	/** The controller. */
	private T mController;

	/** The view. */
	private V mView;

	/** The m callback handler. */
	private Handler mCallbackHandler;

	/**
	 * Gets the controller.
	 * 
	 * @return the controller
	 */
	public abstract T getController();

	/**
	 * Gets the layout resource id.
	 * 
	 * @return the layout resource id
	 */
	public abstract int getLayoutResourceId();

	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mController = getController();
		mView = (V) this;

		mCallbackHandler = new Handler();
		mController.setView(mView);
		mController.onCreate();

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		mController.onActivityCreated();
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mController.onCreateView();

		int layoutResourceId = getLayoutResourceId();

		if (layoutResourceId == 0) {

			return super.onCreateView(inflater, container, savedInstanceState);
		} else {

			return inflater.inflate(layoutResourceId, container, false);
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mController.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onStart() {
		mController.onStart();
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mController.onResume();
	}

	@Override
	public void onPause() {
		mController.onPause();
		super.onPause();
	}

	@Override
	public void onStop() {
		mController.onStop();
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		mController.onDestoryView();
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		mController.onDestroy();
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		mController.onDetach();
		super.onDetach();
	}

	@Override
	public void setResultOK() {
		this.setResult(Activity.RESULT_OK);

	}

	@Override
	public void setResultOK(Intent intent) {
		this.setResult(Activity.RESULT_OK, intent);

	}

	@Override
	public void setResultCanceled() {
		this.setResult(Activity.RESULT_CANCELED);

	}

	@Override
	public int getResultOK() {
		return Activity.RESULT_OK;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		mController.onActivityResult(requestCode, resultCode, data);

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mBaseActivity = (BaseActivity) activity;

	}

	@Override
	public void finish() {
		mBaseActivity.finish();

	}

	@Override
	public void setResult(int resultCode) {
		mBaseActivity.setResult(resultCode);
	}

	@Override
	public void setResult(int resultCode, Intent data) {
		mBaseActivity.setResult(resultCode, data);
	}

	@Override
	public Activity getViewActivity() {
		return getActivity();
	}

	@Override
	public Handler getCallbackHandler() {
		return mCallbackHandler;
	}

}
