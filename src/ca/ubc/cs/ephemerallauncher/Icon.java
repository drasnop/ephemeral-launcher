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

	
	public ImageView getImage(){
		return (ImageView) this.findViewById(R.id.image);
	}
	
	public ImageView getImageGs(){
		return (ImageView) this.findViewById(R.id.image_gs);
	}
	
	public ImageView getImageB(){
		return (ImageView) this.findViewById(R.id.image_b);
	}
	
	public TextView getCaption(){
		return (TextView) this.findViewById(R.id.caption);
	}
}
