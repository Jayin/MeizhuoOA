package org.meizhuo.mzoa.app.ui.adapter;

import org.meizhuo.mzoa.app.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {
	String[] menuName = null;
	private Context context;

	public DrawerAdapter(Context context, String[] menuName) {
		this.context = context;
		this.menuName = menuName;
	}

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
			convertView = LayoutInflater.from(context).inflate(
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
