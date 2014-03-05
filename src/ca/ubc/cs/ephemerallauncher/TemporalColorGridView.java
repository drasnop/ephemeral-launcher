package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/* A custom GridView that supports changes/fadesIn of colored icons 
 */
public class TemporalColorGridView extends GridView {

	public TemporalColorGridView(Context context) {
		super(context);
	}

	public TemporalColorGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TemporalColorGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(final Context mContext){
		
		this.setAdapter(new IconAdapter(mContext));

		this.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
				// v.setVisibility(View.GONE);
			}
		});
	}
	
	public void changeToColor(int position){};
	
	public void changeAllToGreyscale(){};	
	
	// If force==true, play the animation also for the icons that are already colored 
	// which will turn them back to greyscale before fading in the color
	// If force==false, the icons already colored are excluded
	public void fadeAllToColor(long duration_ms, long delay_ms, boolean force){};
}
