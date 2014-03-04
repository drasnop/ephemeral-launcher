package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends FragmentActivity {

    static final int NUM_PAGES = 2;

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

	public void startInteraction() {

		testAnimation2();
		// GridView gridview = (GridView) findViewById(R.id.gridview);
		// gridview.getChildAt(0).setAlpha(0.5f);
		/*
		 * int size = gridview.getChildCount(); for(int i = 0; i < size; i++) {
		 * ViewGroup gridChild = (ViewGroup) gridview.getChildAt(i);
		 * gridChild.setVisibility(View.GONE); int childSize =
		 * gridChild.getChildCount(); for(int k = 0; k < childSize; k++) { if(
		 * gridChild.getChildAt(k) instanceof ImageView ) {
		 * gridChild.getChildAt(k).setVisibility(View.GONE); } } }
		 */
	}

	public void testAnimation2() {
		int highlightedIcons=5;
		int duration = 3000;
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		int iconsCount = gridview.getChildCount();
		
		int iconIndex;
		for(int i=0; i<highlightedIcons; i++){
			iconIndex=(int) Math.floor(Math.random()*iconsCount);
			crossfade((ViewGroup) gridview.getChildAt(iconIndex), false, 0, 0);
		}
		
		allCrossfade(false,duration,0);		
	}
	
	
	public void testAnimation() {

		// allCrossfade();

		// crossfading a few icons
		final GridView gridview = (GridView) findViewById(R.id.gridview);

		final int duration = 3000;

		crossfade((ViewGroup) gridview.getChildAt(1), false, duration, 0);
		crossfade((ViewGroup) gridview.getChildAt(5), false, duration, 0);
		crossfade((ViewGroup) gridview.getChildAt(12), false, duration, 0);
		crossfade((ViewGroup) gridview.getChildAt(18), false, duration, 0);
		crossfade((ViewGroup) gridview.getChildAt(17), false, duration, 0);

		long delay = 3 * duration;
		crossfade((ViewGroup) gridview.getChildAt(1), true, duration, delay);
		crossfade((ViewGroup) gridview.getChildAt(5), true, duration, delay);
		crossfade((ViewGroup) gridview.getChildAt(12), true, duration, delay);
		crossfade((ViewGroup) gridview.getChildAt(18), true, duration, delay);
		crossfade((ViewGroup) gridview.getChildAt(17), true, duration, delay);

		// crossfade in reverse after a delay
		/*
		 * final Handler handler = new Handler(); handler.postDelayed(new
		 * Runnable() {
		 * 
		 * @Override public void run() { crossfade((ViewGroup)
		 * gridview.getChildAt(1), true, duration); crossfade((ViewGroup)
		 * gridview.getChildAt(5), true, duration); crossfade((ViewGroup)
		 * gridview.getChildAt(12), true, duration); crossfade((ViewGroup)
		 * gridview.getChildAt(18), true, duration); crossfade((ViewGroup)
		 * gridview.getChildAt(17), true, duration); } }, 3*duration);
		 */

	}

	public void allCrossfade(final boolean reverse, long duration_ms, long start_delay_ms) {
		GridView gridview = (GridView) findViewById(R.id.gridview);
		int size = gridview.getChildCount();

		for (int i = 0; i < size; i++) {
			crossfade((ViewGroup) gridview.getChildAt(i), reverse, duration_ms, start_delay_ms);
		}

	}

	public static void crossfade(ViewGroup frame, final boolean reverse, long duration_ms, long start_delay_ms) {
		final ImageView coloredImage = ((ImageView) ((ViewGroup) frame.getChildAt(0)).getChildAt(0));
		final ImageView gsImage = ((ImageView) ((ViewGroup) frame.getChildAt(0)).getChildAt(1));

		ObjectAnimator animColor;
		if (!reverse) {
			animColor = ObjectAnimator.ofFloat(coloredImage, "alpha", 1f);
		} else {
			// coloredImage.setAlpha(1f);
			animColor = ObjectAnimator.ofFloat(coloredImage, "alpha", 0f);
		}
		animColor.setDuration(duration_ms);

		animColor.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				// if (reverse) {coloredImage.setVisibility(View.INVISIBLE);}
				// if (!reverse) {} else
				// {coloredImage.setVisibility(View.INVISIBLE);}

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				// if (!reverse) {coloredImage.setVisibility(View.VISIBLE);}
			}
		});

		ObjectAnimator animGs;
		if (!reverse) {
			// gsImage.setAlpha(1f);
			animGs = ObjectAnimator.ofFloat(gsImage, "alpha", 0f);
		} else {
			// gsImage.setAlpha(0f);
			// gsImage.setVisibility(View.VISIBLE);
			animGs = ObjectAnimator.ofFloat(gsImage, "alpha", 1.0f);
		}
		animGs.setDuration(duration_ms);

		animGs.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				// if (!reverse) {gsImage.setVisibility(View.INVISIBLE);}
				// if (reverse) {} else {gsImage.setVisibility(View.INVISIBLE);}
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				// if (reverse) {gsImage.setVisibility(View.VISIBLE);}
			}
		});

		AnimatorSet crossFadeSet = new AnimatorSet();
		crossFadeSet.play(animGs).with(animColor);

		crossFadeSet.setStartDelay(start_delay_ms);
		crossFadeSet.start();

		/*
		 * animColor.start(); animGs.start();
		 */

	}

}
