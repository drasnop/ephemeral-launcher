package ca.ubc.cs.ephemerallauncher;

import android.util.Log;

public class Parameters {
	
	public static void propagateParameters(){
		TWIST__0THDURATION = (int)((((float)TWIST__0THDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
	    TWIST__1STDURATION = (int)((((float)TWIST__1STDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
	    TWIST__2NDDURATION = (int)((((float)TWIST__2NDDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
	    PULSE__1STHALF_DURATION = (TOTAL_DURATION / 2);
	    PULSE__2NDHALF_DURATION = TOTAL_DURATION - PULSE__1STHALF_DURATION;
	}

    public static final int NUM_PAGES = 6;
    public static final int NUM_ICONS_PER_PAGE = 20;
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
    // set to mutable to make customizable
    public static int DELAY = 500;
    public static int TOTAL_DURATION = 1000;
    public static final int MAX_DELAY = 1000;
    public static final int MAX_DURATION = 1000;
    
    
    // size
    public static final float SIZE__SMALL = 0.7f;
    public static final float SIZE__BIG = 1.25f;
    public static final float SIZE__REG = 1;						// original size
    // public static final int ZOOM__DURATION = TOTAL_DURATION;  	// commented out because we are using TOTAL_DURATION anyways
    // public static final int PULSE__DELAY = 300;  				// commented out, deprecated
    
    // set to mutable because TOTAL_DURATION has been made mutable
    public static int PULSE__1STHALF_DURATION = (TOTAL_DURATION / 2);
    public static int PULSE__2NDHALF_DURATION = TOTAL_DURATION - PULSE__1STHALF_DURATION;
    // rotation
    public static final float DEGREE_BIG = 15f;	 			// rotate from 0 to -60 is counterclockwise rotation; 60f as 60 degree
    public static final float DEGREE_SMALL = -DEGREE_BIG;	// [AP] wouldn't it always be - DEGREE_SMALL?
    public static final float DEGREE_REG = 0f;
    public static final int TWIST__DELAY = 400;
    public static final int TWIST__0THDURATION_REL = 1;
    public static final int TWIST__1STDURATION_REL = 2;
    public static final int TWIST__2NDDURATION_REL = 1;
    
    public static final int TWIST_TOTAL_REL_DURATION = TWIST__0THDURATION_REL + TWIST__1STDURATION_REL + TWIST__2NDDURATION_REL;
    
    public static final int TWIST_REPEAT_NUM = 1;
    
    // set to mutable because TOTAL_DURATION has been made mutable
    public static int TWIST__0THDURATION = (int)((((float)TWIST__0THDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
    public static int TWIST__1STDURATION = (int)((((float)TWIST__1STDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
    public static int TWIST__2NDDURATION = (int)((((float)TWIST__2NDDURATION_REL)/((float)(TWIST_REPEAT_NUM * TWIST_TOTAL_REL_DURATION)))*((float)TOTAL_DURATION));
    
    
    // transparency
    public static final int TRANSPARENCY__DELAY = 100;
    public static final int TRANSPARENCY__DURATION = 1500;
    public static final float TRANSPARENCY__INTIAL = 0.4f;
    
    public static int BACKGROUND=1;		// 0=dark 1=ios 2=light
    
    public static enum AnimationType{
    	COLOR, SIZE_ZOOM_IN, SIZE_ZOOM_OUT, SIZE_PULSE_IN, SIZE_PULSE_OUT, TRANSPARENCY, BLUR, TWIST
    }
    
    public static void switchAnimationTo(AnimationType type, PagerAdapter pagerAdapter){
    	Log.v("Parameters","animation");
    	
    	ANIMATION=type;
 	
    	switch(ANIMATION){
    	case COLOR:
    	case TRANSPARENCY:
    	case BLUR:	
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
	public static final Integer[] images_ID= { R.drawable.icon_0, R.drawable.icon_1,
			R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4,
			R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7,
			R.drawable.icon_8, R.drawable.icon_9, R.drawable.icon_10,
			R.drawable.icon_11, R.drawable.icon_12, R.drawable.icon_13,
			R.drawable.icon_14, R.drawable.icon_15, R.drawable.icon_16,
			R.drawable.icon_17, R.drawable.icon_18, R.drawable.icon_19 };
	
	public static final Integer[] images_gs_ID = {R.drawable.icon_0_gs, R.drawable.icon_1_gs,
		R.drawable.icon_2_gs, R.drawable.icon_3_gs, R.drawable.icon_4_gs,
		R.drawable.icon_5_gs, R.drawable.icon_6_gs, R.drawable.icon_7_gs,
		R.drawable.icon_8_gs, R.drawable.icon_9_gs, R.drawable.icon_10_gs,
		R.drawable.icon_11_gs, R.drawable.icon_12_gs, R.drawable.icon_13_gs,
		R.drawable.icon_14_gs, R.drawable.icon_15_gs, R.drawable.icon_16_gs,
		R.drawable.icon_17_gs, R.drawable.icon_18_gs, R.drawable.icon_19_gs};
	
	public static final Integer[] images_b_ID = {R.drawable.icon_0_b, R.drawable.icon_1_b,
		R.drawable.icon_2_b, R.drawable.icon_3_b, R.drawable.icon_4_b,
		R.drawable.icon_5_b, R.drawable.icon_6_b, R.drawable.icon_7_b,
		R.drawable.icon_8_b, R.drawable.icon_9_b, R.drawable.icon_10_b,
		R.drawable.icon_11_b, R.drawable.icon_12_b, R.drawable.icon_13_b,
		R.drawable.icon_14_b, R.drawable.icon_15_b, R.drawable.icon_16_b,
		R.drawable.icon_17_b, R.drawable.icon_18_b, R.drawable.icon_19_b};
	
	public static final Integer[] captions_ID = {R.string.icon_0_cap, R.string.icon_1_cap, 
			R.string.icon_2_cap, R.string.icon_3_cap, R.string.icon_4_cap, 
			R.string.icon_5_cap, R.string.icon_6_cap, R.string.icon_7_cap,
			R.string.icon_8_cap, R.string.icon_9_cap, R.string.icon_10_cap,
			R.string.icon_11_cap, R.string.icon_12_cap, R.string.icon_13_cap,
			R.string.icon_14_cap, R.string.icon_15_cap, R.string.icon_16_cap,
			R.string.icon_17_cap, R.string.icon_18_cap, R.string.icon_19_cap};
}
