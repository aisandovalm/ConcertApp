package com.multimedios.concertapp.adapters;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonProperty;
import com.multimedios.concertapp.R;
import com.multimedios.concertapp.models.*;

//import cl.telematica.httpjacksonparseexample.R;
//import cl.telematica.httpjacksonparseexample.models.LastfmEventModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
		TextView headliner = null;
	    TextView startDate = null;
	    TextView venueName = null;
	    
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
		headliner = holder.getHeadliner();
		startDate = holder.getStartDate();
		venueName = holder.getVenueName();

//setearlos para mostrar
	//	id.setText(String.valueOf( model.id ));
		title.setText(event.title);
		headliner.setText(event.artists.headliner);
		startDate.setText(event.startDate );
		venueName.setText(event.venue.name );
		
		return convertView;
	}
	
	@Override
    public int getCount() {
    	return mCount;
    }
	
	private class ViewHolder {
	    private View mRow;
	    private TextView title;
	    private TextView headliner;
	    private TextView startDate;
	    private TextView venueName;
	    
	    public ViewHolder(View row) {
	          mRow = row;
	    }
	    
	    public TextView getHeadliner(){
	    	if(headliner == null){
	    		headliner = (TextView) mRow.findViewById(R.id.headliner);
	    	}
	    	return headliner;
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
	    
	}

}
