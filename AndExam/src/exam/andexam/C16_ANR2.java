package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C16_ANR2 extends Activity {
	boolean bUploading = false;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c16_upload);
	}
	
	public void mOnClick(View v) {
		if (bUploading) return;
		Thread uploadThread = new Thread() {
			public void run() {
				doUpload();
				mCompleteHandler.sendEmptyMessage(0);
			}
		};
		bUploading = true;
		uploadThread.start();
	}

	public Handler mCompleteHandler = new Handler() {
		public void handleMessage(Message msg) {
			bUploading = false;
			Toast.makeText(C16_ANR2.this, "업로드를 완료했습니다.", 0).show();
		}
	};
	
	void doUpload() {
		for (int i = 0; i < 100; i++) {
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
	}
}