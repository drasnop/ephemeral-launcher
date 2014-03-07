package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/* A custom GridView that supports changes/fadesIn of colored icons 
 */
public class AnimatedGridView extends GridView {

	public AnimatedGridView(Context context) {
		super(context);
	}

	public AnimatedGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AnimatedGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	// /////// Public methods

	public void init(final Context mContext) {

		this.setAdapter(new IconAdapter(mContext));

		this.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
			}
		});

	}
	
	public void startPreAnimation(){
		if (Parameters.ANIMATION_HAS_PREANIMATION_STATE)
			startPreAnimationAll();
	}
	
	public void startEphemeralAnimation() {
		int position;
		int count = this.getChildCount();

		//TODO: check if the random numbers are all different!!!
		for (int i = 0; i < Parameters.NUM_HIGHLIGHTED_ICONS; i++) {
			position = (int) Math.floor(Math.random() * count);
			highlightIcon(position);
		}

		if (Parameters.ANIMATION_AFFECTS_OTHER_ICONS)
			animateOtherIcons();
	}

	public void backToPreAnimationState() {
		if (Parameters.ANIMATION_HAS_PREANIMATION_STATE){
			//TODO: stop the current animation! (in case they last 10s or so)
			for (int i = 0; i < this.getChildCount(); i++)
				this.getIcon(i).getImageGs().setVisibility(View.GONE);
		}
	}

	// ////// Private helper functions

	private Icon getIcon(int position) {
		return (Icon) this.getChildAt(position);
	}

	private void highlightIcon(int position) {
		switch (Parameters.ANIMATION) {
		case COLOR:
		case BLUR:
			Animation.color(this.getIcon(position));
			break;
		case SIZE_ZOOM_IN:
			Animation.zoom_in(this.getIcon(position));
			break;
		case SIZE_ZOOM_OUT:
			Animation.zoom_out(this.getIcon(position));
			break;
		case SIZE_PULSE_IN:
			Animation.pulse_in(this.getIcon(position));
			break;
		case SIZE_PULSE_OUT:
			Animation.pulse_out(this.getIcon(position));
			break;
		case TWIST:
			Animation.twist(this.getIcon(position));
			break;
		default:
			break;
		}
	}
    
	private void animateOtherIcons() {
		for (int i = 0; i < this.getChildCount(); i++)
			animateOtherIcon(i);
	}

	private void animateOtherIcon(int position) {
		switch (Parameters.ANIMATION) {
		case COLOR:
		case BLUR:
			Effects.changeToColor(this.getIcon(position), Parameters.COLOR__FADE_IN_DURATION,
					Parameters.COLOR__START_DELAY);
			break;
		default:
			break;
		}
	}

	private void startPreAnimationAll() {
		for (int i = 0; i < this.getChildCount(); i++)
			startPreAnimation(i);
	}

	private void startPreAnimation(int position) {
		switch (Parameters.ANIMATION) {
		case COLOR:
		case BLUR:
			changeMaskImages();
			Effects.changeToGreyScale(this.getIcon(position));
			break;
		default:
			break;
		}
	}

	private void changeMaskImages(){
		for (int i = 0; i < this.getChildCount(); i++){
			switch(Parameters.ANIMATION){
			case COLOR:
				this.getIcon(i).getImageGs().setImageResource(Parameters.images_gs_ID[i]);
				break;
			case BLUR:
				this.getIcon(i).getImageGs().setImageResource(Parameters.images_b_ID[i]);
				break;
			default:
				break;
			}
		}
	}
}
