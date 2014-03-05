package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Page> fragments;
	
	public PagerAdapter(FragmentManager fm, ArrayList<Page> fragments) {
		super(fm);
		this.fragments=fragments;
	}

	@Override
	public Fragment getItem(int i) {
		return fragments.get(i);
	}

	@Override
	public int getCount() {
		return Parameters.NUM_PAGES;
	}

}
