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
				if(cursor.getString(cursor.getColumnIndex(HelpGive.PHONE)).equals("045123")){
					String value = "";
					value += filter(cursor);
					list1.add(new SingleSent(cursor.getString(cursor.getColumnIndex(HelpGive.DATE)), 
							value));
			
				}
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
	
	private String filter(Cursor c){
		String ret= "";
		if(c.getInt(c.getColumnIndex(HelpGive.FOOD)) == 1)
			ret += "FOOD, ";
		if(c.getInt(c.getColumnIndex(HelpGive.WATER)) == 1)
			ret += "WATER, ";
		if(c.getInt(c.getColumnIndex(HelpGive.BED)) == 1)
			ret += "BED, ";
		if(c.getInt(c.getColumnIndex(HelpGive.PR_CH)) == 1)
			ret += "CHILDREN PRODUCTS, ";
		if(c.getInt(c.getColumnIndex(HelpGive.FIRST_H)) == 1)
			ret += "FIRST AID, ";
		if(c.getInt(c.getColumnIndex(HelpGive.MED)) == 1)
			ret += "MEDICINES, ";
		return ret;
	}

}
