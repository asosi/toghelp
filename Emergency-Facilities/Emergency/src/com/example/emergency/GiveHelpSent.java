package com.example.emergency;

import java.util.LinkedList;
import java.util.List;

import com.example.db.HelpGive;
import com.example.db.SQLDatabase;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GiveHelpSent extends ActionBarActivity {
	String date, offered;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Intent intent = getIntent();
		Boolean issent = intent.getBooleanExtra(getPackageName(), false);
		
		if (issent == true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_give_help_sent);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    ListView listview = (ListView)findViewById(R.id.helpslist);
		List list1 = new LinkedList();
		
		SQLDatabase db = new SQLDatabase(this);
		Cursor cursor = db.help();
		try
		{
			while (cursor.moveToNext())
			{
				list1.add(new SingleSent(cursor.getString(cursor.getColumnIndex(HelpGive.NAME)), "Food, medicines"));
			}
		}
		finally
		{
			cursor.close();
		}
		
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
