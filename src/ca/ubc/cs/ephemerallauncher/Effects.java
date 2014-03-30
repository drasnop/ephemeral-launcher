package ca.ubc.cs.ephemerallauncher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;


public class Effects {

	// immediate change to color
	public static Animator changeToColor(Icon icon) {
		return changeToColor(icon, 0);
	}
	public static Animator changeToColor(Icon icon, int durationMs) {
		return changeToColor(icon, durationMs, 0);
	}
	public static Animator changeToColor(Icon icon, int durationMs, int startDelayMs) {
		return animateObjectProperty(icon.getImageGs(), "alpha", durationMs, startDelayMs, 0f);
	}
	
	// immediate change to grey scale
	public static Animator changeToGreyScale(Icon icon) {
		return changeToGreyScale(icon, 0);
	}
	public static Animator changeToGreyScale(Icon icon, int durationMs) {
		return changeToGreyScale(icon, durationMs, 0);
	}
	public static Animator changeToGreyScale(Icon icon, int durationMs, int startDelayMs) {

		icon.getImageGs().setVisibility(View.VISIBLE);
		return animateObjectProperty(icon.getImageGs(), "alpha", durationMs, startDelayMs, 1f);
	}
	
	// animation (interaction) type are defined (currently) in animatedGridView   --KZ 
	public static Animator changeSize(Icon icon, int durationMs, int delayMs, float... value) {
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(animateObjectProperty(icon.getImage(), "scaleX", durationMs, delayMs,value),animateObjectProperty(icon.getImage(), "scaleY", durationMs, delayMs,value));
		return animatorSet;
	}
	
	// rotation
	public static Animator rotate(Icon icon, int durationMs, int delayMs, float... value) {
		return animateObjectProperty(icon.getImage(), "rotation", durationMs, delayMs,value);
	}

	// transparency
	public static Animator fadeIn(Icon icon, int durationMs, int delayMs, float... value){
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(animateObjectProperty(icon.getImage(), "alpha", durationMs, delayMs, value),animateObjectProperty(icon.getCaption(), "alpha", durationMs, delayMs, value));
		return animatorSet;
	}
	public static Animator fadeOut(Icon icon, int durationMs, int delayMs, float... value){
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(animateObjectProperty(icon.getImage(), "alpha", durationMs, delayMs, value),animateObjectProperty(icon.getCaption(), "alpha", durationMs, delayMs, value));
		return animatorSet;
	}
	

	
	//TODO: animateSequentially
	//TODO: animateTogether
	//TODO: repeatAnimation
	//TODO: doAfterAnimation
	

	
	// a general-purpose animation creator function for changing an arbitrary
	// property of an object
	public static Animator animateObjectProperty(Object obj, String propertyName, int durationMs, int delayMs,
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
		return animObject;
	}
}
