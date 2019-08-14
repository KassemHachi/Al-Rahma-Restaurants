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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;

public class RestaurantinfActivity extends AppCompatActivity {
	
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout mpl;
	private ImageView imageview1;
	private TextView textview1;
	private TextView city;
	private TextView textview3;
	private TextView information;
	private TextView mpt;
	private ImageView mpi;
	
	private Intent map = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.restaurantinf);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		mpl = (LinearLayout) findViewById(R.id.mpl);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		city = (TextView) findViewById(R.id.city);
		textview3 = (TextView) findViewById(R.id.textview3);
		information = (TextView) findViewById(R.id.information);
		mpt = (TextView) findViewById(R.id.mpt);
		mpi = (ImageView) findViewById(R.id.mpi);
		
		mpl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map.setAction(Intent.ACTION_VIEW);
				map.setData(Uri.parse("geo:?q=".concat(getIntent().getStringExtra("Map"))));
				startActivity(map);
			}
		});
		
		mpt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map.setAction(Intent.ACTION_VIEW);
				map.setData(Uri.parse("geo:?q=".concat(getIntent().getStringExtra("Map"))));
				startActivity(map);
			}
		});
		
		mpi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map.setAction(Intent.ACTION_VIEW);
				map.setData(Uri.parse("geo:?q=".concat(getIntent().getStringExtra("Map"))));
				startActivity(map);
			}
		});
	}
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		city.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		information.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		mpt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		city.setText(getIntent().getStringExtra("City"));
		information.setText(getIntent().getStringExtra("Information"));
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
