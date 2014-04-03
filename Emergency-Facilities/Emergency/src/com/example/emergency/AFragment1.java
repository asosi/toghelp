package com.example.emergency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.LinearLayout;


// Fragment that creates the "help"
public class AFragment1 extends Fragment {
	
	public View onCreateView (final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.activity_afragment1, container, false);
		
	}
}