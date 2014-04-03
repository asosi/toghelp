package com.example.emergency;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class GiveHelpSent extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help_sent);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    ListView listview = (ListView)findViewById(R.id.helpslist);
		List list = new LinkedList();
		
//		list.add(new SingleResult("Andrea Sosi","Food, medicines"));
//		list.add(new SingleResult("Andrea Sosi","Food, water"));
//		list.add(new SingleResult("Andrea Sosi","Food, bed"));
		
		ListAdapter adapter = new com.example.emergency.ListAdapterSearch(this, R.layout.rowhelpsent, list);
        listview.setAdapter(adapter);
		
		
//        listview.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//	            
//	            Intent myIntent = new Intent(Result.this, HelpDetails.class);
//	            startActivity(myIntent);
//			}      
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_sent, menu);
		return true;
	}

}
