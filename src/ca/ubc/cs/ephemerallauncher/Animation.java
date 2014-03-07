package ca.ubc.cs.ephemerallauncher;


public class Animation {

	public static void color(Icon icon){
		Effects.changeToColor(icon);
	};
	
	public static void zoom_in(Icon icon){
		Effects.changeSize(icon,Parameters.ZOOM__DURATION,Parameters.DELAY,Parameters.SIZE__SMALL,Parameters.SIZE__REG);
	}
	
	public static void zoom_out(Icon icon){
		Effects.changeSize(icon,Parameters.ZOOM__DURATION,Parameters.DELAY,Parameters.SIZE__BIG,Parameters.SIZE__REG);
	}
	
	public static void pulse_in(Icon icon){
		Effects.changeSize(icon,Parameters.PULSE__1STHALF_DURATION,Parameters.DELAY,Parameters.SIZE__REG,Parameters.SIZE__SMALL);
		Effects.changeSize(icon,Parameters.PULSE__2NDHALF_DURATION,Parameters.PULSE__DELAY,Parameters.SIZE__SMALL,Parameters.SIZE__REG);
	}
	
	public static void pulse_out(Icon icon){
		Effects.changeSize(icon,Parameters.PULSE__1STHALF_DURATION,Parameters.DELAY,Parameters.SIZE__REG,Parameters.SIZE__BIG);
		Effects.changeSize(icon,Parameters.PULSE__2NDHALF_DURATION,Parameters.PULSE__DELAY,Parameters.SIZE__BIG,Parameters.SIZE__REG);
	}
	
	public static void twist(Icon icon){
		/*Effects.rotate(icon,Parameters.SHAKE__1ST_DURATION,Parameters.DELAY,Parameters.DEGREE_REG,Parameters.DEGREE_SMALL);
		Effects.rotate(icon,Parameters.SHAKE__2ND_DURATION,Parameters.SHAKE__DELAY1,Parameters.DEGREE_SMALL,Parameters.DEGREE_BIG);
		Effects.rotate(icon,Parameters.SHAKE__3RD_DURATION,Parameters.SHAKE__DELAY2,Parameters.DEGREE_BIG,Parameters.DEGREE_REG);*/
		Effects.rotate(icon,Parameters.TWIST__1STDURATION,Parameters.DELAY,Parameters.DEGREE_SMALL,Parameters.DEGREE_BIG);
		Effects.rotate(icon,Parameters.TWIST__2NDDURATION,Parameters.TWIST__DELAY,Parameters.DEGREE_BIG,Parameters.DEGREE_REG);
	}
	
	public static void fadeIn(Icon icon){
		Effects.fadeIn(icon,Parameters.TRANSPARENCY__DURATION,Parameters.TRANSPARENCY__DELAY,Parameters.TRANSPARENCY__INTIAL,1f);
	};
	
	public static void disappear(Icon icon){
		Effects.fadeOut(icon, 0, 0,1f,Parameters.TRANSPARENCY__INTIAL);
	}
	
	public static void blur(Icon icon){
		//TODO
	};
	
	public static void interrupted_color(Icon icon){
		//TODO
	};
	
	
}
