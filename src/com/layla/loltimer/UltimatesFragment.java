package com.layla.loltimer;

import java.util.ArrayList;

import utils.ResourcesManager;
import utils.UltimatesTable;
import utils.Utils;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class UltimatesFragment extends Fragment{

	private final String TAG = "UltimatesFragment";
	
	private final int CHAMP_CHOOSER_ACT = 1;

	static View rootView = null;
	Bitmap emptyThumbnail = null;
	ArrayList<ImageView> thumbnails = new ArrayList<ImageView>();


	public UltimatesFragment() {
		if (ResourcesManager.ultimatesCount() == 0)
			ResourcesManager.populateUltimates();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		if (rootView == null)
			rootView = inflater.inflate(R.layout.fragment_ultimates,
					container, false);

		if (thumbnails.size() == 0)
			initThumbnails();
		loadThumbnails();

		return rootView;
	}

	public class LongClickListener implements OnLongClickListener {

		@Override
		public boolean onLongClick(View v) {
			Intent i = new Intent(getActivity(), ChampionChooser.class);
			i.putExtra("ViewTag", (Integer) v.getTag());
			startActivityForResult(i, CHAMP_CHOOSER_ACT);
			return true;
		}

	}


	public class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int tag = (Integer) v.getTag();

			if (ResourcesManager.getUltimate(tag) == null)
				Utils.showToast("Long click to select champion", getActivity());
			else { 
				ResourcesManager.activateUltimate((Integer)v.getTag());
				ResourcesManager.startHandler();
			}
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		loadThumbnails();
	}

	private void loadThumbnails() {
		for(int i = 0; i < Utils.TEAM_SIZE; i++) {
			Ultimate ultimate = ResourcesManager.getUltimate(i);
			ImageView img = thumbnails.get(i);
			if (ultimate != null) {
				Log.w("UltiFrag", ultimate.getChamp());
				Bitmap ultimateImage = Utils.getBitmapFromAsset(ultimate.getImg()+".jpg", getActivity().getApplicationContext());
				img.setImageBitmap(ultimateImage);
			}
			else
				img.setImageBitmap(emptyThumbnail);
		}		
	}

	private void initThumbnails() {
		emptyThumbnail = Utils.getBitmapFromAsset("empty.png", getActivity());

		ImageView img = (ImageView) rootView.findViewById(R.id.thumbnail1);
		img.setTag(0);
		img.setOnClickListener(new ClickListener());
		img.setOnLongClickListener(new LongClickListener());
		thumbnails.add(img);

		img = (ImageView) rootView.findViewById(R.id.thumbnail2);
		img.setTag(1);
		img.setOnClickListener(new ClickListener());
		img.setOnLongClickListener(new LongClickListener());
		thumbnails.add(img);

		img = (ImageView) rootView.findViewById(R.id.thumbnail3);
		img.setTag(2);
		img.setOnClickListener(new ClickListener());
		img.setOnLongClickListener(new LongClickListener());
		thumbnails.add(img);

		img = (ImageView) rootView.findViewById(R.id.thumbnail4);
		img.setTag(3);
		img.setOnClickListener(new ClickListener());
		img.setOnLongClickListener(new LongClickListener());
		thumbnails.add(img);

		img = (ImageView) rootView.findViewById(R.id.thumbnail5);
		img.setTag(4);
		img.setOnClickListener(new ClickListener());
		img.setOnLongClickListener(new LongClickListener());
		thumbnails.add(img);
	}
	
	public static void updateUltimateTimer(int index) {
		TextView tv = null;
		switch(index) {
		case 0:
			tv = (TextView) rootView.findViewById(R.id.tv_ult1);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getUltimateTimeRemaining(index));
			break;
		case 1:
			tv = (TextView) rootView.findViewById(R.id.tv_ult2);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getUltimateTimeRemaining(index));
			break;
		case 2:
			tv = (TextView) rootView.findViewById(R.id.tv_ult3);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getUltimateTimeRemaining(index));
			break;
		case 3:
			tv = (TextView) rootView.findViewById(R.id.tv_ult4);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getUltimateTimeRemaining(index));
			break;
		case 4:
			tv = (TextView) rootView.findViewById(R.id.tv_ult5);
			tv.setVisibility(TextView.VISIBLE);
			tv.setText(ResourcesManager.getUltimateTimeRemaining(index));
			break;
		}
	}
	
	public static void disableUltimate(int index) {
		TextView tv = null;
		switch(index) {
		case 0:
			tv = (TextView) rootView.findViewById(R.id.tv_ult1);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case 1:
			tv = (TextView) rootView.findViewById(R.id.tv_ult2);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case 2:
			tv = (TextView) rootView.findViewById(R.id.tv_ult3);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case 3:
			tv = (TextView) rootView.findViewById(R.id.tv_ult4);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		case 4:
			tv = (TextView) rootView.findViewById(R.id.tv_ult5);
			tv.setVisibility(TextView.INVISIBLE);
			break;
		}
	}
}
