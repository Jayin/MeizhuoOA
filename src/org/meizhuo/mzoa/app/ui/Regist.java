package org.meizhuo.mzoa.app.ui;

import org.meizhuo.mzoa.app.R;

import android.os.Bundle;
import android.view.MenuItem;

public class Regist extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_regist);
		initData();
		initLayout();
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initLayout() {
          getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			closeActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
