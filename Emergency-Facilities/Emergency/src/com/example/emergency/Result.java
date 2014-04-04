package com.example.emergency;

import java.util.LinkedList;
import java.util.List;

import com.example.db.HelpGive;
import com.example.db.SQLDatabase;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Result extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_result);

		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
		ListView listview = (ListView)findViewById(R.id.resultlist);
		List list = new LinkedList();
		
		Intent i = getIntent();
		SQLDatabase db = new SQLDatabase(this);
		Cursor cursor = db.help();
		
		try
		{
			
			while (cursor.moveToNext()){
				
				if((cursor.getInt(cursor.getColumnIndex(HelpGive.FOOD)) == 
						conv(i.getBooleanArrayExtra("values")[HelpGive.FOOD_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.FOOD_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.WATER)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.WATER_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.WATER_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.BED)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.BED_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.BED_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.PR_CH)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.PR_CH_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.PR_CH_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.FIRST_H)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.FIRTS_H_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.FIRTS_H_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.MED)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.MED_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.MED_POS] == true)
						
						
						
						){
					String value = "";
					value += filter(cursor);
					double distance = distFrom(i.getDoubleExtra("lat", 0), i.getDoubleExtra("long", 0),
							cursor.getDouble(cursor.getColumnIndex(HelpGive.LAT)), cursor.getDouble(cursor.getColumnIndex(HelpGive.LONG)));
					
					if(distance <= cursor.getInt(cursor.getColumnIndex(HelpGive.AREA))){
						list.add(new SingleResult(cursor.getString(cursor.getColumnIndex(HelpGive.NAME)), String.format("%.2f", distance)+ " Km" , value));
					}
				}
			}
		}
		finally
		{
			cursor.close();
		}
		
		db = new SQLDatabase(this);
		cursor = db.help();
		
		try
		{
			
			while (cursor.moveToNext()){
				
				if((cursor.getInt(cursor.getColumnIndex(HelpGive.FOOD)) == 
						conv(i.getBooleanArrayExtra("values")[HelpGive.FOOD_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.FOOD_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.WATER)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.WATER_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.WATER_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.BED)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.BED_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.BED_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.PR_CH)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.PR_CH_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.PR_CH_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.FIRST_H)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.FIRTS_H_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.FIRTS_H_POS] == true)
					||
					(cursor.getInt(cursor.getColumnIndex(HelpGive.MED)) == 
					conv(i.getBooleanArrayExtra("values")[HelpGive.MED_POS])
						&& i.getBooleanArrayExtra("values")[HelpGive.MED_POS] == true)
						
						
						
						){
					String value = "";
					value += filter(cursor);
					double distance = distFrom(i.getDoubleExtra("lat", 0), i.getDoubleExtra("long", 0),
							cursor.getDouble(cursor.getColumnIndex(HelpGive.LAT)), cursor.getDouble(cursor.getColumnIndex(HelpGive.LONG)));
					
					if(distance > cursor.getInt(cursor.getColumnIndex(HelpGive.AREA))){
						list.add(new SingleResult(cursor.getString(cursor.getColumnIndex(HelpGive.NAME)), String.format("%.2f", distance)+ " Km" , value));
					}
				}
			}
		}
		finally
		{
			cursor.close();
		}
		
		ListAdapter adapter = new com.example.emergency.ListAdapterSearch(this, R.layout.row, list);
        listview.setAdapter(adapter);
		
		
        listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            
	            Intent myIntent = new Intent(Result.this, HelpDetails.class);
	            startActivity(myIntent);
			}      
		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}
	
	public int conv(boolean t){
		if(t == true)
			return 1;
		else return 0;
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
	

	public static double distFrom(double lat1, double lng1, double lat2, double lng2){
		
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;
	
	    int meterConversion = 1609;
	
	    return (double) (dist * meterConversion)/1000;
	}
}
