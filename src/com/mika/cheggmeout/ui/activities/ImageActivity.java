package com.mika.cheggmeout.ui.activities;

import roboguice.inject.ContentView;

import com.mika.cheggmeout.R;

@ContentView(R.layout.activity_image)
public class ImageActivity extends BaseActivity {

	public void onResume() {
		super.onResume();
		overridePendingTransition(R.anim.exitanim, R.anim.exitanim);
	}

}
