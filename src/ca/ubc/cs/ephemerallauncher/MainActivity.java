package ca.ubc.cs.ephemerallauncher;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Set up grid view
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		//gridview.setAdapter(new IconAdapter(this));    // deprecated
		gridview.setAdapter(new IconAdapterXML(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	            //v.setVisibility(View.GONE);
	        }
	    });
	    
	    /*Registering a global layout listener
	    so that startInteraction is invoked when gridView is loaded completely*/
	    
	    gridview.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
	    	public void onGlobalLayout() {
	    		startInteraction();
	    	}
	    });
	    
	    

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startInteraction() {
		
		testAnimation();
		//GridView gridview = (GridView) findViewById(R.id.gridview);
		//gridview.getChildAt(0).setAlpha(0.5f);
		/*int size = gridview.getChildCount();
	    for(int i = 0; i < size; i++) {
	      ViewGroup gridChild = (ViewGroup) gridview.getChildAt(i);
	      gridChild.setVisibility(View.GONE);
	      int childSize = gridChild.getChildCount();
	      for(int k = 0; k < childSize; k++) {
	        if( gridChild.getChildAt(k) instanceof ImageView ) {
	          gridChild.getChildAt(k).setVisibility(View.GONE);
	        }
	      }
	    }*/
	}
	
	public void testAnimation() {
		GridView gridview = (GridView) findViewById(R.id.gridview);
		ViewGroup firstChild = (ViewGroup) gridview.getChildAt(0);
		ObjectAnimator anim = ObjectAnimator.ofFloat(firstChild, "alpha", 0f, 1f);
		anim.setDuration(3000);
		anim.start();
		
	}

}
