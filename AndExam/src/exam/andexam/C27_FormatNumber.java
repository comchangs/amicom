package exam.andexam;

import android.app.*;
import android.os.*;
import android.telephony.*;
import android.view.*;
import android.widget.*;

public class C27_FormatNumber extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c27_formatnumber);
		
		EditText telNum = (EditText)findViewById(R.id.telNum);
		telNum.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		
		if (PhoneNumberUtils.isEmergencyNumber("911")) {
			Toast.makeText(this, "Emergency", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "No Emergency", Toast.LENGTH_LONG).show();
		}
	}
}
