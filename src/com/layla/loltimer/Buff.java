package com.layla.loltimer;

import android.util.Log;

public class Buff {
	
	private final String TAG = "Buff";

	public final static int TYPE_BARON = 0;
	public final static int TYPE_DRAKE = 1;
	public final static int TYPE_BUFF = 2;

	public final static int BUFFS_TIME_MS = 300000;
	public final static int DRAKE_TIME_MS = 360000;
	public final static int BARON_TIME_MS = 420000;

	private int timeRemaining = 0;
	private int id;

	public Buff(int id, int type) {
		this.id = id;

		switch (type) {
		case TYPE_BARON:
			timeRemaining = BARON_TIME_MS;
			break;
		case TYPE_DRAKE:
			timeRemaining = DRAKE_TIME_MS;
			break;
		case TYPE_BUFF:
			timeRemaining = BUFFS_TIME_MS;
			break;
		default:
			Log.w(TAG, "went to default");
		}
	}

	public boolean isActive() {
		return timeRemaining > 0;
	}

	public int getId() {
		return id;
	}

	public void decrementTimeRemaining(int delta) {
		timeRemaining -= delta;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}
}
