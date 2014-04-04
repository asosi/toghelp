package com.example.db;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDatabase extends SQLiteOpenHelper{
	
	// Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "emergency";
	
	
    public SQLDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
    private static final String CREATE_TABLE_HELPGIVE = "CREATE TABLE "
            + HelpGive.TABLE_NAME + "(" 
    			+ HelpGive.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
    			+ HelpGive.NAME+ " TEXT," 
    			+ HelpGive.PHONE + " VARCHAR(30),"
    			+ HelpGive.DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
    			+ HelpGive.AVAILABLE + " BIT DEFAULT 1,"
    			+ HelpGive.DESCRIPTION + " TEXT,"
    			+ HelpGive.LAT + " DOUBLE,"
    			+ HelpGive.LONG + " DOUBLE,"
    			+ HelpGive.ADDRESS + " VARCHAR(100),"
    			+ HelpGive.CITY + " VARCHAR(100),"
    			+ HelpGive.POSTALCODE + " VARCHAR(30),"
    			+ HelpGive.COUNTRY + " VARCHAR(50),"
    			+ HelpGive.AREA + " DOUBLE,"
    			+ HelpGive.FOOD + " BIT,"
    			+ HelpGive.WATER + " BIT,"
    			+ HelpGive.BED + " BIT,"
    			+ HelpGive.PR_CH + " BIT,"
    			+ HelpGive.FIRST_H + " BIT,"
    			+ HelpGive.MED + " BIT"
    		+ ")";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// creating required tables
        db.execSQL(CREATE_TABLE_HELPGIVE);
        populated(db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int old_v, int new_v) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE " + HelpGive.TABLE_NAME);
        
        //create db
        onCreate(db);
	}
	
	
	public void insert(SQLiteDatabase db, String nome, String phone, String description, 
			double lat, double llong, 
			String address, String city, String codPost, String country, double area, boolean[] field){
		ContentValues cv = new ContentValues();
		cv.put(HelpGive.NAME, nome);
		cv.put(HelpGive.PHONE, phone);
		cv.put(HelpGive.DESCRIPTION, description);
		cv.put(HelpGive.LAT, lat);
		cv.put(HelpGive.LONG, llong);
		cv.put(HelpGive.ADDRESS, address);
		cv.put(HelpGive.CITY, city);
		cv.put(HelpGive.POSTALCODE, codPost);
		cv.put(HelpGive.COUNTRY, country);
		cv.put(HelpGive.AREA, area);
		cv.put(HelpGive.FOOD, field[HelpGive.FOOD_POS]);
		cv.put(HelpGive.WATER, field[HelpGive.WATER_POS]);
		cv.put(HelpGive.BED, field[HelpGive.BED_POS]);
		cv.put(HelpGive.PR_CH, field[HelpGive.PR_CH_POS]);
		cv.put(HelpGive.FIRST_H, field[HelpGive.FIRTS_H_POS]);
		cv.put(HelpGive.MED, field[HelpGive.MED_POS]);
		db.insert(HelpGive.TABLE_NAME, null, cv);
	}
	
	private void populated(SQLiteDatabase db){
		boolean[] values = {true,true,true,true,true,true};
		insert(db, "FRANCESCO BOSCHINI", "12345", "Bread, pasta", 45.82, 8.8,
				"Via Garibaldi 9", "Varese", "123", "ITALY", 15.0, values);
        insert(db, "ANDREA SOSI", "67890", "Tante cose", 45.12, 10.98,
				"Via Castelletto 3", "Mori", "456435", "ITALY", 150.0, values);
        insert(db, "DAVIDE CAMPIGOTTO", "045123", "I've got also the car", 45.62, 10.44,
				"Via Luigi XVI 18", "Dolce", "355678", "ITALY", 10.0, values);
        insert(db, "DAVIDE BRUGHERA", "34807", "Few things", 45.63, 10.42,
				"Via Giovanni Verga 45", "Dolce", "674678", "ITALY", 10.0, values);
        insert(db, "JACOPO SARTORELLI", "56707", "I can move faster with car", 45.47, 9.15,
				"Corso Como 22", "Milano", "355678", "ITALY", 500.0, values);
        insert(db, "SILVIA NELBO", "34807", "Few things to eat, food", 45.44, 9.20,
				"Via MonteNapoleone 8", "Milano", "890678", "ITALY", 80.0, values);
        insert(db, "ALESSANDRO MOIA", "34807", "Rice, pasta, bread,...", 45.44, 9.17,
				"Via Rosmini 19", "Trento", "32278", "ITALY", 5.0, values);
        insert(db, "STEFANO BOLLI", "34807", "4 beds for 4 people", 46.06, 11.15,
				"Via Salé 31", "Povo", "00678", "ITALY", 50.0, values);
        insert(db, "GIULIA CASTIONI", "34807", "Lot of food!", 45.45, 12.23,
				"Via Giustiniano II 6", "Venezia", "354678", "ITALY", 250.0, values);
        insert(db, "FEDERICA PASTORE", "34807", "I can gove also money", 41.86, 12.86,
				"Piazza Milius", "Roma", "311678", "ITALY", 100.0, values);
	}
	
	public Cursor help(){
		Cursor c = getReadableDatabase().query(
						HelpGive.TABLE_NAME, //table
						HelpGive.COLUMNS,	//columns
						null,
						null,	//selection args
						null,	//group by
						null,	//having
						null	//order by
				);
		return c;
	}
	
	public SQLiteDatabase db(){
		return this.getWritableDatabase();
	}
}
