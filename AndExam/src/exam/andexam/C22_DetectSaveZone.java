package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_DetectSaveZone extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c22_detectsavezone);
	}
	
	public void mOnClick(View v) {
		v.postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent();
				intent.setAction("exam.andexam.SAVEZONE");
				sendBroadcast(intent);
			}
		}, 10000);
	}	
}