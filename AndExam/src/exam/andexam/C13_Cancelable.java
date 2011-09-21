package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_Cancelable extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_dialog);
	}
	
	public void mOnClick(View v) {
		new AlertDialog.Builder(C13_Cancelable.this)
		.setTitle("공지 사항")
		.setMessage("이 메시지는 반드시 읽어야 합니다.")
		.setIcon(R.drawable.icon)
		.setCancelable(false)
		.setNegativeButton("닫기", null)
		.show();
	}
}