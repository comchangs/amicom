package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_CalcClient extends Activity {
	C22_ICalc mCalc;
	TextView mResult;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c22_calcclient);
		
		mResult = (TextView)findViewById(R.id.result);
	}
	
	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnLCM:
			int LCM = 0;
			try {
				LCM = mCalc.getLCM(6, 8);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			mResult.setText("6과 8의 최소 공배수 = " + LCM);
			break;
		case R.id.btnPrime:
			boolean prime = false;
			try {
				prime = mCalc.isPrime(7);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			mResult.setText("7의 소수 여부 = " + prime);
			break;
		}
	}
	
	public void onResume() {
		super.onResume();
		Intent intent = new Intent(this, C22_CalcService.class);
		bindService(intent, srvConn, BIND_AUTO_CREATE);
	}	

	public void onPause() {
		super.onPause();        
		unbindService(srvConn);
	}

	ServiceConnection srvConn = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder binder) {
			mCalc = C22_ICalc.Stub.asInterface(binder);
		}

		public void onServiceDisconnected(ComponentName className) {
			mCalc = null;
		}
	};
}

