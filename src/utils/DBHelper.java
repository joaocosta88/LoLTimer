package utils;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

	private static DBHelper singletonDBHelper;

	private static final String DATABASE_NAME = "ultimates_table.db";
	private static final int DATABASE_VERSION = 5;

	public static final String TABLE_ULTIMATES = "ultimates";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CHAMP = "champion";
	public static final String COLUMN_COOLDOWN = "cooldown";
	public static final String COLUMN_CHAMP_IMG = "champ_img";

	private static final String DATABASE_CREATE = "create table " 
			+ TABLE_ULTIMATES
			+ "(" 
			+ COLUMN_ID + " integer primary key autoincrement, " 
			+ COLUMN_CHAMP + " text, " 
			+ COLUMN_COOLDOWN + " integer, " 
			+ COLUMN_CHAMP_IMG + " text "
			+ ");";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);

		List<ContentValues> ultimates = allUltimates();

		for(ContentValues value : ultimates)			
			db.insert(DBHelper.TABLE_ULTIMATES, null, value);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(UltimatesTable.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ULTIMATES);
		onCreate(db);	

	}

	private List<ContentValues> allUltimates() {

		List<ContentValues> mValueList = new ArrayList<ContentValues>();

		ContentValues values = new ContentValues();
		values.put(COLUMN_CHAMP, "Akali");
		values.put(COLUMN_COOLDOWN, 1000);
		values.put(COLUMN_CHAMP_IMG, "akali");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Aatrox");
		values.put(COLUMN_COOLDOWN, 70000);
		values.put(COLUMN_CHAMP_IMG, "aatrox");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Ahri");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "ahri");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Alistar");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "alistar");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Amumu");
		values.put(COLUMN_COOLDOWN, 110000);
		values.put(COLUMN_CHAMP_IMG, "amumu");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Anivia");
		values.put(COLUMN_COOLDOWN, 6000);
		values.put(COLUMN_CHAMP_IMG, "anivia");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Annie");
		values.put(COLUMN_COOLDOWN, 120000);
		values.put(COLUMN_CHAMP_IMG, "annie");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Ashe");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "ashe");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Blitzcrank");
		values.put(COLUMN_COOLDOWN, 30000);
		values.put(COLUMN_CHAMP_IMG, "blitz");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Brand");
		values.put(COLUMN_COOLDOWN, 75000);
		values.put(COLUMN_CHAMP_IMG, "brand");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Caitlyn");
		values.put(COLUMN_COOLDOWN, 60000);
		values.put(COLUMN_CHAMP_IMG, "caitlyn");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Cassiopeia");
		values.put(COLUMN_COOLDOWN, 110000);
		values.put(COLUMN_CHAMP_IMG, "cassiopeia");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Cho'Gath");
		values.put(COLUMN_COOLDOWN, 60000);
		values.put(COLUMN_CHAMP_IMG, "chogath");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Corki");
		values.put(COLUMN_COOLDOWN, 1200);
		values.put(COLUMN_CHAMP_IMG, "corki");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Darius");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "darius");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Diana");
		values.put(COLUMN_COOLDOWN, 15000);
		values.put(COLUMN_CHAMP_IMG, "diana");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Dr. Mundo");
		values.put(COLUMN_COOLDOWN, 75000);
		values.put(COLUMN_CHAMP_IMG, "mundo");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Draven");
		values.put(COLUMN_COOLDOWN, 90000);
		values.put(COLUMN_CHAMP_IMG, "draven");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Elise");
		values.put(COLUMN_COOLDOWN, 4000);
		values.put(COLUMN_CHAMP_IMG, "elise");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Evelynn");
		values.put(COLUMN_COOLDOWN, 90000);
		values.put(COLUMN_CHAMP_IMG, "eve");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Ezreal");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "ez");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Fiddlesticks");
		values.put(COLUMN_COOLDOWN, 130000);
		values.put(COLUMN_CHAMP_IMG, "fiddle");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Fiora");
		values.put(COLUMN_COOLDOWN, 110000);
		values.put(COLUMN_CHAMP_IMG, "fiora");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Fizz");
		values.put(COLUMN_COOLDOWN, 70000);
		values.put(COLUMN_CHAMP_IMG, "fizz");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Galio");
		values.put(COLUMN_COOLDOWN, 130000);
		values.put(COLUMN_CHAMP_IMG, "galio");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Gangplank");
		values.put(COLUMN_COOLDOWN, 110000);
		values.put(COLUMN_CHAMP_IMG, "gp");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Garen");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "garen");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Gragas");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "gragas");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Graves");
		values.put(COLUMN_COOLDOWN, 80000);
		values.put(COLUMN_CHAMP_IMG, "graves");
		mValueList.add(values);
		
		//feito ate aqui
		//TODO
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Hecarim");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "hecarim");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Heimerdinger");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "heimerdinger");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Irelia");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "irelia");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Janna");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "janna");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Jarvan IV");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "j4");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Jax");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "jax");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Jayce");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "jayce");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Karma");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "karma");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Karthus");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "karthus");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Kassadin");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "kassadin");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Katarina");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "katarina");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Kayle");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "kayle");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Kennen");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "kennen");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Kha'Zix");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "khazix");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Kog'Maw");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "kogmaw");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "LeBlanc");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "leblanc");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Lee Sin");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "lee sin");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Leona");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "leona");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Lissandra");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "lissandra");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Lucian");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "lucian");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Lulu");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "lulu");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Lux");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "lux");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Malphite");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "malphite");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Malzahar");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "malzahar");
		mValueList.add(values);

		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Maokai");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "maokai");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Master Yi");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "yi");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Miss Fortune");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "mf");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Mordekaiser");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "morde");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Morgana");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "morgana");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nami");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nami");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nasus");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nasus");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nautilus");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nautilus");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nidalee");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nidalee");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nocturne");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nocturne");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Nunu");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "nunu");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Olaf");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "olaf");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Orianna");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "orianna");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Pantheon");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "panth");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Poppy");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "poppy");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Quinn");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "quinn");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Rammus");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "rammus");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Renekton");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "renek");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Rengar");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "rengar");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Riven");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "riven");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Rumble");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "rumble");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Ryze");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "ryze");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Sejuani");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "sejuani");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Shaco");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "shaco");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Shen");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "shen");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Shyvana");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "shyvana");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Singed");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "singed");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Sion");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "sion");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Sivir");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "sivir");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Skarner");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "skarner");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Sona");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "sona");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Soraka");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "soraka");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Swain");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "swain");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Syndra");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "syndra");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Talon");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "talon");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Taric");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "taric");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Teemo");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "teemo");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Thresh");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "thresh");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Tristana");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "tristana");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Trundle");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "trundle");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Tryndamere");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "tryndamere");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Twisted Fate");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "tf");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Twitch");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "twitch");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Udyr");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "udyr");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Urgot");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "urgot");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Varus");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "varus");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Vayne");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "vayne");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Veigar");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "veigar");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Vi");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "vi");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Viktor");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "viktor");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Vladimir");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "vlad");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Volibear");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "volibear");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Warwick");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "warwick");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Wukong");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "wukong");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Xerath");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "xerath");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Xin Zhao");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "xinzhao");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Yorick");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "yorick");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Zac");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "zac");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Zed");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "zed");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Ziggs");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "ziggs");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Zilean");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "zilean");
		mValueList.add(values);
		
		values = new ContentValues();
		values.put(COLUMN_CHAMP, "Zyra");
		values.put(COLUMN_COOLDOWN, 60);
		values.put(COLUMN_CHAMP_IMG, "zyra");
		mValueList.add(values);
		return mValueList;
	}

	//Singleton Aux Methods
	public static synchronized DBHelper getSingletonObject(Context c) {
		if (singletonDBHelper == null) {
			singletonDBHelper = new DBHelper(c);
		}
		return singletonDBHelper;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
