package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C11_Measuring2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c11_measuring2);

		final MeasView meas = (MeasView)findViewById(R.id.meas);
		final TextView text = (TextView)findViewById(R.id.text);
		text.postDelayed(new Runnable() {
			public void run() {
				text.setText(meas.mResult);
			}
		}, 100);
	}
}


