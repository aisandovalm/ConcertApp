package com.multimedios.concertapp.adapters;

import java.util.List;


import com.multimedios.concertapp.R;
import com.multimedios.concertapp.models.PerformanceModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RssAdapter extends ArrayAdapter<PerformanceModel> {
	
	LayoutInflater mInflater;
	int mCount;

	public RssAdapter(Context context, int textViewResourceId,
			List<PerformanceModel> objects) {
		super(context, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
		mCount = objects.size();
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		TextView billingIndex = null;
		TextView displayName = null;
//		TextView artist = null;
	    TextView billing = null;
	    TextView id = null;
	    
	//	final EarthQuakeDataModel model = (EarthQuakeDataModel) getItem(position);
		final PerformanceModel model = (PerformanceModel) getItem(position);
		
		if(convertView == null){
	         convertView = mInflater.inflate(R.layout.data_item_details, null);
	         holder = new ViewHolder(convertView);
	         convertView.setTag(holder);
	    } else {
	    	holder = (ViewHolder) convertView.getTag();
	    }
//obtener datos	
		billingIndex = holder.getBillingIndex();
		displayName = holder.getDisplayName();
	//	artist = holder.getLocationText();
		billing = holder.getBilling();
		id = holder.getId();

//setearlos para mostrar
		billingIndex.setText(String.valueOf(model.billingIndex));
		displayName.setText(model.displayName);
	//	artist.setText(model.artist);
		billing.setText(model.billing);
		id.setText(String.valueOf(model.id));
		
		return convertView;
	}
	
	@Override
    public int getCount() {
    	return mCount;
    }
	
	private class ViewHolder {
	    private View mRow;
	    private TextView billingIndex;
	    private TextView displayName;
	    private TextView billing;
	    private TextView id;
	    
	    public ViewHolder(View row) {
	          mRow = row;
	    }
	    
	    public TextView getBillingIndex(){
	    	if(billingIndex == null){
	    		billingIndex = (TextView) mRow.findViewById(R.id.billingIndex);
	    	}
	    	return billingIndex;
	    }
	    
	    public TextView getDisplayName(){
	    	if(displayName == null){
	    		displayName = (TextView) mRow.findViewById(R.id.displayName);
	    	}
	    	return displayName;
	    }	    
	    
	    public TextView getBilling(){
	    	if(billing == null){
	    		billing = (TextView) mRow.findViewById(R.id.billing );
	    	}
	    	return billing;
	    }
	    
	    public TextView getId(){
	    	if(id == null){
	    		id = (TextView) mRow.findViewById(R.id.id);
	    	}
	    	return id;
	    }
	    
	}

}
