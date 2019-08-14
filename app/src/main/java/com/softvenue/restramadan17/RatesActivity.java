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
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import android.graphics.Typeface;

public class RatesActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> mp = new HashMap<>();
	
	private LinearLayout linear4;
	private EditText edittext1;
	private LinearLayout rbl;
	private LinearLayout linear7;
	private LinearLayout sendl;
	private TextView textview1;
	private TextView rbt;
	private TextView sendt;
	
	private DatabaseReference database = _firebase.getReference("ratesrestaurant");
	private ChildEventListener _database_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.rates);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		rbl = (LinearLayout) findViewById(R.id.rbl);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		sendl = (LinearLayout) findViewById(R.id.sendl);
		textview1 = (TextView) findViewById(R.id.textview1);
		rbt = (TextView) findViewById(R.id.rbt);
		sendt = (TextView) findViewById(R.id.sendt);
		
		sendl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_addrate();
			}
		});
		
		sendt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_addrate();
			}
		});
		
		_database_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				SketchwareUtil.showMessage(getApplicationContext(), "شكرا، لقد تم إرسال تقييمك ");
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), "عذرا، فشل في الإرسال تفحص الانترنت ثم اعد المحاولة");
			}
		};
		database.addChildEventListener(_database_child_listener);
	}
	private void initializeLogic() {
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		sendt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		rb = new RatingBar (this);
		rb.setNumStars(5);
		rb.setStepSize(0.5f);
		rb.setRating(0f);
		rbl.addView(rb);
		
		
		
		rb.setOnRatingBarChangeListener(new
		RatingBar.OnRatingBarChangeListener(){
			@Override
			public void
			onRatingChanged(RatingBar
			rating, float r, boolean user){
				
				rbt.setText(String.valueOf(rb.getRating()));
			}
		});
		
	}
	RatingBar rb;
	
	private void nothing (){
		
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _addrate () {
		mp = new HashMap<>();
		mp.put("اقتراح ", edittext1.getText().toString());
		mp.put("تقييم ", rbt.getText().toString());
		database.child(edittext1.getText().toString()).updateChildren(mp);
		mp.clear();
		rbt.setText("");
		edittext1.setText("");
		rb.setRating(0f);
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
