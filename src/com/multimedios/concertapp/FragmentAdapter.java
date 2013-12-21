package com.multimedios.concertapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {	 
    private String[] titles = { "Title1", "Title2", "Title3" };
 
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
	public CharSequence getPageTitle(int position) {
        return titles[position];
    }
 
    @Override
    public Fragment getItem(int position) {
    	return new Fragment();
    }
 
    @Override
    public int getCount() {
        return titles.length;
    }
 
}
