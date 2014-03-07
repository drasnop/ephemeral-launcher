package ca.ubc.cs.ephemerallauncher;

import java.util.LinkedList;

import android.view.View;

public class Parameters {

    public static final int NUM_PAGES = 3;
    public static final int NUM_HIGHLIGHTED_ICONS = 4;
    public static AnimationType ANIMATION = AnimationType.COLOR;		// Will be used as initial animation type
    public static boolean ANIMATION_AFFECTS_OTHER_ICONS;				// Will be initialized automatically
    public static boolean ANIMATION_HAS_PREANIMATION_STATE;				// Will be initialized automatically
    
    public static final boolean HIGLIGHT_ICONS_EARLY = true;			// if true, the icons are highlighted when the user starts scrolling to the next page
    																	// if false, they are highlighted only when the user lands on the next page
    
    // for non-highlighted icons
    public static final int COLOR__START_DELAY = 500;			// ms 
    public static final int COLOR__FADE_IN_DURATION = 1000;  	// ms 

	// for highlighted icons
    public static final int DELAY = 0;
    public static final int TOTAL_DURATION = 600;
    // size
    public static final float SIZE__SMALL = 0.5f;
    public static final float SIZE__BIG = 1.5f;
    public static final float SIZE__REG = 1;			// original size
    public static final int ZOOM__DURATION = TOTAL_DURATION;  		// ms
    public static final int PULSE__DELAY = 300;  		
    public static final int PULSE__1STHALF_DURATION = PULSE__DELAY;
    public static final int PULSE__2NDHALF_DURATION = TOTAL_DURATION - PULSE__1STHALF_DURATION;
    // rotation
    public static final float DEGREE_SMALL = -60f; // rotate from 0 to -60 is counterclockwise rotation; 60f as 60 degree
    public static final float DEGREE_BIG = 60f;
    public static final float DEGREE_REG = 0f;
    public static final int TWIST__DELAY = 400;
    public static final int TWIST__1STDURATION = 400;
    public static final int TWIST__2NDDURATION = TOTAL_DURATION - TWIST__1STDURATION;
 /* 	a different type of twist/shake   
  * public static final int SHAKE__DELAY1 = 150;
    public static final int SHAKE__DELAY2 = 300;
    public static final int SHAKE__1ST_DURATION = SHAKE__DELAY1;
    public static final int SHAKE__2ND_DURATION = SHAKE__DELAY2;
    public static final int SHAKE__3RD_DURATION = TOTAL_DURATION - SHAKE__DELAY1 - SHAKE__DELAY2;*/
    
    
    public static enum AnimationType{
    	COLOR, SIZE_ZOOM_IN, SIZE_ZOOM_OUT, SIZE_PULSE_IN, SIZE_PULSE_OUT, TRANSPARENCY, BLUR, INTERRUPTED_COLOR, TWIST
    }
    
    public static void switchAnimationTo(AnimationType type){
    	ANIMATION=type;
    	/* 1. Antoine - anything not related to effect (mostly pre-swipe display)
    	   2. New effects:  
    		DONE	shake(rotation?) 	- Kailun 
    		DONE	(size) zoom_out		- Kailun 
    		DONE	(size) pulse_in		- Kailun/Kamyar
    		DONE	(size) pulse_out	- Kailun/Kamyar
 					transparency (alpha) - Kamyar?
 					blur				- Antoine
 					interrupted Color 	- Kamyar (if time is permitted)
 			comment: for all size animation, the current rule of thumb is to always end at regular size, i.e.,1.
 			3. Kailun - (if time permitted) setup menu and sub-menu (for color and size effect) 
    	
*/
    	
    	switch(ANIMATION){
    	case COLOR:	
    		ANIMATION_AFFECTS_OTHER_ICONS=true;
    		ANIMATION_HAS_PREANIMATION_STATE=true;
    		break;
		default:
			ANIMATION_AFFECTS_OTHER_ICONS=false;
			ANIMATION_HAS_PREANIMATION_STATE=false;
			break;
    	}
    	
    	// Show / hide particular images if necessary
    	switch(ANIMATION){
    	case COLOR:	
    		showAll(images_gs);
    		break;
		default:
			hideAll(images_gs);
			break;
    	}
    	
    }
    
	// IDs of our images
	public static final Integer[] images_gs_ID = {R.drawable.icon_0_gs, R.drawable.icon_1_gs,
			R.drawable.icon_2_gs, R.drawable.icon_3_gs, R.drawable.icon_4_gs,
			R.drawable.icon_5_gs, R.drawable.icon_6_gs, R.drawable.icon_7_gs,
			R.drawable.icon_8_gs, R.drawable.icon_9_gs, R.drawable.icon_10_gs,
			R.drawable.icon_11_gs, R.drawable.icon_12_gs, R.drawable.icon_13_gs,
			R.drawable.icon_14_gs, R.drawable.icon_15_gs, R.drawable.icon_16_gs,
		    R.drawable.icon_17_gs, R.drawable.icon_18_gs, R.drawable.icon_19_gs};
	
	public static final Integer[] images_ID= { R.drawable.icon_0, R.drawable.icon_1,
			R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4,
			R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7,
			R.drawable.icon_8, R.drawable.icon_9, R.drawable.icon_10,
			R.drawable.icon_11, R.drawable.icon_12, R.drawable.icon_13,
			R.drawable.icon_14, R.drawable.icon_15, R.drawable.icon_16,
			R.drawable.icon_17, R.drawable.icon_18, R.drawable.icon_19 };
	
	public static final Integer[] captions_ID = {R.string.icon_0_cap, R.string.icon_1_cap, 
			R.string.icon_2_cap, R.string.icon_3_cap, R.string.icon_4_cap, 
			R.string.icon_5_cap, R.string.icon_6_cap, R.string.icon_7_cap,
			R.string.icon_8_cap, R.string.icon_9_cap, R.string.icon_10_cap,
			R.string.icon_11_cap, R.string.icon_12_cap, R.string.icon_13_cap,
			R.string.icon_14_cap, R.string.icon_15_cap, R.string.icon_16_cap,
			R.string.icon_17_cap, R.string.icon_18_cap, R.string.icon_19_cap};
	
	
	// References to the greyscale images
	public static LinkedList<View> images_gs=new LinkedList<View>();
	
	private static void hideAll(LinkedList<View> views){
		for(View v:views)
			v.setVisibility(View.GONE);
	}
	
	private static void showAll(LinkedList<View> views){
		for(View v:views)
			v.setVisibility(View.VISIBLE);
	}
	
	
}
