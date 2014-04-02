package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartScreen extends Activity {

	Button askhelp, givehelp, situation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
				
		askhelp = (Button) findViewById (R.id.askhelp);
		givehelp = (Button) findViewById (R.id.givehelp);
		situation = (Button) findViewById (R.id.situation);
		
		askhelp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent myIntent = new Intent(StartScreen.this, AskHelp.class);
			    StartScreen.this.startActivity(myIntent);
			} 
		});
		
		givehelp.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
					
						Intent myIntent = new Intent(StartScreen.this, GiveHelp.class);
					    StartScreen.this.startActivity(myIntent);
					} 
				});
		
		situation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent myIntent = new Intent(StartScreen.this, Situation.class);
			    StartScreen.this.startActivity(myIntent);
			} 
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

}