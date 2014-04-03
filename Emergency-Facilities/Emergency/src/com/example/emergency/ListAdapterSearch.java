package com.example.emergency;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

	public class ListAdapterSearch extends ArrayAdapter<SingleResult>{

	    public ListAdapterSearch(Context context, int textViewResourceId,
	            List list) {
	        super(context, textViewResourceId, list);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        LayoutInflater inflater = (LayoutInflater) getContext()
	             .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.row, null);
	        
	        TextView name = (TextView)convertView.findViewById(R.id.name);
	        TextView distance = (TextView)convertView.findViewById(R.id.distance);
	        TextView matched = (TextView)convertView.findViewById(R.id.matched);
	       
	        SingleResult result = getItem(position);
	        
	        name.setText(result.getname());
	        distance.setText(result.getdistance());
	        matched.setText(result.getmatched());
	        
	        return convertView;
	    }

	}
