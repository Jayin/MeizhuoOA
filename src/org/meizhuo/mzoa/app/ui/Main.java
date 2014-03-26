package org.meizhuo.mzoa.app.ui;

import org.meizhuo.mzoa.app.R;
import org.meizhuo.mzoa.app.utils.AndroidUtils;
import android.os.Bundle;
import android.view.View;

public class Main extends BaseActivity {
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		initData();
		initLayout();
	}

	@Override
	protected void initData() {
		int width = AndroidUtils.getScreenSize(getContext())[0];
	   debug("width = "+width);
	}

	@Override
	protected void initLayout() {
		_getView(R.id.btn_more).setOnClickListener(this);
	 
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_more:
			toast("fuck!");
			break;

		default:
			break;
		}
	}

	 
}
