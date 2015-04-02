package com.mika.cheggmeout.ui.views.interfaces;

import java.util.List;

import com.mika.cheggmeout.dtos.Data;

/**
 * The Interface IMainView.
 */
public interface IMainView extends IBaseView {

	/**
	 * Update photos.
	 * 
	 * @param dataCollection
	 *            the data collection
	 */
	public void updatePhotos(List<Data> dataCollection);

}
