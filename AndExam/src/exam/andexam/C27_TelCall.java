package exam.andexam;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C27_TelCall extends Activity {
	EditText mNumber;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c27_telcall);

		mNumber = (EditText)findViewById(R.id.number);
	}
	
	public void mOnClick(View v) {
		Uri number;
		Intent intent;
		switch (v.getId()) {
		case R.id.calldialer:
			number = Uri.parse("tel:" + mNumber.getText());
			intent = new Intent(Intent.ACTION_DIAL, number);
			startActivity(intent);
			break;
		case R.id.calldirect:
			number = Uri.parse("tel:" + mNumber.getText());
			intent = new Intent(Intent.ACTION_CALL, number);
			startActivity(intent);
			break;
		}
	}	
}