package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GiveHelpSecond extends ActionBarActivity {

	Button send;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help_second);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    send = (Button) findViewById(R.id.send);
	    send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent myIntent = new Intent(GiveHelpSecond.this, GiveHelpSent.class);
			    GiveHelpSecond.this.startActivity(myIntent);
			} 
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_second, menu);
		return true;
	}

}
