package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C05_Toast extends Activity {
    Toast mToast = null;
    int count;
    String str;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c05_toast);
		
		findViewById(R.id.shortmsg).setOnClickListener(mClickListener);
		findViewById(R.id.longmsg).setOnClickListener(mClickListener);
		findViewById(R.id.count1).setOnClickListener(mClickListener);
		findViewById(R.id.count2).setOnClickListener(mClickListener);
		findViewById(R.id.customview).setOnClickListener(mClickListener);
	}

	Button.OnClickListener mClickListener = new Button.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.shortmsg:
				Toast.makeText(C05_Toast.this, "잠시 나타나는 메시지", 
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.longmsg:
				Toast.makeText(C05_Toast.this, "조금 길게 나타나는 메시지", 
						Toast.LENGTH_LONG).show();
				break;
			case R.id.count1:
				str = "현재 카운트 = " + count++;
				if (mToast != null) {
					mToast.cancel();
				}
				mToast = Toast.makeText(C05_Toast.this, str, Toast.LENGTH_SHORT);
				mToast.show();
				break;
			case R.id.count2:
				str = "현재 카운트 = " + count++;
				if (mToast == null) { 
					mToast = Toast.makeText(C05_Toast.this, str, Toast.LENGTH_SHORT);
				} else {
					mToast.setText(str);
				}
				mToast.show();
				break;
			case R.id.customview:
		        LinearLayout linear = (LinearLayout)View.inflate(C05_Toast.this, 
		        		R.layout.c05_toastview, null);
		        Toast t2 = new Toast(C05_Toast.this);
		        t2.setView(linear);
		        t2.show();
		        break;
			}
		}
	};
}
