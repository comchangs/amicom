package exam.andexam;

import android.app.*;
import android.content.*;
import android.media.*;
import android.os.*;
import android.telephony.*;
import android.view.*;
import android.widget.*;

public class C27_YieldCall2 extends Activity {
	TelephonyManager mTelMan;
	int mProgress;
	TextView mtxtProgress;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c27_yieldcall2);

		mtxtProgress = (TextView)findViewById(R.id.playstatus);
		mTelMan = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		mTelMan.listen(mCallListener, PhoneStateListener.LISTEN_CALL_STATE);

		// 불필요함.
		// mHandler.sendEmptyMessageDelayed(0,1000);
	}

	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			mProgress++;
			mtxtProgress.setText("게임 진행중 = " + mProgress);
			mHandler.sendEmptyMessageDelayed(0,1000);
		}
	};

	PhoneStateListener mCallListener = new PhoneStateListener() {
		public void onCallStateChanged (int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				mHandler.sendEmptyMessageDelayed(0,1000);
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				mHandler.removeMessages(0);
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				break;
			}
		}
	};

	public void onDestroy() {
		super.onDestroy();
		mTelMan.listen(mCallListener, PhoneStateListener.LISTEN_NONE);
	}
}

