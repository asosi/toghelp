package com.example.db;

import android.provider.BaseColumns;

public interface HelpGive extends BaseColumns{
	static final String TABLE_NAME = "HELP_GIVE";
	static final String ID = "ID";
	static final String NAME = "NAME";
	static final String PHONE = "PHONE";
	static final String DATE = "DATE";
	static final String AVAILABLE = "AVAILABLE";
	static final String DESCRIPTION = "DESCRIPTION";
	static final String LAT = "LAT";
	static final String LONG = "LONG";
	static final String ADDRESS = "ADDRESS";
	static final String CITY = "CITY";
	static final String POSTALCODE = "POSTALCODE";
	static final String COUNTRY = "COUNTRY";
	static final String AREA = "AREA";
	

	static final String FOOD = "FOOD";
	static final String WATER = "WATER";
	static final String BED = "BED";
	static final String PR_CH = "PR_CH";
	static final String FIRST_H = "FIRST_H";
	static final String MED = "MED";
	
	static final int FOOD_POS = 0;
	static final int WATER_POS = 1;
	static final int BED_POS = 2;
	static final int PR_CH_POS = 3;
	static final int FIRTS_H_POS = 4;
	static final int MED_POS = 5;
	
	
	String[] COLUMNS = new String[]
	{ ID, NAME, PHONE, DATE, AVAILABLE, DESCRIPTION, LAT, LONG, 
		ADDRESS, CITY, POSTALCODE, COUNTRY, AREA, FOOD, WATER, BED, PR_CH, FIRST_H, MED };
}
