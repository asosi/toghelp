package com.example.emergency;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SituationMap extends ActionBarActivity implements OnInfoWindowClickListener{
	

	static final LatLng MORI = new LatLng(45.852278, 10.979002);
	
 GoogleMap map;
 @SuppressLint("NewApi")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
  setContentView(R.layout.activity_situation_map);

  map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
  map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
  
  Marker kiel = map.addMarker(new MarkerOptions()
  .position(MORI)
  .title("Mori")
  .snippet("Mori is cool")
  .icon(BitmapDescriptorFactory.fromResource(R.drawable.halfperson)));
  
  map.moveCamera(CameraUpdateFactory.newLatLngZoom(MORI, 12));
  map.setOnInfoWindowClickListener(this);
  
 }
 
 public void onInfoWindowClick(Marker marker) {
     Intent intent = new Intent(this, Result.class);
     //intent.putExtra("snippet", marker.getSnippet());
     //intent.putExtra("title", marker.getTitle());
     //intent.putExtra("position", marker.getPosition());
     startActivity(intent);
}
}