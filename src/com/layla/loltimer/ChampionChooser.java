package com.layla.loltimer;

import utils.ChampCursorAdapter;
import utils.ResourcesManager;
import utils.UltimatesTable;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ChampionChooser extends ListActivity {
	
	int selectedImageView = -1;

	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		selectedImageView = extras.getInt("ViewTag");
		
		setContentView(R.layout.champ_chooser);

        getActionBar().setDisplayHomeAsUpEnabled(true);
		
		UltimatesTable table = new UltimatesTable(getApplicationContext());

		table.open();
		Cursor c = table.fetchAllData();

		setListAdapter(new ChampCursorAdapter(this, c));
		getListView().setFastScrollEnabled(true);
		getListView().setFastScrollAlwaysVisible(true);
		getListView().smoothScrollToPosition(0);
		table.close();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
		ResourcesManager.addUltimate(id, selectedImageView, getApplicationContext());
		finish();
	 }

}
