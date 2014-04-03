package com.example.emergency;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GiveHelpSelect extends ActionBarActivity {

	Button send, see, select;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help_select);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    send = (Button) findViewById(R.id.send);
	   
	    
	    send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent myIntent = new Intent(GiveHelpSelect.this, GiveHelpSent.class);
			    GiveHelpSelect.this.startActivity(myIntent);
			} 
		});
	    
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_first, menu);
		return true;
	}

//	public boolean onOptionsItemSelected(MenuItem item) {
//	    // Handle presses on the action bar items
//	    switch (item.getItemId()) {
//	    	case R.id.seehelpslist:
//	        	Intent myIntent = new Intent(GiveHelpFirst.this, GiveHelpSecond.class);
//			    GiveHelpFirst.this.startActivity(myIntent);
//	            return true;
//	        
//	        default:
//	            return super.onOptionsItemSelected(item);
//	    }
//	}
}
