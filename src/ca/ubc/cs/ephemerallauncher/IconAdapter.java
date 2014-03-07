package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class IconAdapter extends BaseAdapter {
	private Context mContext;

	public IconAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return Parameters.images_ID.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new View for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		Icon icon;

		if (convertView == null) {
			// if it's not recycled, initialize the view
			// [AP: I don't really understand this test...]
			// [AP: Contrary to the doc, this doesn't return parent...]
			icon=(Icon) LayoutInflater.from(mContext).inflate(R.layout.icon, parent,false);
			
			// Set up the colored image
			icon.getImage().setImageResource(Parameters.images_ID[position]);
			
			// Set up the greyscale image
			icon.getImageGs().setImageResource(Parameters.images_gs_ID[position]);
			icon.getImageGs().setVisibility(ViewGroup.GONE);
			
			// Set up the blurry image
			icon.getImageB().setImageResource(Parameters.images_b_ID[position]);
			icon.getImageB().setVisibility(ViewGroup.GONE);
			
			// The caption
			icon.getCaption().setText(Parameters.captions_ID[position]);
			
		} else {
			// [AP: I haven't quite figured out when this happens...
			icon = (Icon) convertView;
			Log.v("IconAdapter","convert view");
		}


		return icon;
	}
}