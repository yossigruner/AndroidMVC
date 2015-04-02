package com.mika.cheggmeout.ui.controllers;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.google.inject.Inject;
import com.mika.cheggmeout.ui.controllers.interfaces.IBaseController;
import com.mika.cheggmeout.ui.views.interfaces.IBaseView;
import com.mika.cheggmeout.utils.IntentExtraParam;
import com.mika.cheggmeout.utils.IntentExtraParam.IntentParamType;

public abstract class BaseController<T extends IBaseView> implements IBaseController<T> {

	/** holds the tag for the class */
	private static final String TAG = BaseController.class.getSimpleName();

	/** The base view. */
	private T mBaseView;

	/** The Controller handler. */
	private Handler mControllerHandler;

	/** The Context. */
	@Inject
	private Context mContext;

	@Override
	public void setView(T view) {
		mBaseView = view;
		mControllerHandler = new Handler();
	}

	@Override
	public void onAttach() {
		Log.d(TAG, "onAttach");
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onCreateView() {
		Log.d(TAG, "onCreateView");
	}

	@Override
	public void onDestroyView() {
		Log.d(TAG, "onDestroyView");

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.d(TAG, "onViewCreated");
	}

	@Override
	public void onActivityCreated() {
		Log.d(TAG, "onActivityCreated");
	}

	@Override
	public void onStart() {
		Log.d(TAG, "onStart");
	}

	@Override
	public void onResume() {
		Log.d(TAG, "onResume");
	}

	@Override
	public void onPause() {
		Log.d(TAG, "onPause");
	}

	@Override
	public void onStop() {
		Log.d(TAG, "onStop");
	}

	@Override
	public void onDestoryView() {
		Log.d(TAG, "onDestoryView");
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
	}

	@Override
	public void onDetach() {
		Log.d(TAG, "onDetach");
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "onActivityResult");

	}

	@Override
	public Handler getControllerHandler() {
		return mControllerHandler;
	}

	@Override
	public T getView() {
		return mBaseView;
	}

	@Override
	public Context getContext() {
		return mContext;
	}

	/**
	 * Move to view.
	 * 
	 * @param ViewClass
	 *            the view class
	 */
	public void moveToView(Class<?> ViewClass) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);
		mBaseView.startActivity(startActivityIntent);
	}

	/**
	 * Move to view.
	 * 
	 * @param ViewClass
	 *            the view class
	 * @param name
	 *            the name
	 * @param data
	 *            the data
	 */
	public void moveToView(Class<?> ViewClass, String name, Parcelable data) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);
		startActivityIntent.putExtra(name, data);
		mBaseView.startActivity(startActivityIntent);
	}

	/**
	 * Move To View.
	 * 
	 * @param ViewClass
	 *            the view class
	 * @param extraParams
	 *            - a list of Extra parameters to add to the Intent
	 */
	public void moveToView(Class<?> ViewClass,
			List<IntentExtraParam<?>> extraParams) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);

		for (IntentExtraParam<?> intentExtraParam : extraParams) {

			IntentParamType intentParamType = intentExtraParam
					.getIntentParamType();

			switch (intentParamType) {
			case Int:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Integer) intentExtraParam.getParamValue());
				break;
			case Long:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Long) intentExtraParam.getParamValue());
				break;
			case Boolean:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Boolean) intentExtraParam.getParamValue());
				break;
			case Parcelable:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Parcelable) intentExtraParam.getParamValue());
				break;
			case Double:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Double) intentExtraParam.getParamValue());
				break;
			case Float:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Float) intentExtraParam.getParamValue());
				break;
			case String:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(String) intentExtraParam.getParamValue());
				break;
			default:
				Log.w(TAG, "Unrecognized intentParamType");
				break;

			}
		}
		mBaseView.startActivity(startActivityIntent);
	}

	/**
	 * Move to view for result.
	 * 
	 * @param ViewClass
	 *            the view class
	 * @param requestCode
	 *            the request code
	 * @param extraParams
	 *            the extra params
	 */
	public void moveToViewForResult(Class<?> ViewClass, int requestCode,
			List<IntentExtraParam<?>> extraParams) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);

		for (IntentExtraParam<?> intentExtraParam : extraParams) {

			IntentParamType intentParamType = intentExtraParam
					.getIntentParamType();

			switch (intentParamType) {
			case Int:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Integer) intentExtraParam.getParamValue());
				break;
			case Long:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Long) intentExtraParam.getParamValue());
				break;
			case Boolean:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Boolean) intentExtraParam.getParamValue());
				break;
			case Parcelable:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Parcelable) intentExtraParam.getParamValue());
				break;
			case Double:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Double) intentExtraParam.getParamValue());
				break;
			case Float:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(Float) intentExtraParam.getParamValue());
				break;
			case String:
				startActivityIntent.putExtra(intentExtraParam.getParamName(),
						(String) intentExtraParam.getParamValue());
				break;
			default:
				Log.w(TAG, "Unrecognized intentParamType");
				break;
			}
		}
		mBaseView.startActivityForResult(startActivityIntent, requestCode);
	}

	/**
	 * Move to view for result.
	 * 
	 * @param ViewClass
	 *            the view class
	 * @param requestCode
	 *            the request code
	 * @param name
	 *            the name
	 * @param data
	 *            the data
	 */
	public void moveToViewForResult(Class<?> ViewClass, int requestCode,
			String name, Parcelable data) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);
		startActivityIntent.putExtra(name, data);
		mBaseView.startActivityForResult(startActivityIntent, requestCode);
	}

	/**
	 * Move to view for result.
	 * 
	 * @param ViewClass
	 *            the view class
	 * @param options
	 *            the options
	 */
	public void moveToViewForResult(Class<?> ViewClass, int requestCode) {
		Intent startActivityIntent = new Intent(mContext, ViewClass);
		mBaseView.startActivityForResult(startActivityIntent, requestCode);
	}
}
