package ca.ubc.cs.ephemerallauncher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class Page extends Fragment {

	private Context mContext;
	private GridView gridview;
	
	public Page(Context c){
		mContext=c;
	}
	
	public Page(){};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// Inflate the grid layout for this fragment	
		this.gridview = (GridView) inflater.inflate(R.layout.grid, container, false);
		
		gridview.setAdapter(new IconAdapter(mContext));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
				// v.setVisibility(View.GONE);
			}
		});

		/*
		 * Registering a global layout listener so that startInteraction is
		 * invoked when gridView is loaded completely
		 */

/*		gridview.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				startInteraction();
			}
		});
		*/

/*		gridview.getViewTreeObserver().addOnDrawListener(new OnDrawListener() {
			public void onDraw() {
				startInteraction();
			}
		});*/
		
		gridview.setOnTouchListener(new OnTouchListener() {
		    public boolean onTouch(View v, MotionEvent event) {
		    	startInteraction();
				return true;
		    }
		});
		
		return gridview;
	}
	
	
	public void startInteraction() {
		temporalColorAnimation();
	}

	public void temporalColorAnimation() {
		int highlightedIcons=4;
		int duration = 1000;
		
		int iconsCount = gridview.getChildCount();
		
		int iconIndex;
		for(int i=0; i<highlightedIcons; i++){
			iconIndex=(int) Math.floor(Math.random()*iconsCount);
			Effects.crossfade((ViewGroup) gridview.getChildAt(iconIndex), false, 0, 0);
		}
		
		allCrossfade(false,duration,0);		
	}
	
	public static void changeAllToGreyscale(){};
	
	public static void fadeAllToColor(){};
	
	public void allCrossfade(final boolean reverse, long duration_ms, long start_delay_ms) {
		int size = gridview.getChildCount();

		for (int i = 0; i < size; i++) {
			Effects.crossfade((ViewGroup) gridview.getChildAt(i), reverse, duration_ms, start_delay_ms);
		}

	}
}
