package com.multimedios.concertapp;

//import android.app.Activity;
//import android.app.ActivityOptions;
//import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.multimedios.concertapp.fragments.FragmentAdapter;
import com.facebook.Session;
//import com.facebook.model.GraphUser;
//import com.facebook.widget.LoginButton;

public class PagerMainActivity extends FragmentActivity{
	
	private FragmentAdapter mAdapter;
	private ViewPager mPager;
	private PageIndicator mIndicator;
	int Number = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pager_main);
		
		mAdapter = new FragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager)findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
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


