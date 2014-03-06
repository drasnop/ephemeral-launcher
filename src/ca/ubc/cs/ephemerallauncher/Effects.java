package ca.ubc.cs.ephemerallauncher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Effects {

	//TODO: define a theme and organize parameters such as tempDuration accordingly
	public static void changeToColor(Icon icon, long durationMs){
		
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, 0, 0f);
		
	};
	public static void changeToGreyScale(Icon icon, long durationMs){
		
		animateObjectProperty(icon.getGsImage(), "alpha", durationMs, 0, 1f);
		
	};
	
	//a general-purpose animation creator function for changing an arbitrary property of an object
	public static void animateObjectProperty(Object obj, String propertyName,  long durationMs, long delayMs, float... values){
		ObjectAnimator animObject = ObjectAnimator.ofFloat(obj, propertyName, values);
		animObject.setDuration(durationMs);
		animObject.setStartDelay(delayMs);
		
		animObject.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		animObject.start();
	}
	


}
