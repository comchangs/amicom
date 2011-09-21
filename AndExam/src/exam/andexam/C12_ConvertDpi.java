package exam.andexam;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;

public class C12_ConvertDpi extends Activity {
	EditText mEditL, mEditM, mEditH;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c12_convertdpi);

		mEditL = (EditText)findViewById(R.id.ldpivalue);
		mEditL.addTextChangedListener(mWatcherL);
		mEditM = (EditText)findViewById(R.id.mdpivalue);
		mEditM.addTextChangedListener(mWatcherM);
		mEditH = (EditText)findViewById(R.id.hdpivalue);
		mEditH.addTextChangedListener(mWatcherH);
	}

	TextWatcher mWatcherL = new TextWatcher() {
		public void afterTextChanged(Editable s) {}
		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// 무한 루프 방지를 위해 포커스를 점검한다. 다른 에디트 변경에 의해 변경될 때는 다른 에디트를
			// 건드리지 말아야 한다.
			if (mEditL.hasFocus() && s.length() != 0) {
				int value;
				try {
					value = Integer.parseInt(s.toString());
				}
				catch (NumberFormatException e) {
					value = 0;
				}
				mEditM.setText(Integer.toString((int)(value * 1.3333f + 0.5f)));
				mEditH.setText(Integer.toString((int)(value * 2f)));
			}
		}
	};

	TextWatcher mWatcherM = new TextWatcher() {
		public void afterTextChanged(Editable s) {}
		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			if (mEditM.hasFocus() && s.length() != 0) {
				int value;
				try {
					value = Integer.parseInt(s.toString());
				}
				catch (NumberFormatException e) {
					value = 0;
				}
				mEditL.setText(Integer.toString((int)(value * 0.75f + 0.5f)));
				mEditH.setText(Integer.toString((int)(value * 1.5f + 0.5f)));
			}
		}
	};

	TextWatcher mWatcherH = new TextWatcher() {
		public void afterTextChanged(Editable s) {}
		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			if (mEditH.hasFocus() && s.length() != 0) {
				int value;
				try {
					value = Integer.parseInt(s.toString());
				}
				catch (NumberFormatException e) {
					value = 0;
				}
				mEditL.setText(Integer.toString((int)(value * 0.5f + 0.5f)));
				mEditM.setText(Integer.toString((int)(value * 0.6666f + 0.5f)));
			}
		}
	};
}
