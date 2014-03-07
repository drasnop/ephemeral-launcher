package ca.ubc.cs.ephemerallauncher;

import ca.ubc.cs.ephemerallauncher.Parameters.AnimationType;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.widget.ImageView;

public class Effects {

	// color change
	public static void changeToColor(Icon icon, int durationMs, int startDelayMs) {
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, startDelayMs, 0f);
	}

	public static void changeToColor(Icon icon, int durationMs) {
		changeToColor(icon, durationMs, 0);
	};

	// immediate change to color
	public static void changeToColor(Icon icon) {
		changeToColor(icon, 0);
	}

	// size_zoom_in change
	public static void changeToSize(Icon icon, int durationMs, int delayMs) {
		animateObjectProperty(icon.getImage(), "size_zoom_in", durationMs, delayMs,0f);
	}

	// immediate change to size_zoom_in
	public static void changeToSize(Icon icon) {
		icon.getGsImage().animate().alpha(0).start(); //hide the grey scale image
		changeToSize(icon,Parameters.DURATION_SIZE_ZOOM_IN,Parameters.DELAY_SIZE_ZOOM_IN);
	}
	
	public static void changeToGreyScale(Icon icon, int durationMs, int startDelayMs) {
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, startDelayMs, 1f);
	}

	public static void changeToGreyScale(Icon icon, int durationMs) {

		changeToGreyScale(icon, durationMs, 0);

	};

	// immediate change to grey scale
	public static void changeToGreyScale(Icon icon) {
		changeToGreyScale(icon, 0);
	}

	// a general-purpose animation creator function for changing an arbitrary
	// property of an object
	public static void animateObjectProperty(Object obj, String propertyName, int durationMs, int delayMs,
			float... values) {
		
		ObjectAnimator animObject = null;
		
		if (propertyName=="alpha") {
        	animObject = ObjectAnimator.ofFloat(obj, propertyName, values);
		}  
		else if (propertyName == "size_zoom_in"){
        	PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(ImageView.SCALE_X, Parameters.INIT_SIZE_ZOOM_IN, Parameters.FINAL_SIZE_ZOOM_IN);
    		PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(ImageView.SCALE_Y, Parameters.INIT_SIZE_ZOOM_IN, Parameters.FINAL_SIZE_ZOOM_IN);

    		animObject = ObjectAnimator.ofPropertyValuesHolder(obj, scaleY, scaleX);
		}
		animObject.setDuration(durationMs);
		animObject.setStartDelay(delayMs);

		animObject.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}

			@Override
			public void onAnimationStart(Animator animation) {

			}

		});

		animObject.start();
	}
	
}
