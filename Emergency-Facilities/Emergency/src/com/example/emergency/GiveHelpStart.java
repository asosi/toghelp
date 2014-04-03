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
import android.widget.EditText;
import android.widget.TextView;

public class GiveHelpStart extends ActionBarActivity {
	
	Button getLocation;	
	TextView see, select;
	TextView showAddress, showCity, showPostalCode, showCountry;
	EditText enamesurname, ephone, earea;
	
	String namesurname, phone, address, city, postalcode, country;
	Double area, lati, longi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_start);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    init();
	    
	    see = (TextView) findViewById(R.id.see);
	    select = (TextView) findViewById(R.id.select);
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
		    		setValues();
		    		
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
			             
			        	lati = gpsTracker.latitude;
			            longi = gpsTracker.longitude;
			            
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
	
	private void init(){
		enamesurname = (EditText)findViewById(R.id.namesurname);
		ephone = (EditText)findViewById(R.id.phone);
		earea = (EditText)findViewById(R.id.area);
	}
	
	private void setValues(){
		namesurname = enamesurname.getText().toString();
		phone = ephone.getText().toString();
		address = showAddress.getText().toString();
		city = showCity.getText().toString();
		postalcode = showPostalCode.getText().toString();
		country = showCountry.getText().toString();
		area = Double.valueOf(earea.getText().toString());
		
	}

}
