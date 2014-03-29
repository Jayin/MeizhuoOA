package org.meizhuo.mzoa.app.ui.fragment;

import org.meizhuo.mzoa.app.R;
import org.meizhuo.mzoa.app.utils.AndroidUtils;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class About extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_about, container, false);
		try {
			String versionName = AndroidUtils.getAppVersionName(getActivity());
			((TextView) v.findViewById(R.id.tv_versionCode))
					.setText("版本: "+versionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return v;
	}

}
