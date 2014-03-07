package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Page> fragments;
	public int currentPosition=0;
	public int previousPosition=0;
	
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

	// helper function to make calls simpler when launching animations
	public Page getPage(int position){
		return fragments.get(position);
	}

	// helper function to make calls simpler when launching animations
	public Page getCurrentPage() {
		return fragments.get(currentPosition);
	}

	// helper function to make calls simpler when launching animations
	public Page getPreviousPage() {
		return fragments.get(previousPosition);
	}
}
