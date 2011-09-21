package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_AlertDialog extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_dialog);
	}

	public void mOnClick(View v) {
		/* 빌더 생성 후 속성 설정
		AlertDialog.Builder bld = new AlertDialog.Builder(C13_AlertDialog.this);
		bld.setTitle("알립니다.");
		bld.setMessage("대화상자를 열었습니다.");
		bld.setIcon(R.drawable.icon);
		bld.show();
		//*/

		//* 연쇄적인 호출
		new AlertDialog.Builder(C13_AlertDialog.this)
		.setTitle("알립니다.")
		.setMessage("대화상자를 열었습니다.")
		.setIcon(R.drawable.icon)
		.show();
		//*/
	}
}