package utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class UltimatesTable {

	private static SQLiteDatabase database;
	private static DBHelper dbHelper;
	private static String[] allColumns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_CHAMP, DBHelper.COLUMN_COOLDOWN, DBHelper.COLUMN_CHAMP_IMG};
	
	
	public UltimatesTable(Context context) {
		dbHelper = DBHelper.getSingletonObject(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public long addUltimate(ContentValues initialValues) {
		ContentValues values;
		if (initialValues == null)
			values = new ContentValues();
		else
			values = initialValues;

		long insertId = database.insert(DBHelper.TABLE_ULTIMATES, null, values);

		Cursor cursor = database.query(DBHelper.TABLE_ULTIMATES, allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,null, null, null);
		cursor.moveToFirst();
		return insertId;
	}
	
	public Cursor getUltimate(long id) {
		Cursor cursor = database.query(DBHelper.TABLE_ULTIMATES, allColumns, DBHelper.COLUMN_ID +" = "+ id, null, null, null, null);
		return cursor;
	}
	
	public Cursor getUltimate(String champName) {
		Cursor cursor = database.query(DBHelper.TABLE_ULTIMATES, allColumns, DBHelper.COLUMN_CHAMP +" = "+ champName, null, null, null, null);
		return cursor;
	}
	
	public Cursor fetchAllData() {
		return database.rawQuery("SELECT * FROM "+DBHelper.TABLE_ULTIMATES+" ORDER BY "+DBHelper.COLUMN_CHAMP+" ASC", null);
	}
}
