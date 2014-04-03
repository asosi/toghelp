package com.example.emergency;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SituationMap extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_situation_map);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.situation_map, menu);
		return true;
	}

}
