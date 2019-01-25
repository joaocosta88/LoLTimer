package utils;

import com.layla.loltimer.R;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class ChampCursorAdapter extends CursorAdapter implements SectionIndexer {

	private AlphabetIndexer alphaIndexer;
	private Cursor c;
    private LayoutInflater mLayoutInflater;
    
    private int champColumnIndex;
    private int imgColumnIndex;

	static class ViewHolder {
	    public TextView text;
	    public ImageView image;
	  }
	
    public ChampCursorAdapter(Context context, Cursor c) {
		super(context, c, false);
		this.c = c;
        mLayoutInflater = LayoutInflater.from(context); 
        champColumnIndex = c.getColumnIndex(DBHelper.COLUMN_CHAMP);
        imgColumnIndex = c.getColumnIndex(DBHelper.COLUMN_CHAMP_IMG);
		alphaIndexer=new AlphabetIndexer(c, champColumnIndex, " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	@Override
	public int getPositionForSection(int section) {
		  return alphaIndexer.getPositionForSection(section);
	}

	@Override
	public int getSectionForPosition(int position) {
		 return alphaIndexer.getSectionForPosition(position);
	}

	@Override
	public Object[] getSections() {
		return alphaIndexer.getSections();
	}
	
	@Override
	public int getCount() {
		return c.getCount();
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		ViewHolder holder = (ViewHolder) view.getTag();
		
		holder.text.setText(cursor.getString(champColumnIndex));
		Bitmap bm = Utils.getBitmapFromAsset(cursor.getString(imgColumnIndex)+".jpg", context);
		holder.image.setImageBitmap(bm);
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		ViewHolder holder = new ViewHolder();

		View v = mLayoutInflater.inflate(R.layout.champ_row, null);
		holder.image = (ImageView) v.findViewById(R.id.champ_face);
		holder.text = (TextView) v.findViewById(R.id.champ_name);
		
        v.setTag(holder);

		return v;
	}
	
	
	
}
