package com.multimedios.concertapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
//import android.widget.ListView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
	private TextView title;
	//private TextView headliner;
	private TextView startDate;
	private TextView venueName;
	//private TextView venueLocationCity;
	private TextView website;
	private TextView description;
	private WebView image;
	//title, headliner,startdate,venuename,venuelocationcity,imagen
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_item_specific);
		
		title= (TextView) findViewById(R.id.title);
	//	headliner= (TextView) findViewById(R.id.headliner);
		startDate= (TextView) findViewById(R.id.startDate);
		venueName= (TextView) findViewById(R.id.venueName);
		website= (TextView) findViewById(R.id.website);
		description= (TextView) findViewById(R.id.description);
		image = (WebView) findViewById(R.id.image);
		
		title.setText(getIntent().getExtras().getString("title") );
	//	headliner.setText(getIntent().getExtras().getString("headliner") );
		startDate.setText(getIntent().getExtras().getString("startDate") );
		venueName.setText(getIntent().getExtras().getString("venueName") );
		website.setText(getIntent().getExtras().getString("website") );
		description.setText(getIntent().getExtras().getString("description") );
		image.loadUrl(getIntent().getExtras().getString("image"));
			
	}	
}
