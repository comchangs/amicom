package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C16_LongTime3 extends Activity {
	int mValue;
	TextView mText;
	ProgressDialog mProgress;
	boolean mQuit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c16_longtime);

		mText=(TextView)findViewById(R.id.text);
	}
	
	public void mOnClick(View v) {
		mValue = 0;
		showDialog(0);
		mQuit = false;
		mHandler.sendEmptyMessage(0);
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			mProgress = new ProgressDialog(this);
			mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgress.setTitle("Updating");
			mProgress.setMessage("Wait...");
			mProgress.setCancelable(false);
			mProgress.setButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					mQuit = true;
					dismissDialog(0);
				}
			});
			return mProgress;
		}
		return null;
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try { Thread.sleep(50); } catch (InterruptedException e) {;}
			if (mValue < 100 && mQuit == false) {
				mProgress.setProgress(mValue);
				mHandler.sendEmptyMessage(0);
			} else {
				dismissDialog(0);
			}
		}
	};
}