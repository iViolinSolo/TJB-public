package com.eva.me.tjbus;

import com.eva.me.tjbus.bean.Info;
import com.eva.me.tjbus.util.MyAnimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends Activity {
	private ImageView ivBusIcon;
	private ImageView ivProgressBar;
	private TextView tvLiushui, tvName, tvUserName, tvWhenToGo, tvStartPlace, tvEndPlace, tvPathLine;
	private ImageView ivPicture;

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
		
		Intent iFroMainAct = getIntent();
		Bundle bundle = iFroMainAct.getExtras();
		Info info = (Info) bundle.getSerializable("info");
		
		String order = info.getOrder();
		String name = info.getName();
		String no = info.getNo();
		String time = info.getTime();
		String path = info.getPath();
		String routesBgn = info.getRoutesBgn();
		String routesDes = info.getRoutesDes();
		int imgResID = info.getImgResID();
		
		Log.w("DisplayActivity", "order: "+order+" name: "+name+" no: "+no
				+" time: "+time+" path: "+path+" routesBgn: "+routesBgn+
				" routesDes: "+routesDes+" imgResID: "+imgResID);
		
		//init Views
		ivPicture = (ImageView) findViewById(R.id.picture);
		tvName = (TextView) findViewById(R.id.name);
		tvEndPlace = (TextView) findViewById(R.id.end_place);
		tvLiushui = (TextView) findViewById(R.id.liushui);
		tvPathLine = (TextView) findViewById(R.id.path_line);
		tvStartPlace = (TextView) findViewById(R.id.start_place);
		tvUserName = (TextView) findViewById(R.id.username);
		tvWhenToGo = (TextView) findViewById(R.id.when_to_go);
		
		tvEndPlace.setText(routesDes);
		tvLiushui.setText(tvLiushui.getText()+order);
		tvName.setText(name);
		tvPathLine.setText(path);
		tvStartPlace.setText(routesBgn);
		tvUserName.setText(no);
		tvWhenToGo.setText(time);
		ivPicture.setBackgroundResource(imgResID);
		
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
