package com.example.emergency;


import com.example.db.HelpGive;
import com.example.db.SQLDatabase;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.TextView;

public class HelpDetails extends ActionBarActivity {

	String name, phone, adress, matched;
	TextView tname, tphone, tadress, tcity, tcountry, toffer;	//tmatched is for the offerte that match the requirements of the needer
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_help_details);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
		tphone = (TextView) findViewById(R.id.telephone);
		tname = (TextView) findViewById(R.id.namehelper);
		tadress = (TextView) findViewById(R.id.adress);
		toffer = (TextView) findViewById(R.id.offerte);
			
		Intent i = getIntent();
		
		SQLDatabase db = new SQLDatabase(this);
		Cursor cursor = db.help();
		
		try
		{
			
			while (cursor.moveToNext()){
				
		

				if(Integer.toString(cursor.getInt(cursor.getColumnIndex(HelpGive.ID))).equals(i.getStringExtra(getPackageName()+"id"))){
						
					tphone.setText(cursor.getString(cursor.getColumnIndex(HelpGive.PHONE)));
					tname.setText(cursor.getString(cursor.getColumnIndex(HelpGive.NAME)));
					tadress.setText(cursor.getString(cursor.getColumnIndex(HelpGive.ADDRESS))+"\n"+
							cursor.getString(cursor.getColumnIndex(HelpGive.CITY))+"\n"+
							cursor.getString(cursor.getColumnIndex(HelpGive.COUNTRY)));
					String value = "";
					value += filter(cursor);
					toffer.setText(value+"\n\n"+cursor.getString(cursor.getColumnIndex(HelpGive.DESCRIPTION)));
				}
			}
		}
		finally
		{
			cursor.close();
		}
	}
	
	private String filter(Cursor c){
		String ret= "";
		if(c.getInt(c.getColumnIndex(HelpGive.FOOD)) == 1)
			ret += "FOOD, ";
		if(c.getInt(c.getColumnIndex(HelpGive.WATER)) == 1)
			ret += "WATER, ";
		if(c.getInt(c.getColumnIndex(HelpGive.BED)) == 1)
			ret += "BED, ";
		if(c.getInt(c.getColumnIndex(HelpGive.PR_CH)) == 1)
			ret += "CHILDREN PRODUCTS, ";
		if(c.getInt(c.getColumnIndex(HelpGive.FIRST_H)) == 1)
			ret += "FIRST AID, ";
		if(c.getInt(c.getColumnIndex(HelpGive.MED)) == 1)
			ret += "MEDICINES, ";
		return ret;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help_details, menu);
		return true;
	}

}
