package com.multimedios.concertapp.fragments;

import com.multimedios.concertapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FirstFragment extends Fragment {

	
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.lin, null);
        
        //ListView list = (ListView) v.findViewById(R.id.list_firstFragment);
        
        //list.setAdapter(adapter);
        return v;
    }
}
