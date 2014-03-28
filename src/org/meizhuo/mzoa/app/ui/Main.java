package org.meizhuo.mzoa.app.ui;

import org.meizhuo.mzoa.app.R;
import org.meizhuo.mzoa.app.ui.fragment.About;
import org.meizhuo.mzoa.app.ui.fragment.CheckIn;
import org.meizhuo.mzoa.app.ui.fragment.Communication;
import org.meizhuo.mzoa.app.ui.fragment.Personal;
import org.meizhuo.mzoa.app.ui.fragment.Schedule;
import org.meizhuo.mzoa.app.ui.fragment.Task;
import org.meizhuo.mzoa.app.ui.fragment.Trending;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends BaseActivity {
	private String DafaultTitle = "Meizhuo OA";
	private String MenuTitle = "Menu";
	private FragmentManager manager = getSupportFragmentManager();
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawer;
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
		mDrawer = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerListener(new MyDrawerListener());
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawer.setAdapter(new DrawerAdapter());
		mDrawer.setOnItemClickListener(new DrawerItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		// init the action bar to Display
		mActionBar = getActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setHomeButtonEnabled(true);
		mActionBar.setTitle(DafaultTitle);
		manager.beginTransaction().add(R.id.container, new About(), "About").commit();
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
		mMenu  = menu;
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			mDrawerLayout.closeDrawer(mDrawer);
			FragmentTransaction transaction = manager.beginTransaction();
			switch (position) {
			case 0: // 签到
				transaction.replace(R.id.container, new CheckIn(), "CheckIn");
				break;
			case 1: // 任务
				transaction.replace(R.id.container, new Task(), "Task");
				break;
			case 2: // 讨论
				transaction.replace(R.id.container, new Communication(),
						"Communication");
				break;
			case 3: // 日程
				transaction.replace(R.id.container, new Schedule(), "Schedule");
				break;
			case 4: // 动态
				transaction.replace(R.id.container, new Trending(), "Trending");
				break;
			case 5: // 个人
				transaction.replace(R.id.container, new Personal(), "Personal");
				break;
			case 6: // 关于
				transaction.replace(R.id.container, new About(), "About");
				break;
			default:
				break;
			}
			transaction.commit();
		}
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

	private class DrawerAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return menuName.length;
		}

		@Override
		public Object getItem(int position) {
			return menuName[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder h = null;
			if (convertView == null) {
				h = new ViewHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.item_lv_leftdrawer, null);
				h.menuName = (TextView) convertView
						.findViewById(R.id.tv_menuName);
				convertView.setTag(h);
			} else {
				h = (ViewHolder) convertView.getTag();
			}
			h.menuName.setText(menuName[position]);
			return convertView;
		}

		private class ViewHolder {
			TextView menuName;
		}
	}
}
