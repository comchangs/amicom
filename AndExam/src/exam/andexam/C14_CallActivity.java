package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C14_CallActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c14_callactivity);
	}

	public void mOnClick(View v) {
		Intent intent = new Intent(this, C14_SubActivity.class);
		startActivity(intent);
	}
}
