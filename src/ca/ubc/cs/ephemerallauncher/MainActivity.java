package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
		Parameters.images_gs = new LinkedList<View>();
		Parameters.images_gs_2 = new HashSet<View>();

		// Set up animations when changing page
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			// int previousPosition=pager.getCurrentItem();

			public void onPageScrollStateChanged(int state) {
				if (state == ViewPager.SCROLL_STATE_DRAGGING) {
					int position = pagerAdapter.currentPosition;
					// don't know in which direction we're going! so we do both
					if (position - 1 >= 0)
						pagerAdapter.getPage(position - 1).getGridView().startPreAnimation();
					if (position + 1 < Parameters.NUM_PAGES)
						pagerAdapter.getPage(position + 1).getGridView().startPreAnimation();

					pagerAdapter.previousPosition = pager.getCurrentItem();
				}
			}

			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			public void onPageSelected(int position) {
				pagerAdapter.currentPosition = position;
				pagerAdapter.getCurrentPage().getGridView().startEphemeralAnimation();
				pagerAdapter.getPreviousPage().getGridView().backToPreAnimationState();

				Log.v("OnPageChange", "animation _ " + pagerAdapter.getCount() + " "
						+ pagerAdapter.getCurrentPage().getGridView().getCount() + " "
						// + ((LinearLayout)((Icon)
						// pagerAdapter.getCurrentPage().getGridView().getChildAt(0)).getChildAt(0)).getChildCount()
						// + " "
						+ Parameters.images_gs.size() + " " + Parameters.images_gs_2.size());
			}

		});

		// Select initial animation type when the layout has been created, then
		// plays it

		pager.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			// This is a workaround, but seems to work pretty well...
			boolean firstTime=true;
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
		Log.v("onOptions", "animation_beginning");
		switch (item.getItemId()) {
		case R.id.action_temporal:
			Log.v("onOptions", "animationCOLOR");
			Parameters.switchAnimationTo(AnimationType.COLOR, pagerAdapter);
			return true;
		case R.id.action_size:
			Log.v("onOptions", "animationZOOM");
			Parameters.switchAnimationTo(AnimationType.SIZE_ZOOM_IN, pagerAdapter);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
