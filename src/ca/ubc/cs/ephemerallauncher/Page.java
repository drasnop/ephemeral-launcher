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


/* One page of the "launcher", containing exactly one gridview of icons
*  This class calls the animations appropriate for each event (e.g, swipe)
*/
@SuppressLint("ValidFragment")
public class Page extends Fragment {

	private Context mContext;
	public TemporalColorGridView gridview; //private to public
	
	public Page(Context c){
		mContext=c;
	}
	
	public Page(){};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// Inflate the grid layout for this fragment, then populates it with icons	
		this.gridview = (TemporalColorGridView) inflater.inflate(R.layout.temporal_color_grid, container, false);
		gridview.init(mContext);

/*		
  		// Registering a global layout listener so that startInteraction is
		// invoked when gridView is loaded completely
  		gridview.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				startInteraction();
			}
		});

		gridview.getViewTreeObserver().addOnDrawListener(new OnDrawListener() {
			public void onDraw() {
				startInteraction();
			}
		});*/
		
		//test for menu tap
		gridview.setOnTouchListener(new OnTouchListener() {
		    public boolean onTouch(View v, MotionEvent event) {
		    	gridview.startEphemeralAnimation("size");
				return true;
		    }
		});
		
		return gridview;
	}
	
}
