package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C13_SelectDialog1 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c13_dialog);
	}
	
	public void mOnClick(View v) {
		new AlertDialog.Builder(this)
		.setTitle("음식을 선택하시오.")
		.setIcon(R.drawable.icon)
		.setItems(R.array.foods, 
		// .setItems(new String[] {"짜장면", "우동", "짬뽕", "탕수육" }, 
			new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				String[] foods = getResources().getStringArray(R.array.foods);
				TextView text = (TextView)findViewById(R.id.text);
				text.setText("선택한 음식 = " + foods[which]);
			}
		})
		.setNegativeButton("취소", null)
		.show();
	}
}
