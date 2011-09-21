package exam.andexam;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class C15_NoTitle extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Window win = getWindow();
		win.requestFeature(Window.FEATURE_NO_TITLE);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.c15_notitle);
	}
}
