package com.example.emergency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


// Fragment that creates the "help"
public class AFragment1 extends Fragment {

	public View onCreateView (final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.activity_afragment1, container, false);
		
//		final LinearLayout mLinearLayout1 = (LinearLayout) inflater.inflate(R.layout.activity_afragment1,
//                container, false);
//		
//		final LinearLayout mLinearLayout2 = (LinearLayout) inflater.inflate(R.layout.activity_afragment2,
//                container, false);
//		
//		Button next = (Button) mLinearLayout1.findViewById(R.id.next1);
//		Button prev = (Button) mLinearLayout2.findViewById(R.id.previous);
		
//		next.setOnClickListener(new View.OnClickListener() {	
//			@Override
//			public void onClick(View v) {
//				return mLinearLayout2;
//			}
//		});
//		
//		prev.setOnClickListener(new View.OnClickListener() {	
//			@Override
//			public void onClick(View v) {
//				return mLinearLayout1;
//			}
//		});

		
		// after you've done all your manipulation, return your layout to be show
		
		
	}
	
	
}