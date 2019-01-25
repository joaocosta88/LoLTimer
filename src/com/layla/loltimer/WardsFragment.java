package com.layla.loltimer;


import utils.ResourcesManager;
import utils.Utils;
import utils.Ward;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WardsFragment extends Fragment {

	private ImageView map = null;
	private static View rootView = null;

	private final String TAG = "WardsFragment";

	public WardsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		setHasOptionsMenu(true);

		rootView = inflater.inflate(R.layout.fragment_wards,
				container, false);

		map = (ImageView) rootView.findViewById(R.id.rift);		

		map.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				gestureDetector.onTouchEvent(event);				
				return true;
			}
		});

		return rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.add("Clean wards");
		super.onCreateOptionsMenu(menu, inflater);
	}

	SimpleOnGestureListener simpleOnGestureListener
	= new SimpleOnGestureListener(){		

		//to detected if was added "remove ward" overlay
		float xPos = -1;
		float yPos = -1;
		int index = -1;

		boolean deleted = false;

		@Override
		public boolean onDown(MotionEvent e) {
			float x = e.getX();
			float y = e.getY();
			index = ResourcesManager.hasWard(x, y);

			xPos = x;
			yPos = y;

			return true;			
		}		

		@Override
		public void onShowPress (MotionEvent e) {	
			if (index > -1) {
				RelativeLayout rl = ResourcesManager.getWard(index).getWardLayout();
				ImageView img = (ImageView) rl.getChildAt(0);

				if (img != null) {
					img.setPadding(10,10,10,10);
					final ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

					img.setBackgroundColor(Color.RED);
					rl.removeViewAt(0);
					rl.addView(img, params);
					ResourcesManager.getWard(index).setWardLayout(rl);
				}
			}
		}

		@Override
		public  boolean onSingleTapUp (MotionEvent e) {
			if (index != -1) {
				((ViewGroup) rootView.getParent()).removeView(ResourcesManager.getWard(index).getWardLayout());
				ResourcesManager.removeWard(index);
				Utils.showToast("Ward deleted", getActivity());
				deleted = true;
				index = -1;
			}
			return true;
		}

		@Override
		public boolean onSingleTapConfirmed(MotionEvent event) {
			if (deleted) {
				deleted = false;
				return true;			
			}

			if (index != -1) {
				((ViewGroup) rootView.getParent()).removeView(ResourcesManager.getWard(index).getWardLayout());
				ResourcesManager.removeWard(index);
				Utils.showToast("Ward deleted", getActivity());
			} else {
				Ward ward = new Ward(xPos, yPos, getActivity());
				ResourcesManager.addWard(ward);
				//returns null if x < 0 || y < 0
				((ViewGroup) rootView.getParent()).addView(ward.getWardLayout());
				ResourcesManager.startHandler();;
			}
			index = -1;

			return true;
		}		

		@Override
		public void onLongPress(MotionEvent e) {
			if (index != -1) {
				((ViewGroup) rootView.getParent()).removeView(ResourcesManager.getWard(index).getWardLayout());
				Utils.showToast("Ward deleted", getActivity());
				ResourcesManager.removeWard(xPos, yPos);
				index = -1;
			}
		}
	};

	public static void removeWard(int index) {
		((ViewGroup) rootView.getParent()).removeView(ResourcesManager.getWard(index).getWardLayout());
		ResourcesManager.removeWard(index);
	}

	GestureDetector gestureDetector
	= new GestureDetector(getActivity(), simpleOnGestureListener);
}


