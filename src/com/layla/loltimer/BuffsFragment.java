package com.layla.loltimer;

import utils.ResourcesManager;
import utils.Utils;
import android.opengl.Visibility;
import android.os.Bundle;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BuffsFragment extends Fragment{

	private final static String TAG = "BuffsFragment";

	private static View rootView = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		rootView = inflater.inflate(R.layout.fragment_buffs,
				container, false);

		initClickListener();

		return rootView;	
	}

	public class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			ResourcesManager.activateBuff(v.getId(), (Integer) v.getTag());
			activateBuff(v.getId());
			ResourcesManager.startHandler();
		}
	}
	
	private void activateBuff(int id) {
		TextView tv = null;
		switch(id) {
		case R.id.baron:
			Log.w(TAG, "activating baron");
			tv = (TextView) rootView.findViewById(R.id.tv_baron);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.drake:
			tv = (TextView) rootView.findViewById(R.id.tv_drake);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.e_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_e_blue);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.e_red:
			tv = (TextView) rootView.findViewById(R.id.tv_e_red);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.my_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_my_blue);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.my_red:
			tv = (TextView) rootView.findViewById(R.id.tv_my_red);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		}
	}

	private void initClickListener() {
		ImageView iv = null;
		iv = (ImageView) rootView.findViewById(R.id.drake);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_DRAKE);

		iv = (ImageView) rootView.findViewById(R.id.baron);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_BARON);

		iv = (ImageView) rootView.findViewById(R.id.my_red);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_BUFF);

		iv = (ImageView) rootView.findViewById(R.id.e_red);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_BUFF);

		iv = (ImageView) rootView.findViewById(R.id.my_blue);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_BUFF);

		iv = (ImageView) rootView.findViewById(R.id.e_blue);
		iv.setOnClickListener(new ClickListener());
		iv.setTag(Buff.TYPE_BUFF);
	}

	public static void disableBuff(int id) {
		TextView tv = null;
		switch(id) {
		case R.id.baron:
			tv = (TextView) rootView.findViewById(R.id.tv_baron);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case R.id.drake:
			tv = (TextView) rootView.findViewById(R.id.tv_drake);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case R.id.e_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_e_blue);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case R.id.e_red:
			tv = (TextView) rootView.findViewById(R.id.tv_e_red);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case R.id.my_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_my_blue);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case R.id.my_red:
			tv = (TextView) rootView.findViewById(R.id.tv_my_red);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		}

	}

	public static void updateBuffTimer(int id) {
		TextView tv = null;
		switch(id) {
		case R.id.baron:
			tv = (TextView) rootView.findViewById(R.id.tv_baron);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.drake:
			tv = (TextView) rootView.findViewById(R.id.tv_drake);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.e_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_e_blue);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.e_red:
			tv = (TextView) rootView.findViewById(R.id.tv_e_red);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.my_blue:
			tv = (TextView) rootView.findViewById(R.id.tv_my_blue);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		case R.id.my_red:
			tv = (TextView) rootView.findViewById(R.id.tv_my_red);
			tv.setText(ResourcesManager.getBuffTimeRemaining(id));
			break;
		}
	}
}
