package ca.ubc.cs.ephemerallauncher;

import java.util.HashSet;
import java.util.LinkedList;

import android.util.Log;
import android.view.View;

public class Parameters {

    public static final int NUM_PAGES = 5;
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
    public static final float ZOOM_IN__INIT_SIZE = 0f;
    public static final float ZOOM_IN__FINAL_SIZE = 1;
    public static final int ZOOM_IN__DURATION_SIZE = 600;  		// ms
    public static final int ZOOM_IN__DELAY_SIZE = 0;  			// ms
    
    public static enum AnimationType{
    	COLOR, SIZE_ZOOM_IN
    }
    
    public static void switchAnimationTo(AnimationType type, PagerAdapter pagerAdapter){
    	Log.v("Parameters","animation");
    	
    	ANIMATION=type;
    	
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
    	
    	// Play animation
    	pagerAdapter.getCurrentPage().getGridView().startPreAnimation();
    	pagerAdapter.getCurrentPage().getGridView().startEphemeralAnimation();
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
}
