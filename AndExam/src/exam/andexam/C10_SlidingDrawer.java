package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_SlidingDrawer extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_slidingdrawer);
	}

	public void mOnClick(View v) {
		SlidingDrawer drawer = (SlidingDrawer)findViewById(R.id.drawer);
		drawer.animateClose();
	}	
}
