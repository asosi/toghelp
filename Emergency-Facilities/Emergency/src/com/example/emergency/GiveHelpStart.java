package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GiveHelpStart extends ActionBarActivity {

	Button see, select, getLocation;
	TextView showLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help_start);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    final GPSTracker gpsTracker = new GPSTracker(this);
	    
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
					
					// check if GPS enabled
					
					
			        if (gpsTracker.canGetLocation())
			        {
			            String stringLatitude = String.valueOf(gpsTracker.latitude);
			            String stringLongitude = String.valueOf(gpsTracker.longitude);
			            
			            showLocation = (TextView)findViewById(R.id.adress);

			            showLocation.setText("Latitude: "+stringLatitude+" Longitude: "+stringLongitude);
			            
			            /*
			            String country = gpsTracker.getCountryName(this);
			            String city = gpsTracker.getLocality(this);
			            String postalCode = gpsTracker.getPostalCode(this);
			            String addressLine = gpsTracker.getAddressLine(this);
			            */
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
