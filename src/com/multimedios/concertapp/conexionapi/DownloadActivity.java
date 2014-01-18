package com.multimedios.concertapp.conexionapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.facebook.Session;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multimedios.concertapp.BuildConfig;
import com.multimedios.concertapp.DetailsActivity;
import com.multimedios.concertapp.R;
import com.multimedios.concertapp.adapters.RssAdapter;
import com.multimedios.concertapp.asynctask.DownloadManager;
import com.multimedios.concertapp.interfaces.DownloadListener;
import com.multimedios.concertapp.models.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView.OnItemClickListener;

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
					event.id = eventsList.get(i).id;
					event.title = eventsList.get(i).title;
					event.artists.headliner = eventsList.get(i).artists.headliner;
					event.startDate = eventsList.get(i).startDate;
					event.venue.name = eventsList.get(i).venue.name;
					event.venue.location.city = eventsList.get(i).venue.location.city;
					event.venue.location.street = eventsList.get(i).venue.location.street;
					event.description = eventsList.get(i).description;
					event.website = eventsList.get(i).website;
					event.image.get(2).urlImagen = eventsList.get(i).image
					.get(2).urlImagen;
					list.add(event);
					i++;
				}
			}
			RssAdapter adapter = new RssAdapter(getApplicationContext(), R.string.app_name, list);
			listView.setAdapter(adapter);
			
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View arg1,
						int position, long arg3) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getApplicationContext(),
							DetailsActivity.class);
					// paso los datos que seran vistos en el siguiente activity
					intent.putExtra("title", list.get(position).title);
					intent.putExtra("startDate", list.get(position).startDate);
					intent.putExtra("venueName", list.get(position).venue.name);
					intent.putExtra("venueLocationCity",
							list.get(position).venue.location.city);
					intent.putExtra("website", list.get(position).website);
					intent.putExtra("description", list.get(position).description);
					intent.putExtra("image",
							list.get(position).image.get(2).urlImagen);
				
					startActivity(intent);
				}
			});
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
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	  } 
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_search:
	      Toast.makeText(this, "Búsqueda", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    case R.id.action_logout:
	      Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT)
	          .show();
	      salirFacebook();
	      this.finish();
	      break;

	    default:
	      break;
	    }

	    return true;
	  } 
	
	public static void salirFacebook(){
		Session.getActiveSession().closeAndClearTokenInformation();
	}

}
