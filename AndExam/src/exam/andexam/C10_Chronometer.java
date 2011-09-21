package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_Chronometer extends Activity {
	Chronometer mChrono;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_choronometer);
		
		mChrono = (Chronometer)findViewById(R.id.chrono);
	}
	
	public void onDestroy() {
		super.onDestroy();
		mChrono.stop();
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnstart:
			mChrono.start();
			break;
		case R.id.btnstop:
			mChrono.stop();
			break;
		case R.id.btnreset:
			mChrono.setBase(SystemClock.elapsedRealtime());
			break;
		}
	}
}
