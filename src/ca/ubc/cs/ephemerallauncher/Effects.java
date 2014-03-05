package ca.ubc.cs.ephemerallauncher;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Effects {

	public static void changeToColor(Icon icon){};
	public static void changeToGreyScale(Icon icon){};
	
	
	public static void crossfade(ViewGroup frame, final boolean reverse, long duration_ms, long start_delay_ms) {
		final ImageView coloredImage = ((ImageView) ((ViewGroup) frame.getChildAt(0)).getChildAt(0));
		final ImageView gsImage = ((ImageView) ((ViewGroup) frame.getChildAt(0)).getChildAt(1));

		ObjectAnimator animColor;
		if (!reverse) {
			animColor = ObjectAnimator.ofFloat(coloredImage, "alpha", 1f);
		} else {
			// coloredImage.setAlpha(1f);
			animColor = ObjectAnimator.ofFloat(coloredImage, "alpha", 0f);
		}
		animColor.setDuration(duration_ms);

		animColor.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				// if (reverse) {coloredImage.setVisibility(View.INVISIBLE);}
				// if (!reverse) {} else
				// {coloredImage.setVisibility(View.INVISIBLE);}

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				// if (!reverse) {coloredImage.setVisibility(View.VISIBLE);}
			}
		});

		ObjectAnimator animGs;
		if (!reverse) {
			// gsImage.setAlpha(1f);
			animGs = ObjectAnimator.ofFloat(gsImage, "alpha", 0f);
		} else {
			// gsImage.setAlpha(0f);
			// gsImage.setVisibility(View.VISIBLE);
			animGs = ObjectAnimator.ofFloat(gsImage, "alpha", 1.0f);
		}
		animGs.setDuration(duration_ms);

		animGs.addListener(new Animator.AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				// if (!reverse) {gsImage.setVisibility(View.INVISIBLE);}
				// if (reverse) {} else {gsImage.setVisibility(View.INVISIBLE);}
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				// if (reverse) {gsImage.setVisibility(View.VISIBLE);}
			}
		});

		AnimatorSet crossFadeSet = new AnimatorSet();
		crossFadeSet.play(animGs).with(animColor);

		crossFadeSet.setStartDelay(start_delay_ms);
		crossFadeSet.start();

		/*
		 * animColor.start(); animGs.start();
		 */

	}

}
