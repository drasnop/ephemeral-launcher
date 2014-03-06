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
	
	public void startEphemeralAnimation(String effect){
		int position;
		int count=this.getChildCount();
		for(int i=0; i<Parameters.NUM_HIGHLIGHTED_ICONS; i++){
			position=(int) Math.floor(Math.random()*count);
			// KZ
			if (effect == "color") changeToColor(position);
			else changeToSize(position); 
		}
		
		//fadeAllToColor(true);	// false!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	public void backToPreAnimationState(){
		changeAllToGreyScale();
	}
	
	
	private void changeToColor(int position){
		Effects.changeToColor((Icon) this.getChildAt(position));
	}
	
	private void changeAllToGreyScale(){
		for (int i = 0; i < this.getChildCount(); i++) {
			Effects.changeToGreyScale((Icon) this.getChildAt(i));
		}
	}	
	
	//--------KZ
	private void changeToSize(int position){
		Effects.changeToSize((Icon) this.getChildAt(position));
	}
	
	// If force==true, play the animation also for the icons that are already colored 
	// which will turn them back to greyscale before fading in the color
	// If force==false, the icons already colored are excluded
	private void fadeAllToColor(boolean force){
		if(force){
			for (int i = 0; i < this.getChildCount(); i++) {
				Effects.changeToColor((Icon) this.getChildAt(i),Parameters.FADE_IN_DURATION__COLOR,Parameters.START_DELAY__COLOR);
			}
		}
	}
}
