package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;


public class MainActivity extends FragmentActivity {

    PagerAdapter pagerAdapter;
    ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Set up pager view
		setContentView(R.layout.pager);
		pager = (ViewPager)findViewById(R.id.pager);
		
		// Create grid views for each page
		Page page1 = new Page(this);
		Page page2 = new Page(this);
		
		// Add them to the pagerAdapter
		ArrayList<Page> pages=new ArrayList<Page>();
		pages.add(page1);
		pages.add(page2);
		pagerAdapter = new PagerAdapter(getSupportFragmentManager(),pages);
		
		// populate pager
        pager.setAdapter(pagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
