package ajou.amicom.Teltel;

import ajou.amicom.Teltel.R;
import android.app.*;
import android.content.*;
import android.os.*;
import android.telephony.*;
import android.widget.*;

public class TeltelActivity extends Activity {
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
		String callState = "";
		switch (mTelMan.getCallState()) {
		case TelephonyManager.CALL_STATE_IDLE:
			callState = "�����";
			
			
			break;
		case TelephonyManager.CALL_STATE_RINGING:
			callState = "��ȭ ������";
			
			if (callState == "��ȭ ������"){
				Intent intent = new Intent(TeltelActivity.this, YY.class);         
				startActivity(intent); 	  }  
		
	
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			callState = "��ȭ��";
			break;
		}

		String state = String.format("��ȭ����:%s\n��ȭ��ȣ:%s\n��ġID:%s\n" +
				"��Ʈ��ũ ����:%d\n��ȭ ����:%d\n����:%s\n�����:%s\n" +
				"���� ������:%s\nSIM:%s\n������:%s\n�ι�:%s", 
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
				Toast.makeText(TeltelActivity.this, "��ȭ : " + 
						incomingNumber, 0).show();
			}
			RefreshState();
		}
	};
}