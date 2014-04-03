package com.example.emergency;


import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class GiveHelpSelect extends ActionBarActivity {

	Button send, see, select;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_select);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    send = (Button) findViewById(R.id.send);
	  
	    send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
					AlertDialog.Builder builder = new AlertDialog.Builder(GiveHelpSelect.this);
				
					builder.setTitle("Great!");
					builder.setMessage("Your precious help has been sent! Thank you!");
					builder.setCancelable(true);
					
		            final AlertDialog dialog1 = builder.create();
		            dialog1.show();
		            
		            final Timer t = new Timer();
	                t.schedule(new TimerTask() {
	                    public void run() {
	                        dialog1.dismiss();
	                        t.cancel(); 
	                    }
	                }, 3000);
	                
	                
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

}
