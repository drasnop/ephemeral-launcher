package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconAdapter extends BaseAdapter {
	private Context mContext;

	public IconAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return Parameters.images.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}
	
	// create a new View for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout iconWithCaption;

		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			iconWithCaption = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.icon_with_caption_relative, null);
		} else {
			iconWithCaption = (LinearLayout) convertView;
		}

		// 
		
		// The colored image
		ImageView icon = (ImageView) iconWithCaption.findViewById(R.id.image);
		icon.setImageResource(Parameters.images[position]);
		icon.setAlpha(0f);

		// The grayscale image
		ImageView icon_gs = (ImageView) iconWithCaption.findViewById(R.id.image_gs);
		icon_gs.setImageResource(Parameters.images_gs[position]);
		icon_gs.setAlpha(1f);

		// The caption
		TextView caption = (TextView) iconWithCaption.findViewById(R.id.caption);
		caption.setText("caption");

		return iconWithCaption;
	}
}