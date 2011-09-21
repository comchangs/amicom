package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_DetectFree extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c22_detectfree);
	}

	public void mOnClick(View v) {
		Intent intent = new Intent();
		intent.setAction("exam.andexam.FREEWIFI");
		sendBroadcast(intent);
	}
}