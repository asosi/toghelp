package com.example.emergency;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

	public class ListAdapterSent extends ArrayAdapter<SingleResult>{

	    public ListAdapterSent(Context context, int textViewResourceId,
	            List list) {
	        super(context, textViewResourceId, list);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        LayoutInflater inflater = (LayoutInflater) getContext()
	             .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.rowhelpsent, null);
	        
	        TextView name = (TextView)convertView.findViewById(R.id.name);
	        TextView offered = (TextView)convertView.findViewById(R.id.offered);
	       
	        SingleResult result = getItem(position);
	        
	        name.setText(result.getname());
	        //offered.setText(result.getoffered());
	        
	        return convertView;
	    }

	}
