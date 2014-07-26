package ca.ubc.cs.ephemerallauncher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SetupActivity extends FragmentActivity {

	private TextView mDelayMessage;
	private TextView mDurationMessage;
	private TextView mDelayValue;
	private TextView mDurationValue;
	private SeekBar mDelayBar;
	private SeekBar mDurationBar;
	private Button mOKButton;
	private SeekBar mSizeBar;
	private SeekBar mRotationBar;
	private SeekBar mNumHighlightedBar;
	private TextView mNumMessage;
	private TextView mNumValue;
	private TextView mSizeMessage;
	private TextView mSizeValue;
	private TextView mRotationMessage;
	private TextView mRotationValue;
	private int currDelay;
	private int currDuration;
	private int currSize;
	private int currRotation;
	private int currNum;
	
	
	public static final String EXTRA_DELAY = "ca.ubc.cs.ephemerallauncher.delay";
	public static final String EXTRA_DURATION = "ca.ubc.cs.ephemerallauncher.duration";
	public static final String EXTRA_SIZE = "ca.ubc.cs.ephemerallauncher.size";
	public static final String EXTRA_ROTATION = "ca.ubc.cs.ephemerallauncher.rotation";
	public static final String EXTRA_HIGHLIGHTED_ICONS = "ca.ubc.cs.ephemerallauncher.num";
	
	private void updateDelay(){
		mDelayValue.setText(String.valueOf(mDelayBar.getProgress()));
	}
	
	private void updateDuration(){
		mDurationValue.setText(String.valueOf(mDurationBar.getProgress()));
	}
	
	private void updateSize(){
		mSizeValue.setText(String.valueOf(mSizeBar.getProgress()));
	}
	
	private void updateRotation(){
		mRotationValue.setText(String.valueOf(mRotationBar.getProgress()));
	}
	
	private void updateNum(){
		mNumValue.setText(String.valueOf(mNumHighlightedBar.getProgress()));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);
		
		currDelay = (Integer)getIntent().getSerializableExtra(EXTRA_DELAY);
		currDuration = (Integer)getIntent().getSerializableExtra(EXTRA_DURATION);
		currSize = (Integer)getIntent().getSerializableExtra(EXTRA_SIZE);
		currRotation = (Integer)getIntent().getSerializableExtra(EXTRA_ROTATION);
		currNum = (Integer)getIntent().getSerializableExtra(EXTRA_HIGHLIGHTED_ICONS);
		
		mDelayMessage = (TextView)findViewById(R.id.delay_message);
		mDelayMessage.setText(R.string.delay_message);
		
		mDelayBar = (SeekBar)findViewById(R.id.delay_seekBar);
		mDelayBar.setMax(Parameters.MAX_DELAY);
		mDelayBar.incrementProgressBy(100);
		mDelayBar.setProgress(currDelay);
		mDelayBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress /= 100;
				progress *= 100;
				currDelay = progress;
				mDelayBar.setProgress(progress);
				updateDelay();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				
			}
			
		});
		
		mDelayValue = (TextView)findViewById(R.id.delay_value);
		updateDelay();
		
		
		mDurationMessage= (TextView)findViewById(R.id.duration_message);
		mDurationMessage.setText(R.string.duration_message);
		
		mDurationBar = (SeekBar)findViewById(R.id.duration_seekBar);
		mDurationBar.setMax(Parameters.MAX_DURATION);
		mDurationBar.incrementProgressBy(100);
		mDurationBar.setProgress(currDuration);
		mDurationBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress /= 100;
				progress *= 100;
				currDuration = progress;
				mDurationBar.setProgress(progress);
				updateDuration();
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				
			}
			
		});
		
		mDurationValue = (TextView)findViewById(R.id.duration_value);
		updateDuration();
		
		mSizeMessage = (TextView)findViewById(R.id.size_message);
		mSizeMessage.setText(R.string.size_message);
		
		mSizeBar = (SeekBar)findViewById(R.id.size_seekBar);
		mSizeBar.setMax(Parameters.MAX_SIZE);
		mSizeBar.incrementProgressBy(10);
		mSizeBar.setProgress(currSize);
		mSizeBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress /= 10;
				progress *= 10;
				currSize = progress;
				mSizeBar.setProgress(progress);
				updateSize();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			
				
			}
			
		});
		
		mSizeValue = (TextView)findViewById(R.id.size_value);
		updateSize();
		
		mRotationMessage = (TextView)findViewById(R.id.rotation_message);
		mRotationMessage.setText(R.string.rotation_message);
		
		mRotationBar = (SeekBar)findViewById(R.id.rotation_seekBar);
		mRotationBar.setMax(Parameters.MAX_DEGREE);
		mRotationBar.incrementProgressBy(10);
		mRotationBar.setProgress(currRotation);
		mRotationBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress /= 10;
				progress *= 10;
				currRotation = progress;
				mRotationBar.setProgress(progress);
				updateRotation();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			
				
			}
			
		});
		
		mRotationValue = (TextView)findViewById(R.id.rotation_value);
		updateRotation();
		
		mNumMessage = (TextView)findViewById(R.id.num_message);
		mNumMessage.setText(R.string.num_message);
		
		mNumHighlightedBar = (SeekBar)findViewById(R.id.num_seekBar);
		mNumHighlightedBar.setMax(Parameters.MAX_HIGHLIGHTED_ICONS);
		mNumHighlightedBar.setProgress(currNum);
		mNumHighlightedBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				currNum = progress;
				mNumHighlightedBar.setProgress(progress);
				updateNum();
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				
			}
			
		});
		
		mNumValue = (TextView)findViewById(R.id.num_value);
		updateNum();
		
		
		mOKButton = (Button)findViewById(R.id.ok_button);
		mOKButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra(EXTRA_DELAY, currDelay);
				data.putExtra(EXTRA_DURATION, currDuration);
				data.putExtra(EXTRA_SIZE, currSize);
				data.putExtra(EXTRA_ROTATION, currRotation);
				data.putExtra(EXTRA_HIGHLIGHTED_ICONS, currNum);
				setResult(RESULT_OK, data);
				finish();
			}
			
		});
		
	}

}
