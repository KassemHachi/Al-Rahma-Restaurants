package com.softvenue.restramadan17;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;

public class AboutusActivity extends AppCompatActivity {
	
	
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout fbl;
	private ImageView fbi;
	private TextView fbt;
	
	private Intent fb = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aboutus);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		fbl = (LinearLayout) findViewById(R.id.fbl);
		fbi = (ImageView) findViewById(R.id.fbi);
		fbt = (TextView) findViewById(R.id.fbt);
		
		fbl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fb.setAction(Intent.ACTION_VIEW);
				fb.setData(Uri.parse("https://www.facebook.com/SoftVenue"));
				startActivity(fb);
			}
		});
		
		fbi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fb.setAction(Intent.ACTION_VIEW);
				fb.setData(Uri.parse("https://facebook.com/SoftVenue"));
				startActivity(fb);
			}
		});
		
		fbt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fb.setAction(Intent.ACTION_VIEW);
				fb.setData(Uri.parse("https://facebook.com/SoftVenue"));
				startActivity(fb);
			}
		});
	}
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
