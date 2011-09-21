package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C16_LongTime extends Activity {
	int mValue;
	TextView mText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c16_longtime);

		mText=(TextView)findViewById(R.id.text);
	}
	
	public void mOnClick(View v) {
		mValue = 0;
		Update();
	}
	
	public void Update() {
		for (int i=0;i<100;i++) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try { Thread.sleep(50); } catch (InterruptedException e) {;}
		}
	}
}





