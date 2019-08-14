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
import android.support.v7.widget.Toolbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.HashMap;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	
	private LinearLayout linear7;
	private ScrollView vscroll2;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private ImageView logo;
	private TextView textview2;
	private ImageView imageview2;
	private LinearLayout linear6;
	private LinearLayout l1;
	private LinearLayout l2;
	private LinearLayout l3;
	private LinearLayout i11;
	private LinearLayout l4;
	private LinearLayout l5;
	private LinearLayout l7;
	private LinearLayout l9;
	private LinearLayout l10;
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView t11;
	private TextView t4;
	private TextView t5;
	private TextView t7;
	private TextView t9;
	private TextView t10;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_addrestl;
	private LinearLayout _drawer_addratel;
	private LinearLayout _drawer_aboutl;
	private LinearLayout _drawer_shareappl;
	private LinearLayout _drawer_reportl;
	private ImageView _drawer_imageview1;
	private TextView _drawer_addrestt;
	private TextView _drawer_addratet;
	private TextView _drawer_aboutt;
	private TextView _drawer_shareappt;
	private TextView _drawer_reportt;
	
	private DatabaseReference database = _firebase.getReference("restaurant");
	private ChildEventListener _database_child_listener;
	private Intent scr = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		logo = (ImageView) findViewById(R.id.logo);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		l1 = (LinearLayout) findViewById(R.id.l1);
		l2 = (LinearLayout) findViewById(R.id.l2);
		l3 = (LinearLayout) findViewById(R.id.l3);
		i11 = (LinearLayout) findViewById(R.id.i11);
		l4 = (LinearLayout) findViewById(R.id.l4);
		l5 = (LinearLayout) findViewById(R.id.l5);
		l7 = (LinearLayout) findViewById(R.id.l7);
		l9 = (LinearLayout) findViewById(R.id.l9);
		l10 = (LinearLayout) findViewById(R.id.l10);
		t1 = (TextView) findViewById(R.id.t1);
		t2 = (TextView) findViewById(R.id.t2);
		t3 = (TextView) findViewById(R.id.t3);
		t11 = (TextView) findViewById(R.id.t11);
		t4 = (TextView) findViewById(R.id.t4);
		t5 = (TextView) findViewById(R.id.t5);
		t7 = (TextView) findViewById(R.id.t7);
		t9 = (TextView) findViewById(R.id.t9);
		t10 = (TextView) findViewById(R.id.t10);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = (LinearLayout) _nav_view.findViewById(R.id.linear3);
		_drawer_addrestl = (LinearLayout) _nav_view.findViewById(R.id.addrestl);
		_drawer_addratel = (LinearLayout) _nav_view.findViewById(R.id.addratel);
		_drawer_aboutl = (LinearLayout) _nav_view.findViewById(R.id.aboutl);
		_drawer_shareappl = (LinearLayout) _nav_view.findViewById(R.id.shareappl);
		_drawer_reportl = (LinearLayout) _nav_view.findViewById(R.id.reportl);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_addrestt = (TextView) _nav_view.findViewById(R.id.addrestt);
		_drawer_addratet = (TextView) _nav_view.findViewById(R.id.addratet);
		_drawer_aboutt = (TextView) _nav_view.findViewById(R.id.aboutt);
		_drawer_shareappt = (TextView) _nav_view.findViewById(R.id.shareappt);
		_drawer_reportt = (TextView) _nav_view.findViewById(R.id.reportt);
		
		logo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		l1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي بن سعيد ", "طريق الشارف ", "حي بن سعيد ، Djelfa");
			}
		});
		
		l2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("جلفة جديدة ( حي 5 جويلية) ", "مقابل بزار جواف ( رياض الفتح) ", "كوسمتيك رياض الفتح بزار جواف الجلفة");
			}
		});
		
		l3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي بوتريفيس ", "المحطة البرية لبلدية الجلفة ", "Station of Road Passengers Djelfa City");
			}
		});
		
		i11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي عين الشيح", "محطة المسافرين القديمة ", "محطة المسافرين عين الشيح، Djelfa");
			}
		});
		
		l4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي باب الشارف ", "وسط المدينة ", "حي باب الشارف، Djelfa");
			}
		});
		
		l5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حاسي بحبح", "ثانوية عبدالحميد بن باديس ", "Lycee Ben Badis, Trans-Sahara Hwy, Hassi Bahbah");
			}
		});
		
		l7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("عين فقه", "وسط المدينة ", "Aïn Feka");
			}
		});
		
		l9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حد الصحاري", "مطعم الكريستال ", "Had-Sahary مطعم الكريستال");
			}
		});
		
		l10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("مجبارة", "مدرسة لقماري علي ", "Moudjbara");
			}
		});
		
		t1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي بن سعيد ", "ابتدائية قاسم سليمان ", "حي بن سعيد ، Djelfa ");
			}
		});
		
		t2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي جلفة جديدة ( حي 5 جويلية) ", "مقابل بزار جواف (رياض الفتح) ", "كوسمتيك رياض الفتح بزار جواف الجلفة");
			}
		});
		
		t3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي بوتريفيس ", "المحطة البرية لبلدية الجلفة ", "Station of Road Passengers Djelfa City");
			}
		});
		
		t11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("عين الشيح", "محطة المسافرين القديمة ", "محطة المسافرين عين الشيح، Djelfa");
			}
		});
		
		t4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حي باب الشارف ", "وسط المدينة ", "حي باب الشارف، Djelfa");
			}
		});
		
		t5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حاسي بحبح", "ثانوية عبدالحميد بن باديس ", "Lycee Ben Badis, Trans-Sahara Hwy, Hassi Bahbah");
			}
		});
		
		t7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("عين فقه", "وسط المدينة ", "Aïn Feka");
			}
		});
		
		t9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("حد الصحاري ", "مطعم الكريستال ", "Had-Sahary مطعم الكريستال");
			}
		});
		
		t10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_restaurant("مجبارة", "مدرسة لقماري علي ", "Moudjbara");
			}
		});
		
		_database_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
				
			}
		};
		database.addChildEventListener(_database_child_listener);
		
		_drawer_addrestl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), AddrestaurantActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_addratel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), RatesActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_aboutl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), AboutusActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_shareappl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), ShareappActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_reportl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), ReportsActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_addrestt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), AddrestaurantActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_addratet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), RatesActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_aboutt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), AboutusActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_shareappt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), ShareappActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_reportt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setClass(getApplicationContext(), ReportsActivity.class);
				startActivity(scr);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
	}
	private void initializeLogic() {
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		t11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/droidkufi.ttf"), 0);
		android.support.v7.app.ActionBar ab = getSupportActionBar();
		ab.hide();
		_changefontdrawer();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
		}
	}
	private void _restaurant (final String _city, final String _information, final String _map) {
		scr.putExtra("City", _city);
		scr.putExtra("Information", _information);
		scr.putExtra("Map", _map);
		scr.setClass(getApplicationContext(), RestaurantinfActivity.class);
		startActivity(scr);
	}
	
	
	private void _changefontdrawer () {
		_drawer_addrestt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/droidkufi.ttf"), 0);
		_drawer_addratet.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/droidkufi.ttf"), 0);
		_drawer_aboutt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/droidkufi.ttf"), 0);
		_drawer_shareappt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/droidkufi.ttf"), 0);
		_drawer_reportt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/droidkufi.ttf"), 0);
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
