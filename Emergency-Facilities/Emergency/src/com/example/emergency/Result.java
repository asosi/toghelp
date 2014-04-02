package com.example.emergency;

import java.util.LinkedList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Result extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		ListView listview = (ListView)findViewById(R.id.resultlist);
		List list = new LinkedList();
		
		list.add(new SingleResult("Andrea Sosi","15 km","Food, medicines"));
		list.add(new SingleResult("Davide Campigotto","1.6 km","Food, water"));
		list.add(new SingleResult("Francesco Boschini","23 km","Food, bed"));
		
		ListAdapter adapter = new com.example.emergency.ListAdapter(this, R.layout.row, list);
        listview.setAdapter(adapter);
		
		
        listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	            
	            Intent myIntent = new Intent(Result.this, HelpDetails.class);
	            startActivity(myIntent);
			}      
		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
