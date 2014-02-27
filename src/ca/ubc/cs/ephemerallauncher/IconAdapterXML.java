package ca.ubc.cs.ephemerallauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconAdapterXML extends BaseAdapter {
	private Context mContext;

	public IconAdapterXML(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout iconView;

		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			iconView = (LinearLayout) LayoutInflater.from(mContext).inflate(
					R.layout.icon_with_caption, null);
		} else {
			iconView = (LinearLayout) convertView;
		}

		ImageView icon = (ImageView) iconView.findViewById(R.id.icon);
		icon.setImageResource(mThumbIds[position]);

		TextView caption = (TextView) iconView.findViewById(R.id.caption);
		caption.setText("caption");

		return iconView;
	}

	// references to our images
	private Integer[] mThumbIds = { R.drawable.icon_0, R.drawable.icon_1,
			R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4,
			R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7,
			R.drawable.icon_8, R.drawable.icon_9, R.drawable.icon_10,
			R.drawable.icon_11, R.drawable.icon_12, R.drawable.icon_13,
			R.drawable.icon_14, R.drawable.icon_15, R.drawable.icon_16,
			R.drawable.icon_17, R.drawable.icon_18, R.drawable.icon_19 };
}