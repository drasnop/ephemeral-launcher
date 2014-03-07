package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
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
			icon = (Icon) LayoutInflater.from(mContext).inflate(R.layout.icon, null);
		} else {
			icon = (Icon) convertView;
		}

		// Set up the colored image
		icon.getImage().setImageResource(Parameters.images_ID[position]);

		// Set up the greyscale image
		icon.getGsImage().setImageResource(Parameters.images_gs_ID[position]);
		Parameters.images_gs.add(icon.getGsImage());

		// The caption
		icon.getCaption().setText(Parameters.captions_ID[position]);

		return icon;
	}
}