package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_DialogButton extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_dialog);
	}
	
	public void mOnClick(View v) {
		//* 빈 리스너 작성
		new AlertDialog.Builder(C13_DialogButton.this)
		.setTitle("알립니다.")
		.setMessage("대화상자를 열었습니다.")
		.setIcon(R.drawable.icon)
		.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		})
		.show();
		//*/

		/* 부정 버튼 배치
		new AlertDialog.Builder(C13_DialogButton.this)
		.setTitle("알립니다.")
		.setMessage("대화상자를 열었습니다.")
		.setIcon(R.drawable.icon)
		.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		})
		.show();
		//*/

		/* null 리스너 작성
		new AlertDialog.Builder(C13_DialogButton.this)
		.setTitle("알립니다.")
		.setMessage("대화상자를 열었습니다.")
		.setIcon(R.drawable.icon)
		.setPositiveButton("닫기", null)
		.show();
		//*/
	}
}