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
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class GiveHelpSent extends ActionBarActivity {

	String date, offered;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_sent);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    ListView listview = (ListView)findViewById(R.id.helpslist);
		List list1 = new LinkedList();
		
		list1.add(new SingleSent("2 Aprile 2014", "Food, medicines"));
		list1.add(new SingleSent("3 Aprile 2014", "Medicines, water"));
		list1.add(new SingleSent("4 Aprile 2014","Products for children, bed"));
		
		ListAdapter adapter = new com.example.emergency.ListAdapterSent(this, R.layout.rowhelpsent, list1);
        listview.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help_sent, menu);
		return true;
	}

}
