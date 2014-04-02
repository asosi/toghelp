package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AskHelp extends ActionBarActivity {

	Button search;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_help);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    search = (Button) findViewById(R.id.search);
	
	    //search button goes to result
	    search.setOnClickListener(new View.OnClickListener() {
		
	    	@Override
	    	public void onClick(View arg0) {
		
	    		Intent myIntent = new Intent(AskHelp.this, Result.class);
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

}
