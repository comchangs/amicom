package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C12_MultiLang extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c12_multilang);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnpress:
			Toast.makeText(this, R.string.multi_toasttext, 0).show();
			break;
		case R.id.btnsmile:
			String text = getResources().getString(R.string.multi_smiletext);
			new AlertDialog.Builder(this)
			.setMessage(text)
			.setTitle("Alert")
			.show();
			break;
		}
	}
}
