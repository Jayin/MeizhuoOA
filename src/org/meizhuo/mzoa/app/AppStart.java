package org.meizhuo.mzoa.app;

import org.meizhuo.mzoa.app.ui.BaseActivity;
import org.meizhuo.mzoa.app.ui.Main;

import android.os.Bundle;
import android.os.Handler;

public class AppStart extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_appstart);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				openActivity(Main.class);
				closeActivity();
			}
		}, 1500);
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initLayout() {

	}

}
