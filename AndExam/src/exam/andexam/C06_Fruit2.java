package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C06_Fruit2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c06_fruit2);
	}

	public void mOnClick(View v) {
		TextView textFruit=(TextView)findViewById(R.id.fruit);
		switch (v.getId()) {
		case R.id.apple:
			textFruit.setText("Apple");
			break;
		case R.id.orange:
			textFruit.setText("Orange");
			break;
		}
	}
}