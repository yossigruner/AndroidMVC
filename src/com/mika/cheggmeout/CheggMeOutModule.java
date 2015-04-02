package com.mika.cheggmeout;

import com.google.inject.AbstractModule;
import com.mika.cheggmeout.ui.controllers.DisplayImageController;
import com.mika.cheggmeout.ui.controllers.MainController;
import com.mika.cheggmeout.ui.controllers.interfaces.IDisplayImageController;
import com.mika.cheggmeout.ui.controllers.interfaces.IMainController;
import com.mika.cheggmeout.utils.image.cache.IImageCache;
import com.mika.cheggmeout.utils.image.cache.MemoryImageCache;

public class CheggMeOutModule extends AbstractModule {

	@Override
	protected void configure() {

		bindControllers();

		bindUtils();

	}

	private void bindUtils() {
		bind(IImageCache.class).to(MemoryImageCache.class);
	}

	private void bindControllers() {
		bind(IMainController.class).to(MainController.class);
		bind(IDisplayImageController.class).to(DisplayImageController.class);
	}

}
