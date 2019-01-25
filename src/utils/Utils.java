package utils;

import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

public class Utils {

	public static final int TEAM_SIZE = 5;

	public static Bitmap getBitmapFromAsset(String strName, Context c)	{
		Bitmap bitmap = null;
		try {
			AssetManager assetManager = c.getAssets();
			InputStream istr = assetManager.open("squares/"+strName);
			bitmap = BitmapFactory.decodeStream(istr);
		}
		catch(Exception e) {
			e.printStackTrace();
			Log.w("Utils", e.toString());			
		}
		return bitmap;
	}

	public static String fromMStoS(long ms) {
		int seconds = (int) (ms / 1000) % 60 ;
		int minutes = (int) ((ms / (1000*60)) % 60);
		
		if (seconds > 10)
			return Integer.toString(minutes) + ":"+Integer.toString(seconds).charAt(0)+""+Integer.toString(seconds).charAt(1);
		else if (seconds > 0)
			return Integer.toString(minutes) + ":"+Integer.toString(0)+""+Integer.toString(seconds).charAt(0);
		else 
			return Integer.toString(minutes) + ":"+Integer.toString(0)+""+Integer.toString(0);
	}

	public static void showToast(String text, Context c) {
		Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
	}
}
