package ca.ubc.cs.ephemerallauncher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Effects {

	
	public static void changeToColor(Icon icon, long durationMs, long startDelayMs){
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, startDelayMs, 0f);
	}
	public static void changeToColor(Icon icon, long durationMs){
		
		changeToColor(icon, durationMs, 0);
		
	};
	//immediate change to color
	public static void changeToColor(Icon icon){
		changeToColor(icon, 0);
	}
	
	public static void changeToGreyScale(Icon icon, long durationMs, long startDelayMs){
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, startDelayMs, 1f);
	}
	public static void changeToGreyScale(Icon icon, long durationMs){
		
		changeToGreyScale(icon, durationMs, 0);
		
	};
	public static void changeToGreyScale(Icon icon){
		changeToGreyScale(icon, 0);
	}
	
	//a general-purpose animation creator function for changing an arbitrary property of an object
	public static void animateObjectProperty(Object obj, String propertyName,  long durationMs, long delayMs, float... values){
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
