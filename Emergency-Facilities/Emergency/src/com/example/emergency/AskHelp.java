package com.example.emergency;

import com.example.db.HelpGive;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AskHelp extends ActionBarActivity {

	Button search;
	boolean[] value = new boolean[6];
	CheckBox[] checkBoxs = new CheckBox[6];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_ask_help);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    init();
	    search = (Button) findViewById(R.id.search);
	
	    //search button goes to result
	    search.setOnClickListener(new View.OnClickListener() {
		
	    	@Override
	    	public void onClick(View arg0) {
	    		setValue();
	    		GPSTracker gpsTracker = new GPSTracker(AskHelp.this);
	    		Double lati = gpsTracker.latitude;
	    		Double longi = gpsTracker.longitude;
	    		  
	    		Intent myIntent = new Intent(AskHelp.this, Result.class);
	    		myIntent.putExtra("values", value);
	    		myIntent.putExtra("lat", lati);
	    		myIntent.putExtra("long", longi);
	    		AskHelp.this.startActivity(myIntent);
	    	} 
	    });

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ask_help, menu);
		return true;
	}
	
	private void init(){
		checkBoxs[0] = (CheckBox)findViewById(R.id.food);
		checkBoxs[1] = (CheckBox)findViewById(R.id.water);
		checkBoxs[2] = (CheckBox)findViewById(R.id.bed);
		checkBoxs[3] = (CheckBox)findViewById(R.id.pchildren);
		checkBoxs[4] = (CheckBox)findViewById(R.id.firstaid);
		checkBoxs[5] = (CheckBox)findViewById(R.id.medicines);
	}
	
	private void setValue(){
		for(int i=0; i<HelpGive.MED_POS+1; i++){
			value[i] = checkBoxs[i].isChecked();
		}
	}

}
