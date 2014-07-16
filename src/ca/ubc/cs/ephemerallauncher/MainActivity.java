package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import ca.ubc.cs.ephemerallauncher.Parameters.AnimationType;

public class MainActivity extends FragmentActivity {

	PagerAdapter pagerAdapter;
	ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v("MainActivity", "animation");

		// Set up pager view
		setContentView(R.layout.pager);
		pager = (ViewPager) findViewById(R.id.pager);

		// Create grid views for each page
		ArrayList<Page> pages = new ArrayList<Page>();
		for (int i = 0; i < Parameters.NUM_PAGES; i++) {
			pages.add(new Page(this));
		}

		// Populate pager
		pagerAdapter = new PagerAdapter(getSupportFragmentManager(), pages);
		pager.setAdapter(pagerAdapter);

		// Set up animations when changing page
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			public void onPageScrollStateChanged(int state) {

				if (state == ViewPager.SCROLL_STATE_DRAGGING) {
					
					// don't know in which direction we're going! so we do both
					int position = pagerAdapter.currentPosition;
					
					if (position - 1 >= 0)
						pagerAdapter.getPage(position - 1).getGridView().startPreAnimation();
					if (position + 1 < Parameters.NUM_PAGES)
						pagerAdapter.getPage(position + 1).getGridView().startPreAnimation(); 
				}
			}

			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				
			}

			public void onPageSelected(int position) {
				pagerAdapter.previousPosition=pagerAdapter.currentPosition;
				pagerAdapter.currentPosition = position;
				
				pagerAdapter.getCurrentPage().getGridView().startEphemeralAnimation();
				pagerAdapter.getPreviousPage().getGridView().backToPreAnimationState();
			}

		});

		// Switch to initial animation type when the layout has been created, then plays it
		pager.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {		
			boolean firstTime=true;		// This is a workaround, but seems to work pretty well...
			public void onGlobalLayout() {
				if(firstTime){
					Parameters.switchAnimationTo(Parameters.ANIMATION, pagerAdapter);
					firstTime=false;
				}
			}
		});

		// Parameters.switchAnimationTo(Parameters.ANIMATION,pagerAdapter);		// CRASHES
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
	        case R.id.color:
	        	Parameters.switchAnimationTo(AnimationType.COLOR,pagerAdapter);
	            return true;
	        case R.id.zoom_in:
	        	Parameters.switchAnimationTo(AnimationType.SIZE_ZOOM_IN,pagerAdapter);
	            return true;
	        case R.id.zoom_out:
	        	Parameters.switchAnimationTo(AnimationType.SIZE_ZOOM_OUT,pagerAdapter);
	            return true;
	        case R.id.pulse_in:
	        	Parameters.switchAnimationTo(AnimationType.SIZE_PULSE_IN,pagerAdapter);
	            return true;
	        case R.id.pulse_out:
	        	Parameters.switchAnimationTo(AnimationType.SIZE_PULSE_OUT,pagerAdapter);
	            return true;
	        case R.id.twist:
	        	Parameters.switchAnimationTo(AnimationType.TWIST,pagerAdapter);
	            return true;
	        case R.id.transparency:
	        	Parameters.switchAnimationTo(AnimationType.TRANSPARENCY,pagerAdapter);
	            return true;
	        case R.id.blur:
	        	Parameters.switchAnimationTo(AnimationType.BLUR,pagerAdapter);
	            return true;
	        case R.id.change_param:
	        	Intent i = new Intent(MainActivity.this, SetupActivity.class);
	        	i.putExtra(SetupActivity.EXTRA_DELAY, Parameters.DELAY);
	        	i.putExtra(SetupActivity.EXTRA_DURATION, Parameters.TOTAL_DURATION);
	        	startActivityForResult(i,0);
	        	return true;
	        case R.id.change_bkg:
	        	switch(Parameters.BACKGROUND){
	        	case 0:
	        		Parameters.BACKGROUND=1;
	        		this.findViewById(R.id.pager).setBackgroundResource(R.drawable.ios_background);
	        		break;
	        	case 1:
	        		Parameters.BACKGROUND=2;
	        		this.findViewById(R.id.pager).setBackgroundResource(R.color.lightgrey);
	        		break;   
	        	case 2:
	        		Parameters.BACKGROUND=0;
	        		this.findViewById(R.id.pager).setBackgroundResource(R.color.darkgrey);
	        		break; 
	        	}
	        	pagerAdapter.getCurrentPage().getGridView().changeTextColor();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null){
			return;
		}
		Parameters.DELAY = (Integer) data.getSerializableExtra(SetupActivity.EXTRA_DELAY);
		Parameters.TOTAL_DURATION = (Integer) data.getSerializableExtra(SetupActivity.EXTRA_DURATION);
		Parameters.propagateParameters();
	}
	
	
}
