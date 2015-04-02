package com.mika.cheggmeout.ui.controllers.interfaces;

import com.mika.cheggmeout.dtos.Data;
import com.mika.cheggmeout.ui.views.interfaces.IMainView;

public interface IMainController extends IBaseController<IMainView>{

	/**
	 * On data selected.
	 *
	 * @param selcetedData the selceted data
	 */
	public void onDataSelected(Data selcetedData);

}
