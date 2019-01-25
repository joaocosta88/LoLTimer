package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.layla.loltimer.Buff;
import com.layla.loltimer.BuffsFragment;
import com.layla.loltimer.Ultimate;
import com.layla.loltimer.UltimatesFragment;
import com.layla.loltimer.WardsFragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.util.Log;

public class ResourcesManager {
	
	private static final String TAG = "ResourcesManager";
	
	//list de posiçoes <x,y>
	private static ArrayList<Ward> wards = new ArrayList<Ward>(3);
	private static List<Ultimate> ultimates = Collections.synchronizedList(new ArrayList<Ultimate>());
	private static Map<Integer, Buff> buffs = Collections.synchronizedMap(new HashMap<Integer, Buff>());

	public static final int UPDATE_TIME_MS = 100;

	public static Handler UIUpdaterHanlder = null;

	public static Ward getWard(int index) {
		return wards.get(index);
	}

	public static int hasWard(float x, float y) {
		for(int i = 0; i < wards.size(); i++) {
			if (wards.get(i).sameWard(x, y))
				return i;
		}

		return -1;
	}

	public static void addWard(Ward ward) {
		wards.add(ward);
	}

	public static void addWard(float x, float y, Context context) {
		wards.add(new Ward(x, y, context));
	}

	public static int removeWard(float x, float y) {
		for(int i = 0; i < wards.size(); i++) {
			if	(wards.get(i).sameWard(x, y)) {
				wards.remove(i);
				return i;
			}
		}

		return -1;
	}

	public static void removeWard(int index) {
		wards.remove(index);
	}

	//Returns false if champion is already added
	public static boolean addUltimate(long id, int pos, Context context) {

		if (ultimatesContains(id))
			return false;
		else {
			//remove old
			UltimatesFragment.disableUltimate(pos);
			
			//add new
			UltimatesTable table = new UltimatesTable(context);
			table.open();
			Cursor c = table.getUltimate(id);
			Ultimate ultimate = new Ultimate(c);
			ultimates.set(pos, ultimate);
			c.close();
			table.close();
		}

		return true;
	}

	private static boolean ultimatesContains(long id) {
		for (Ultimate ultimate: ultimates)
			if (ultimate != null)
				if (ultimate.getId() == id)
					return true;

		return false;
	}

	public static int ultimatesCount() {
		return ultimates.size();	
	}

	public static Ultimate getUltimate(int pos) {		
		return ultimates.get(pos) ;
	}

	public static String getUltimateTimeRemaining(int pos) {
		return Utils.fromMStoS(ultimates.get(pos).getTimeRemaining());
	}

	public static void populateUltimates() {
		for(int i = 0; i < Utils.TEAM_SIZE; i++)
			ultimates.add(null);	
	}

	public static void activateUltimate(int pos) {
		ultimates.get(pos).activateUltimate();
	}
	
	public static void activateBuff(int id, int type) {
		Buff buff = new Buff(id, type);
		buffs.put(id, buff);
	}

	public final static Runnable GUIUpdateRunnable = new Runnable() {
		public void run() {
			//call the activity method that updates the UI
			updateWards();
			updateUltimates();
			updateBuffs();
			UIUpdaterHanlder.postDelayed(GUIUpdateRunnable, UPDATE_TIME_MS);
		}
	};

	public static void updateUltimates() {
		for (int i = 0; i < ultimates.size(); i++) {
			Ultimate ultimate = ultimates.get(i);
			if (ultimate != null) {
				ultimate.decrementTimeRemaining(UPDATE_TIME_MS);
				if (ultimate.stillActive()) 
					UltimatesFragment.updateUltimateTimer(i);
				else  {
					UltimatesFragment.disableUltimate(i);
				}
			}
		}
	}

	public static void updateWards() {
		for(int i = 0; i < wards.size(); i++) {
			Ward ward = wards.get(i);
			ward.decrementTimeRemaining(UPDATE_TIME_MS);
			if (!ward.stillActive())
				WardsFragment.removeWard(i);
		}
	}

	public static void updateBuffs() {
		for (Map.Entry<Integer ,Buff> entry : buffs.entrySet()) {
			Buff buff = entry.getValue();
			buff.decrementTimeRemaining(UPDATE_TIME_MS);
			if (buff.isActive())
				BuffsFragment.updateBuffTimer(buff.getId());
			else {
				BuffsFragment.disableBuff(buff.getId());
				buffs.remove(buff.getId());
			}
		}
	}

	public static void startHandler() {
		if (UIUpdaterHanlder == null) {
			UIUpdaterHanlder = new Handler();
			UIUpdaterHanlder.postDelayed(ResourcesManager.GUIUpdateRunnable, UPDATE_TIME_MS);
		}
	}

	public static String getBuffTimeRemaining(int id) {
		Buff buff = buffs.get(id);
		return Utils.fromMStoS(buff.getTimeRemaining());
	}
}

