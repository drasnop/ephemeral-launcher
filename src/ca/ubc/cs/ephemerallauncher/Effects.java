package ca.ubc.cs.ephemerallauncher;

import android.animation.Animator;
import android.animation.ObjectAnimator;

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
	public static void changeToSize(Icon icon, int durationMs, int delayMs, float... value) {
		animateObjectProperty(icon.getImage(), "scaleX", durationMs, delayMs,value);
		animateObjectProperty(icon.getImage(), "scaleY", durationMs, delayMs,value);
	}

	// immediate change to size_zoom_in
	public static void changeToSize(Icon icon) {
		icon.getGsImage().animate().alpha(0).start(); //hide the grey scale image
		changeToSize(icon,Parameters.ZOOM_IN__DURATION,Parameters.ZOOM_IN__DELAY,Parameters.ZOOM_IN__INIT_SIZE,Parameters.ZOOM_IN__FINAL_SIZE);
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
		
		ObjectAnimator animObject = ObjectAnimator.ofFloat(obj, propertyName, values);

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
