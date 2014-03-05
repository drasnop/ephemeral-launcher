package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Icon extends LinearLayout{
	
	public Icon(Context context) {
		super(context);
	}

	public Icon(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Icon(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	
	public ImageView image(){
		return (ImageView) this.findViewById(R.id.image);
	}
	
	public ImageView image_gs(){
		return (ImageView) this.findViewById(R.id.image_gs);
	}
	
	public TextView caption(){
		return (TextView) this.findViewById(R.id.caption);
	}
}
