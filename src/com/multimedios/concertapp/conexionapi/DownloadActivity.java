package com.multimedios.concertapp.conexionapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.multimedios.concertapp.BuildConfig;
import com.multimedios.concertapp.R;
import com.multimedios.concertapp.adapters.RssAdapter;
import com.multimedios.concertapp.asynctask.DownloadManager;
import com.multimedios.concertapp.interfaces.DownloadListener;
import com.multimedios.concertapp.models.*;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadActivity extends Activity implements DownloadListener {

	private ProgressBar progressBar;
	private TextView text;
	private ListView listView;
	private List <LastfmEventModel> list = new ArrayList<LastfmEventModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.performance_activity);
		listView = (ListView) findViewById(R.id.listView3);
		progressBar = (ProgressBar) findViewById(R.id.legacy_navigation_progressBar);


		new DownloadManager(this, 10000, 15000, "GET")
		.execute(getString(R.string.geo_url));
	}

	@Override
	public void onRequestStart() {
		if(progressBar.getVisibility() == View.GONE)
			progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void onRequestComplete(String data) {
		if(progressBar.getVisibility() == View.VISIBLE){
			progressBar.setVisibility(View.GONE);
		}

		LastfmFirstNode model = (LastfmFirstNode) parseServiceResponse(data, LastfmFirstNode.class);

		if (model != null && model.eventsModel.event != null)
		{
			List<LastfmEventModel> eventsList= model.eventsModel.event;			
			if (eventsList != null && eventsList.size() > 0)  
			{ 
				int i=0;
				for (LastfmEventModel event : eventsList) 
				{				
					event.title = eventsList.get(i).title ;
					event.artists.headliner = eventsList.get(i).artists.headliner;
					event.startDate = eventsList.get(i).startDate;
					event.venue.name = eventsList.get(i).venue.name;
					list.add(event);
					i++;
				}
			}
			RssAdapter adapter = new RssAdapter(getApplicationContext(), R.string.app_name, list);
			listView.setAdapter(adapter);
		}
	}

	@Override
	public void onError(String error, int code) {
		if(progressBar.getVisibility() == View.VISIBLE)
			progressBar.setVisibility(View.GONE);
		text.setText(error);
	}	

	/**
	 * Parses the WebResponse.
	 * 
	 * @param reader
	 * @param expectedResponse
	 * @return
	 */
	public static Object parseServiceResponse(String reader, Class<?> type) {
		Object returnObj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			returnObj = mapper.readValue(reader, type);
		} catch (JsonParseException errorException) {
			if (BuildConfig.DEBUG) {
				Log.e("JSON PARSE ERROR", errorException.getMessage());
				Log.e("JSON PARSE ERROR", reader);
			}
			return null;
		} catch (JsonMappingException ioexc) {

			if (BuildConfig.DEBUG) {
				Log.e("JSON MAPPING ERROR", ioexc.getMessage());
				Log.e("JSON MAPPING ERROR", reader);
			}
			return null;
		} catch (IOException e) {

			if (BuildConfig.DEBUG) {
				Log.e("IO ERROR", e.getMessage());
			}
			return null;
		}
		return returnObj;
	}

}
