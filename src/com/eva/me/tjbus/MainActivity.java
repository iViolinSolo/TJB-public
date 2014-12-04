package com.eva.me.tjbus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnConfirm;
	private EditText etName, etNo, etPath, etDate;
	private Spinner spnRoutes;
	private Context context;
	
	private void showToast(String str, Context context) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = MainActivity.this;
		Toast.makeText(context, "友情提示：乘车时间中\"日\"和\"小时\"中间是有一个空格的", Toast.LENGTH_LONG).show();
//		showToast("友情提示：乘车时间中\"日\"和\"小时\"中间是有一个空格的", context);
		init();
	}

	private void init() {
		//init Views
		etName = (EditText) findViewById(R.id.etName);
		etNo = (EditText) findViewById(R.id.etNo);
		etPath = (EditText) findViewById(R.id.etPath);
		etDate = (EditText) findViewById(R.id.etDate);
		spnRoutes = (Spinner) findViewById(R.id.spnRoutes);
		btnConfirm = (Button) findViewById(R.id.button1);
		spnRoutes = (Spinner) findViewById(R.id.spnRoutes);
		
		//init adapter
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, R.array.spn_routes, android.R.layout.simple_spinner_item);
		spnRoutes.setAdapter(arrayAdapter);
		
		//init listener
		btnConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				initOnClick();
			}
		});
		
		
	}

	protected void initOnClick() {
		String name = etName.getText().toString();
		String no = etNo.getText().toString();
		String path = etPath.getText().toString();
		String date = etDate.getText().toString();
		
		if ( name.equals("") || no.equals("") || path.equals("") || date.equals("") ) {
			showToast("Not Complete...", context);
			return;
		}
		
		Intent iStDisplayAc = new Intent();
		iStDisplayAc.setClass(MainActivity.this, DisplayActivity.class);
		startActivity(iStDisplayAc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
