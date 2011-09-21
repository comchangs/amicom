package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_Dialog extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_dialog);
	}

	public void mOnClick(View v) {
		Dialog dlg = new Dialog(C13_Dialog.this);
		TextView text = new TextView(C13_Dialog.this);
		text.setText("대화상자를 열었습니다.");
		dlg.setContentView(text);
		dlg.setTitle("알립니다.");
		dlg.show();
	}
}