package com.layla.loltimer;

import utils.DBHelper;
import android.database.Cursor;
import android.util.Log;

public class Ultimate {
	private String champ;
	private long cooldown;
	private String img;
	private int id;

	private long timeRemaining;

	public Ultimate() {}

	public Ultimate(int id, String champ, long cooldown, String img) {
		this.id = id;
		this.champ = champ;
		this.cooldown = cooldown;
		this.img = img;	
	}

	public Ultimate(Cursor cursor) {
		try
		{
			cursor.moveToFirst();
			int champNameIndex = cursor.getColumnIndexOrThrow(DBHelper.COLUMN_CHAMP);
			int coolcownIndex = cursor.getColumnIndexOrThrow(DBHelper.COLUMN_COOLDOWN);
			int imgIndex = cursor.getColumnIndexOrThrow(DBHelper.COLUMN_CHAMP_IMG);
			this.champ = cursor.getString(champNameIndex);
			this.cooldown = cursor.getLong(coolcownIndex);
			this.img = cursor.getString(imgIndex);
		}
		catch (Exception e)
		{
			Log.e("Ultimate", e.toString());
			e.printStackTrace();
		}		
	}

	@Override
	public boolean equals(Object aUltimate) {
		if ( this == aUltimate ) return true;

		if ( !(aUltimate instanceof Ultimate) ) return false;
		
		Ultimate ultimate = (Ultimate) aUltimate;
		
		return (ultimate.id == id);
	}
	
	public void activateUltimate() {
		timeRemaining = cooldown;
	}

	public long getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(long time) {
		timeRemaining = time;
	}

	public void decrementTimeRemaining(long delta) {
		timeRemaining -= delta;
	}

	public String getChamp() {
		return champ;
	}

	public long getCooldown() {
		return cooldown;
	}

	public String getImg() {
		return img;
	}
	
	public long getId(){
		return id;
	}
	
	public boolean stillActive() {
		return timeRemaining > 0;
	}
}
