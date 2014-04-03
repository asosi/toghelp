package com.example.emergency;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GiveHelp extends FragmentActivity	{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_give_help1);
		
		final android.app.ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    
	    final Tab tabA = actionBar.newTab().setText("Resources");
	    final Tab tabB = actionBar.newTab().setText("List of helps");
	    
	    final Fragment fragmentA1 = new AFragment1();
	    final Fragment fragmentA2 = new AFragment2();
	    final Fragment fragmentB = new BFragment();
	    
	    
	    tabA.setTabListener((TabListener) new MyTabsListener(fragmentA1));
	    tabB.setTabListener((TabListener) new MyTabsListener(fragmentB));
	    
	    actionBar.addTab(tabA);
	    actionBar.addTab(tabB);
	    
//	    Button next = (Button) findViewById(R.id.next1);
//	    Button prev = (Button) findViewById(R.id.previous);
//	    Button send = (Button) findViewById(R.id.send);
	    
	    
	}
	
	protected class MyTabsListener implements TabListener {
		
		private Fragment fragment;
		
		public MyTabsListener (Fragment fragment) {
			this.fragment = fragment;
		}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	
	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.add(R.id.fragment_place, fragment, null);
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(fragment);
	}
	
	}
	
	
	// back button on the actionbar that returns to the previous task
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.give_help, menu);
		return true;
	}

}
