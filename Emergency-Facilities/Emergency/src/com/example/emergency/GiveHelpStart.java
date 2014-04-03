package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GiveHelpStart extends ActionBarActivity {

	Button see, select, getLocation;
	TextView showAddress, showCity, showPostalCode, showCountry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_start);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    see = (Button) findViewById(R.id.see);
	    select = (Button) findViewById(R.id.select);
	    getLocation = (Button) findViewById(R.id.getlocation);
	   
		    see.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
				
					Intent myIntent = new Intent(GiveHelpStart.this, GiveHelpSent.class);
				    GiveHelpStart.this.startActivity(myIntent);
				} 
			});

		    select.setOnClickListener(new View.OnClickListener() {
		
		    	@Override
		    	public void onClick(View arg0) {
		
		    		Intent myIntent = new Intent(GiveHelpStart.this, GiveHelpSelect.class);
		    		GiveHelpStart.this.startActivity(myIntent);
		    	} 
		    });
		    
		    getLocation.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					
					GPSTracker gpsTracker = new GPSTracker(GiveHelpStart.this);
					
					// check if GPS enabled					
			        if (gpsTracker.canGetLocation())
			        {
			            String stringLatitude = String.valueOf(gpsTracker.latitude);
			            String stringLongitude = String.valueOf(gpsTracker.longitude);
			            
			            String country = gpsTracker.getCountryName(GiveHelpStart.this);
			            String city = gpsTracker.getLocality(GiveHelpStart.this);
			            String postalCode = gpsTracker.getPostalCode(GiveHelpStart.this);
			            String addressLine = gpsTracker.getAddressLine(GiveHelpStart.this);
			            
			            showAddress = (TextView)findViewById(R.id.adress);
			            showCity = (TextView)findViewById(R.id.city);
			            showPostalCode = (TextView)findViewById(R.id.postalcode);
			            showCountry = (TextView)findViewById(R.id.paese);
			            
			            showAddress.setText(addressLine);
			            showCity.setText(city);
			            showPostalCode.setText(postalCode);
			            showCountry.setText(country);
			            
			        }
			        else
			        {
			            // can't get location
			            // GPS or Network is  not enabled
			            // Ask user to enable GPS/network in settings
			            gpsTracker.showSettingsAlert();
			        }
				} 
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_start, menu);
		return true;
	}

}
