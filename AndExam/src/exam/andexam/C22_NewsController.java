package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_NewsController extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c22_newscontroller);
	}
	
	public void mOnClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.newsstart:
			intent = new Intent(this, C22_NewsService.class);
			startService(intent);
			break;
		case R.id.newsend:
			intent = new Intent(this, C22_NewsService.class);
			stopService(intent);
			break;
		}
	}	
}