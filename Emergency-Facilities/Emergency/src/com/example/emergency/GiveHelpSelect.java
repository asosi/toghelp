package com.example.emergency;


import java.util.Timer;
import java.util.TimerTask;
import com.example.db.HelpGive;

import android.R.bool;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R.id;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class GiveHelpSelect extends ActionBarActivity {

	Button send;
	boolean[] value = new boolean[6];
	CheckBox[] checkBoxs = new CheckBox[6];
	EditText enotes;
	String notes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_select);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    init();
	    send = (Button) findViewById(R.id.send);
	    
	    send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
					boolean issent = true;
					
					AlertDialog.Builder builder = new AlertDialog.Builder(GiveHelpSelect.this);
					
					builder.setTitle("Great!");
					builder.setMessage("Your precious help has been sent!"+"\n"+"Thank you so much!");
					builder.setCancelable(true);
					
		            final AlertDialog dialog1 = builder.create();
		            dialog1.show();
		            
		            setValue();
		            
		            final Timer t = new Timer();
	                t.schedule(new TimerTask() {
	                    public void run() {
	                        dialog1.dismiss();
	                        t.cancel(); 
	                    }
	                }, 3000);
	                
	                
					Intent myIntent = new Intent(GiveHelpSelect.this, GiveHelpSent.class);
					myIntent.putExtra(getPackageName(), issent);
				    
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
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.saveinfo:
	           return true;
	        
	        default:
	           return super.onOptionsItemSelected(item);
	    }
	}
	
	private void init(){
		checkBoxs[0] = (CheckBox)findViewById(R.id.food);
		checkBoxs[1] = (CheckBox)findViewById(R.id.water);
		checkBoxs[2] = (CheckBox)findViewById(R.id.bed);
		checkBoxs[3] = (CheckBox)findViewById(R.id.pchildren);
		checkBoxs[4] = (CheckBox)findViewById(R.id.firstaid);
		checkBoxs[5] = (CheckBox)findViewById(R.id.medicines);
		enotes = (EditText)findViewById(R.id.notes);
	}
	
	private void setValue(){
		for(int i=0; i<HelpGive.MED_POS+1; i++){
			value[i] = checkBoxs[i].isChecked();
		}
		notes = enotes.getText().toString();
	}

}
