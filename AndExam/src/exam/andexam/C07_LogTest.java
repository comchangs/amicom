package exam.andexam;

import android.app.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C07_LogTest extends Activity {
	private static final String TAG = "LogTest";

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c07_logtest);
		
		Log.v(TAG, "onCreate");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			Log.v(TAG, "First Button Pressed");
			break;
		case R.id.btn2:
			Log.v(TAG, "Second Button Pressed");
			break;
		}
	}
}
	
