package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class C14_CallAdd extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c14_calladd);
	}

	public void mOnClick(View v) {
		Intent intent = new Intent("exam.andexam.ADD");
		intent.putExtra("left", 3);
		intent.putExtra("right", 4);
		startActivity(intent); 
	}
}
