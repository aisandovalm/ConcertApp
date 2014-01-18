package com.multimedios.concertapp.adapters;

import java.util.List;


//import com.fasterxml.jackson.annotation.JsonProperty;
import com.multimedios.concertapp.R;
import com.multimedios.concertapp.models.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RssAdapter extends ArrayAdapter<LastfmEventModel> {
	
	LayoutInflater mInflater;
	int mCount;

	public RssAdapter(Context context, int textViewResourceId,
			List<LastfmEventModel> objects) {
		super(context, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
		mCount = objects.size();
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		//TextView id = null;
		TextView title = null;
	    TextView startDate = null;
	    TextView venueName = null;
	    WebView image = null;
	    
		final LastfmEventModel event = (LastfmEventModel) getItem(position);
		
		if(convertView == null){
	         convertView = mInflater.inflate(R.layout.data_item_details, null);
	         holder = new ViewHolder(convertView);
	         convertView.setTag(holder);
	    } else {
	    	holder = (ViewHolder) convertView.getTag();
	    }
//obtener datos	
	//	id = holder.getId();
		title = holder.getTitle();
		startDate = holder.getStartDate();
		venueName = holder.getVenueName();
		image = holder.getImage();

//setearlos para mostrar
	//	id.setText(String.valueOf( model.id ));
		title.setText(event.title);
		startDate.setText(event.startDate );
		venueName.setText(event.venue.name );
		image.loadUrl(event.image.get(2).urlImagen);
		
		return convertView;
	}
	
	@Override
    public int getCount() {
    	return mCount;
    }
	
	private class ViewHolder {
	    private View mRow;
	    private TextView title;
	    private TextView startDate;
	    private TextView venueName;
	    private WebView image;
	    
	    public ViewHolder(View row) {
	          mRow = row;
	    }
	    
	    public TextView getTitle(){
	    	if(title == null){
	    		title = (TextView) mRow.findViewById(R.id.title);
	    	}
	    	return title;
	    }	    
	    
	    public TextView getStartDate(){
	    	if(startDate == null){
	    		startDate = (TextView) mRow.findViewById(R.id.startDate );
	    	}
	    	return startDate;
	    }
	    
	    public TextView getVenueName(){
	    	if(venueName == null){
	    		venueName = (TextView) mRow.findViewById(R.id.venueName);
	    	}
	    	return venueName;
	    }
	    public WebView getImage(){
	        if(image == null){
	        	image = (WebView) mRow.findViewById(R.id.image);                  
	        }
	        return image;
	    }
	    
	}

}
