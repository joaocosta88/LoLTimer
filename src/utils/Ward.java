package utils;

import com.layla.loltimer.R;

import android.content.Context;
import android.support.v4.view.ViewPager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Ward {
	private float x;
	private float y;
	
	private float timeRemaining = 0;

	private RelativeLayout ward;

	public static final int WARD_TIME_MS = 18000;

	public static final int WARD_MARGIN_HEIGHT = 100;
	public static final int WARD_MARGIN_WIDTH =100;
	public static final int WARD_HEIGHT = 64;
	public static final int WARD_WIDTH = 64;


	public Ward(float x, float y, Context context) {
		this.x = x;
		this.y = y;
		ward = new RelativeLayout(context);
		
		ImageView iv = new ImageView(context);
		iv.setImageResource(R.drawable.sight_ward);

		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		iv.setX(x - WARD_HEIGHT/2);
		iv.setY(y - WARD_WIDTH/2);

		ward.addView(iv, lp);
		
		timeRemaining = WARD_TIME_MS;
	}

	public boolean stillActive() {
		return timeRemaining > 0;
	}
	
	public float getTimeRemaining() {
		return timeRemaining;
	}
	
	public void setTimeRemaining(float time) {
		timeRemaining = time;
	}
	
	public void decrementTimeRemaining(float delta) {
		timeRemaining -= delta;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public boolean sameWard(float wardX, float wardY) {
		return ((wardX < (x + WARD_MARGIN_WIDTH)) 
				&& (wardX > (x - WARD_MARGIN_WIDTH))
				&& (wardY > (y - WARD_MARGIN_HEIGHT))
				&& (wardY <  (y + WARD_MARGIN_HEIGHT)));	
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setNewPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public RelativeLayout getWardLayout() {
		return ward;
	}
	
	public void setWardLayout(RelativeLayout ward) {
		this.ward = ward;
	}
}
