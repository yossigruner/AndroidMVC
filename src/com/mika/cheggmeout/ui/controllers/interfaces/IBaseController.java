package com.mika.cheggmeout.ui.controllers.interfaces;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.mika.cheggmeout.ui.views.interfaces.IBaseView;

/**
 * The Interface IBaseController.
 * 
 * @param <T>
 *            the generic type
 */
public interface IBaseController<T extends IBaseView> {

	/**
	 * Sets the view.
	 * 
	 * @param view
	 *            the new view
	 */
	public void setView(T view);

	/**
	 * On attach.
	 */
	public void onAttach();

	/**
	 * On activity create.
	 */
	public void onCreate();

	/**
	 * On create view.
	 */
	public void onCreateView();

	/**
	 * On view created.
	 * 
	 * @param view
	 *            the view
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	public void onViewCreated(View view, Bundle savedInstanceState);

	/**
	 * On activity created.
	 */
	public void onActivityCreated();

	/**
	 * On start.
	 */
	public void onStart();

	/**
	 * On resume.
	 */
	public void onResume();

	/**
	 * On pause.
	 */
	public void onPause();

	/**
	 * On stop.
	 */
	public void onStop();

	/**
	 * On destroy view.
	 */
	public void onDestroyView();

	/**
	 * On destroy.
	 */
	public void onDestroy();

	/**
	 * On detach.
	 */
	public void onDetach();

	/**
	 * On activity result.
	 * 
	 * @param requestCode
	 *            the request code
	 * @param resultCode
	 *            the result code
	 * @param data
	 *            the data
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data);

	/**
	 * Gets the controller handler.
	 * 
	 * @return the controller handler
	 */
	public Handler getControllerHandler();

	/**
	 * Gets the view.
	 * 
	 * @return the view
	 */
	public T getView();

	/**
	 * Gets the context.
	 * 
	 * @return the context
	 */
	public Context getContext();

	void onDestoryView();
}
