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
	private int currDelay;
	private int currDuration;
	
	
	public static final String EXTRA_DELAY = "ca.ubc.cs.ephemerallauncher.delay";
	public static final String EXTRA_DURATION = "ca.ubc.cs.ephemerallauncher.duration";
	
	private void updateDelay(){
		mDelayValue.setText(String.valueOf(mDelayBar.getProgress()));
	}
	
	private void updateDuration(){
		mDurationValue.setText(String.valueOf(mDurationBar.getProgress()));
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);
		
		currDelay = (Integer)getIntent().getSerializableExtra(EXTRA_DELAY);
		currDuration = (Integer)getIntent().getSerializableExtra(EXTRA_DURATION);
		
		mDelayMessage = (TextView)findViewById(R.id.delay_message);
		mDelayMessage.setText(R.string.delay_message);
		
		mDelayBar = (SeekBar)findViewById(R.id.delay_seekBar);
		mDelayBar.setMax(Parameters.MAX_DELAY);
		mDelayBar.setProgress(currDelay);
		mDelayBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
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
		mDurationBar.setProgress(currDuration);
		mDurationBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
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
		
		mOKButton = (Button)findViewById(R.id.ok_button);
		mOKButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra(EXTRA_DELAY, currDelay);
				data.putExtra(EXTRA_DURATION, currDuration);
				setResult(RESULT_OK, data);
				finish();
			}
			
		});
		
	}

}
