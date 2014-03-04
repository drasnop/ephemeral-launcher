package ca.ubc.cs.deprecated;

import ca.ubc.cs.ephemerallauncher.R;
import ca.ubc.cs.ephemerallauncher.R.color;
import ca.ubc.cs.ephemerallauncher.R.drawable;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IconAdapter extends BaseAdapter {
    private Context mContext;

    public IconAdapter(Context c) {
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
        ImageView icon;
        TextView caption;
        
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	iconView=new LinearLayout(mContext);
            iconView.setLayoutParams(new GridView.LayoutParams(85, 105));
            iconView.setPadding(0,0,0,0);
            
            iconView.setOrientation(LinearLayout.VERTICAL);
        } else {
            iconView = (LinearLayout) convertView;
        }

        icon = new ImageView(mContext);
        icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        icon.setImageResource(mThumbIds[position]);
        
        caption = new TextView(mContext);
        caption.setTextColor(mContext.getResources().getColor(R.color.white));
        caption.setText("caption");
        caption.setGravity(Gravity.CENTER_HORIZONTAL);
        
        iconView.addView(caption,0);
        iconView.addView(icon,1);
        
        return iconView;
    }

    // references to our images
    private Integer[] mThumbIds    = {
    		R.drawable.icon_0, R.drawable.icon_1,
    		R.drawable.icon_2, R.drawable.icon_3,
    		R.drawable.icon_4, R.drawable.icon_5,
    		R.drawable.icon_6, R.drawable.icon_7,
    		R.drawable.icon_8, R.drawable.icon_9,
    		R.drawable.icon_10, R.drawable.icon_11,
    		R.drawable.icon_12, R.drawable.icon_13,
    		R.drawable.icon_14, R.drawable.icon_15,
    		R.drawable.icon_16, R.drawable.icon_17,
    		R.drawable.icon_18, R.drawable.icon_19
    };
}