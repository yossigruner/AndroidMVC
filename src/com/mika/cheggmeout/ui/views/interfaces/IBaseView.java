
package com.mika.cheggmeout.ui.views.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public interface IBaseView {

	/**
	 * Finish and close the current activity.
	 */
	public void finish();

	/**
	 * Start activity for result.
	 * 
	 * @param intent the intent
	 * @param requestCode the request code
	 */
	public void startActivityForResult(Intent intent, int requestCode);

	/**
	 * Start activity.
	 * 
	 * @param intent the intent
	 */
	public void startActivity(Intent intent);

	/**
	 * Sets the result.
	 * 
	 * @param resultCode the new result
	 */
	public void setResult(int resultCode);

	/**
	 * Sets the result.
	 * 
	 * @param resultCode the result code
	 * @param data the data
	 */
	public void setResult(int resultCode, Intent data);

	/**
	 * Gets the result OK.
	 * 
	 * @return the result OK
	 */
	int getResultOK();

	/**
	 * Sets the result OK.
	 */
	public void setResultOK();

	/**
	 * Sets the result OK.
	 * 
	 * @param intent the new result OK
	 */
	public void setResultOK(Intent intent);

	/**
	 * Sets the result canceled.
	 */
	public void setResultCanceled();

	/** get the activity containing this view */
	public Activity getViewActivity();

	/**
	 * Gets the callback handler.
	 * 
	 * @return the callback handler
	 */
	public Handler getCallbackHandler();

}
