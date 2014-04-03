package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GiveHelpStart extends ActionBarActivity {

	Button see, select;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help_start);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    see = (Button) findViewById(R.id.see);
	    select = (Button) findViewById(R.id.select);
	   
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_start, menu);
		return true;
	}

}
