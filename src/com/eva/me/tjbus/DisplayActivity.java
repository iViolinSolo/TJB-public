package com.eva.me.tjbus;

import com.eva.me.tjbus.util.MyAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class DisplayActivity extends Activity {
	private ImageView ivBusIcon;
	private ImageView ivProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		init();
	}

	private void init() {
		ivBusIcon = (ImageView) findViewById(R.id.bus_icon);
		ivProgressBar = (ImageView) findViewById(R.id.progress_tag);
		
		ivBusIcon.setAnimation(MyAnimation.getBusIconAnimation());
		ivProgressBar.startAnimation(MyAnimation.getProgressBarAnimation(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
