package ajou.amicom.Psh;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class TelStatePshActivity extends Activity {
	TelephonyManager mTelMan;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mTelMan = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		mTelMan.listen(mListener, PhoneStateListener.LISTEN_CALL_STATE);
	}

	public void onDestroy() {
		super.onDestroy();
		mTelMan.listen(mListener, PhoneStateListener.LISTEN_NONE);
	}

	void RefreshState() {
		Intent intent1 = new Intent(this, TelStatePsh1.class);
		Intent intent2 = new Intent(this, TelStatePsh2.class);
		Intent intent3 = new Intent(this, TelState3.class);
		
		String callState = "";
		switch (mTelMan.getCallState()) {
		case TelephonyManager.CALL_STATE_IDLE:
			startActivity(intent1);
			break;
		case TelephonyManager.CALL_STATE_RINGING:
			startActivity(intent2);
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			startActivity(intent3);
			break;
		}

		String state = String.format("통화상태:%s\n전화번호:%s\n장치ID:%s\n" +
				"네트워크 유형:%d\n전화 유형:%d\n국가:%s\n사업자:%s\n" +
				"서비스 제공자:%s\nSIM:%s\n가입자:%s\n로밍:%s", 
				callState, mTelMan.getLine1Number(), mTelMan.getDeviceId(),
				mTelMan.getNetworkType(), mTelMan.getPhoneType(), 
				mTelMan.getNetworkCountryIso(), 
				mTelMan.getNetworkOperatorName(), mTelMan.getSimOperatorName(), 
				mTelMan.getSimSerialNumber(), mTelMan.getSubscriberId (),
				mTelMan.isNetworkRoaming() ? "yes":"no");

		TextView result = (TextView)findViewById(R.id.result);
		result.setText(state);
	}

	PhoneStateListener mListener = new PhoneStateListener() {
		public void onCallStateChanged (int state, String incomingNumber) {
			if (state == TelephonyManager.CALL_STATE_RINGING) {
				Toast.makeText(TelStatePshActivity.this, "전화 : " + 
						incomingNumber, 0).show();
			}
			RefreshState();
		}
	};
}