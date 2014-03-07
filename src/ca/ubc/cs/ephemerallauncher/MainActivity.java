package ca.ubc.cs.ephemerallauncher;
import java.util.ArrayList;

import ca.ubc.cs.ephemerallauncher.Parameters.AnimationType;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;


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
		ArrayList<Page> pages=new ArrayList<Page>();
		for (int i = 0; i < Parameters.NUM_PAGES; i++) {
			pages.add(new Page(this));
		}
		
		// Populate pager
		pagerAdapter = new PagerAdapter(getSupportFragmentManager(),pages);
        pager.setAdapter(pagerAdapter);
        
        // Set up animations when changing page
        pager.setOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            	if(state==ViewPager.SCROLL_STATE_DRAGGING)
            		pagerAdapter.previousPosition=pager.getCurrentItem();
            }
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                pagerAdapter.getPage(position).getGridView().startEphemeralAnimation();               
                pagerAdapter.getPreviousPage().getGridView().backToPreAnimationState();
            }
                      
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_temporal:
	        	//((Page) pagerAdapter.getItem(1)).gridview.startEphemeralAnimation("color")
	        	Parameters.ANIMATION=AnimationType.COLOR;
	            return true;
	        case R.id.action_size:
	        	//((Page) pagerAdapter.getItem(1)).gridview.startEphemeralAnimation("size");
	        	Parameters.ANIMATION=AnimationType.SIZE_ZOOM_IN;
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
