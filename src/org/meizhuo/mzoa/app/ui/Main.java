package org.meizhuo.mzoa.app.ui;

import org.meizhuo.mzoa.app.R;
import org.meizhuo.mzoa.app.ui.fragment.About;
import org.meizhuo.mzoa.app.ui.fragment.DrawerMain;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends BaseActivity {
	private String DafaultTitle = "Meizhuo OA";
	private String MenuTitle = "Menu";
	private FragmentManager manager = getSupportFragmentManager();
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ActionBar mActionBar;
	private Menu mMenu;
	public static final String[] menuName = { "签到", "任务", "讨论", "日程", "动态",
			"个人", "关于" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		initData();
		initLayout();
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initLayout() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerLayout.setDrawerListener(new MyDrawerListener());
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		// init the action bar to Display
		mActionBar = getActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setHomeButtonEnabled(true);
		setActionBarTitle(DafaultTitle);
		manager.beginTransaction().add(R.id.container, new About(), "About")
				.commit();
		
		manager.beginTransaction().add(R.id.left_container, new DrawerMain(),"DrawerMain").commit();
	}

	public void setMainContent(Fragment fragment) {
		mDrawerLayout.closeDrawers();
		// You need to pop some stacks in case setMainContent called after
		// addMainContent
		getSupportFragmentManager().popBackStack();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
	}
	
	public void setActionBarTitle(String title){
		mActionBar.setTitle(title);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mDrawerLayout.closeDrawers();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// handler the select...
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mMenu = menu;
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	private class MyDrawerListener implements DrawerLayout.DrawerListener {
		@Override
		public void onDrawerOpened(View drawerView) {
			mDrawerToggle.onDrawerOpened(drawerView);
			mMenu.findItem(R.id.action_more).setVisible(false);
			mActionBar.setTitle(MenuTitle);
		}

		@Override
		public void onDrawerClosed(View drawerView) {
			mDrawerToggle.onDrawerClosed(drawerView);
			mMenu.findItem(R.id.action_more).setVisible(true);
			mActionBar.setTitle(DafaultTitle);
		}

		@Override
		public void onDrawerSlide(View drawerView, float slideOffset) {
			mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
		}

		@Override
		public void onDrawerStateChanged(int newState) {
			mDrawerToggle.onDrawerStateChanged(newState);
		}
	}

}
