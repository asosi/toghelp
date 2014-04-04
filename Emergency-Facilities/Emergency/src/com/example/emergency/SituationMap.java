package com.example.emergency;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import com.example.db.HelpGive;
import com.example.db.SQLDatabase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SituationMap extends ActionBarActivity implements OnInfoWindowClickListener{
	
 GoogleMap map;
 @SuppressLint("NewApi")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	  setContentView(R.layout.activity_situation_map);
	  
	  // get personal position
	  GPSTracker gpsTracker = new GPSTracker(SituationMap.this);
	  Double lati = gpsTracker.latitude;
	  Double longi = gpsTracker.longitude;
	  
	  LatLng MYPOSITION = new LatLng(lati, longi);
	
	  map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	  map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	  map.moveCamera(CameraUpdateFactory.newLatLngZoom(MYPOSITION, 13));
	  map.setOnInfoWindowClickListener(this);
	  
	  Marker personalPosition = map.addMarker(new MarkerOptions()
	  .position(MYPOSITION)
	  .title("I'm HERE")
	  .snippet("Your position")
	  .icon(BitmapDescriptorFactory.fromResource(R.drawable.myposition)));
	  
	  
	  SQLDatabase db = new SQLDatabase(this);
	  Cursor cursor = db.help();
		try
		{
			while (cursor.moveToNext())
			{
				String value = "";
				value += filter(cursor);
				 Marker otherPos = map.addMarker(new MarkerOptions()
				  .position(new LatLng(cursor.getDouble(cursor.getColumnIndex(HelpGive.LAT)), 
						  				cursor.getDouble(cursor.getColumnIndex(HelpGive.LONG))))
				  .title(cursor.getString(cursor.getColumnIndex(HelpGive.NAME))
						  +"-"+cursor.getString(cursor.getColumnIndex(HelpGive.ID)))
				  .snippet(value)
				  .icon(BitmapDescriptorFactory.fromResource(R.drawable.halfperson)));
				  
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
 
 public void onInfoWindowClick(Marker marker) {
     Intent intent = new Intent(this, HelpDetails.class);
     
     String title = marker.getTitle();
     
     String[] parts1 = title.split("-");
     String part1 = parts1[1];
     
     
     intent.putExtra(getPackageName()+"id", part1);
     startActivity(intent);
}
}