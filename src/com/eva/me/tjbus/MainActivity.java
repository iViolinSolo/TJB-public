package com.eva.me.tjbus;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.eva.me.tjbus.bean.Info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * @author EVA
 * 两个bug...... 一个是北苑的显示文字line:35 还有一个是line:127
 */
public class MainActivity extends Activity {

	private Button btnConfirm;
	private EditText etName, etNo, etPath, etDate;
	private Spinner spnRoutes;
	private Context context;
	private Info info = null;
	private int selectItemId = 0;//默认是第0个
	private ArrayAdapter<CharSequence> arrayAdapter;
	
	private static final String SiPing = "四平", JiaDing = "嘉定", HuXi = "沪西", BeiYuan = "????", CaoYang = "曹杨";
	private static final String orderSuffix = "2828730";
	
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
		
		//init adapter
		arrayAdapter = ArrayAdapter.createFromResource(context, R.array.spn_routes, android.R.layout.simple_spinner_item);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnRoutes.setAdapter(arrayAdapter);
		
		//init listener
		btnConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				initOnClick();
			}
		});
		
		spnRoutes.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				showToast("position: "+position+" id: "+id+" item content: "+arrayAdapter.getItem(position), context);
				selectItemId = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				showToast("Nothing selected!", context);
			}
			
		});
		
	}

	protected void initOnClick() {
		String order="";
		String name = etName.getText().toString();
		String no = etNo.getText().toString();
		String path = etPath.getText().toString();
		String date = etDate.getText().toString();
		String routesBgn="";
		String routesDes="";
		int imgResID=-1;
		
		//init order
		long time = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatResult = new SimpleDateFormat("yyyyMMddHHmmss");
		Date sysDate = new Date(time);
		String sysTime = format.format(sysDate);
		String sysResult = formatResult.format(sysDate);
		Log.e("MainActivity",	sysTime+"\n"+"result is : "+sysResult);
		order = sysResult+orderSuffix;
	
		//init routesBgn & routesDes & imgResID......
		switch (selectItemId) {
		case 0:
			routesBgn = SiPing;
			routesDes = JiaDing;
			imgResID = R.drawable.tj_pic_siping;
			break;
		case 1:
			routesBgn = JiaDing;
			routesDes = SiPing;
			imgResID = R.drawable.tj_pic_jiading_to_other;
			break;
		case 2:
			routesBgn = HuXi;
			routesDes = JiaDing;
			imgResID = R.drawable.tj_pic_huxi;
			break;
		case 3:
			routesBgn = JiaDing;
			routesDes = HuXi;
			imgResID = R.drawable.tj_pic_jiading_to_beiyuan_or_huxi;
			break;
		case 4:
			routesBgn = BeiYuan;
			routesDes = JiaDing;
			imgResID = R.drawable.ic_launcher;//。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
			break;
		case 5:
			routesBgn = JiaDing;
			routesDes = BeiYuan;
			imgResID = R.drawable.tj_pic_jiading_to_beiyuan_or_huxi;
			break;
		case 6:
			routesBgn = CaoYang;
			routesDes = JiaDing;
			imgResID = R.drawable.tj_pic_caoyang;
			break;
		case 7:
			routesBgn = JiaDing;
			routesDes = CaoYang;
			imgResID = R.drawable.tj_pic_jiading_to_other;
			break;
		default:
			break;
		}
		
		if ( name.equals("") || no.equals("") || path.equals("") || date.equals("") ) {
			showToast("Not Complete...", context);
			return;
		}
		
		info = new Info(order, name, no, date, path, routesBgn, routesDes, imgResID);
		
		Intent iStDisplayAc = new Intent();
		iStDisplayAc.setClass(MainActivity.this, DisplayActivity.class);
		if (info != null) {
			Bundle bundle = new Bundle();
			bundle.putSerializable("info", info);
			iStDisplayAc.putExtras(bundle);
		}
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
