package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C16_Upload extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c16_upload);
	}

	public void mOnClick(View v) {
		new AlertDialog.Builder(this)
		.setTitle("질문")
		.setMessage("업로드 하시겠습니까?")
		.setPositiveButton("예", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				doUpload();
			}
		})
		.setNegativeButton("아니오", null)
		.show();
	}

	void doUpload() {
		for (int i = 0; i < 20; i++) {
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
		Toast.makeText(this, "업로드를 완료했습니다.", 0).show();
	}
}
