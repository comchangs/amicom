package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;

public class C15_Center extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Window win = getWindow();
		win.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, 
				ViewGroup.LayoutParams.WRAP_CONTENT);
		win.setGravity(Gravity.CENTER);

		setContentView(R.layout.c15_center);
	}
}
