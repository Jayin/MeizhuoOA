package org.meizhuo.mzoa.app.ui.fragment;

import org.meizhuo.mzoa.app.R;
import org.meizhuo.mzoa.app.ui.Main;
import org.meizhuo.mzoa.app.ui.adapter.DrawerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class DrawerMain extends Fragment {
	public static final String[] menuName = { "签到", "任务", "讨论", "日程", "动态",
			"个人", "关于" };
	private Main mainActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mainActivity = (Main) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_drawermain, container,
				false);
		ListView lv = (ListView) v.findViewById(R.id.left_drawer);
		lv.setAdapter(new DrawerAdapter(mainActivity, menuName));
        lv.setOnItemClickListener(new DrawerItemClickListener());
		return v;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			switch (position) {
			case 0: // 签到
				mainActivity.setMainContent(new CheckIn());
				break;
			case 1: // 任务
				mainActivity.setMainContent(new Task());
				break;
			case 2: // 讨论
				mainActivity.setMainContent(new Communication());
				break;
			case 3: // 日程
				mainActivity.setMainContent(new Schedule());
				break;
			case 4: // 动态
				mainActivity.setMainContent(new Trending());
				break;
			case 5: // 个人
				mainActivity.setMainContent(new Personal());
				break;
			case 6: // 关于
				mainActivity.setMainContent(new About());
				break;
			default:
				break;
			}
		}
	}

}
