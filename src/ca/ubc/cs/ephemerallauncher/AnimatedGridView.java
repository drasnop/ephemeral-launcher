package ca.ubc.cs.ephemerallauncher;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/* A custom GridView that supports changes/fadesIn of colored icons 
 */
public class AnimatedGridView extends GridView {

	private int[] highlightedIcons = new int[Parameters.NUM_HIGHLIGHTED_ICONS];

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

	public void startPreAnimation() {

/*		ArrayList<Integer> positions = new ArrayList<Integer>();
		for (int i = 0; i < Parameters.NUM_ICONS_PER_PAGE; i++)
			positions.add(i);
		
		Collections.shuffle(positions);
		
		for(int i=0; i<Parameters.NUM_HIGHLIGHTED_ICONS;i++)
			highlightedIcons[i] = positions.get(i);	*/

		// For the video version only, use always the same four icons
		highlightedIcons[0]=3;
		highlightedIcons[1]=6;
		highlightedIcons[2]=8;
		highlightedIcons[3]=14;		
		
		if (Parameters.ANIMATION_HAS_PREANIMATION_STATE)
			startPreAnimationAllIcons();
	}

	public void startEphemeralAnimation() {

		for (int i = 0; i < highlightedIcons.length; i++) {
			highlightIcon(highlightedIcons[i]);
		}

		if (Parameters.ANIMATION_AFFECTS_OTHER_ICONS)
			animateOtherIcons();
	}

	public void backToPreAnimationState() {
		if (Parameters.ANIMATION_HAS_PREANIMATION_STATE) {
			// TODO: stop the current animation! (in case they last 10s or so)
			for (int i = 0; i < this.getChildCount(); i++)
				this.getIcon(i).getImageGs().setVisibility(View.GONE);
		}
	}

	// ////// Private helper functions

	private Icon getIcon(int position) {
		return (Icon) this.getChildAt(position);
	}

	private void startPreAnimationAllIcons() {
		for (int i = 0; i < this.getChildCount(); i++)
			startPreAnimation(i);
	}

	private void startPreAnimation(int position) {
		
		switch (Parameters.ANIMATION) {
		case COLOR:
		case BLUR:
			if(isDifferentFromAllHighlighted(position)){
				changeMaskImages();
				Effects.changeToGreyScale(this.getIcon(position));
			}
			break;
		case TRANSPARENCY:
			if (isDifferentFromAllHighlighted(position))
				Animation.disappear(this.getIcon(position));
			break;
		default:
			break;
		}
		
		// stupid function call to change the color of the captions
		changeTextColor();
	}
	
	private void highlightIcon(int position) {
		switch (Parameters.ANIMATION) {
		case COLOR:
		case BLUR:
			// Animation.color(this.getIcon(position));    not any more
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
			Effects.changeToColor(this.getIcon(position), Parameters.TOTAL_DURATION, Parameters.DELAY);
			break;
		case TRANSPARENCY:
			if (isDifferentFromAllHighlighted(position))
				Animation.fadeIn(this.getIcon(position));
		default:
			break;
		}
	}


	private void changeMaskImages() {
		for (int i = 0; i < this.getChildCount(); i++) {
			switch (Parameters.ANIMATION) {
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
	
	// Stupid function required because we can't change the text color globally!
	void changeTextColor() {
		for (int i = 0; i < this.getChildCount(); i++) {
			switch (Parameters.BACKGROUND) {
			case 0:
			case 1:
				this.getIcon(i).getCaption().setTextColor(getResources().getColor(R.color.white));
				break;
			case 2:
				this.getIcon(i).getCaption().setTextColor(getResources().getColor(R.color.darkgrey));
				break;
			default:
				break;
			}
		}
	}

	private boolean isDifferentFromAllHighlighted(int position) {
		for (int i = 0; i < highlightedIcons.length; i++) {
			if (position == highlightedIcons[i])
				return false;
		}
		return true;
	}
}
