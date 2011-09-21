package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C08_ArrowButton extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c08_arrowbutton);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.arrow1:
			Toast.makeText(this, "Arrow1 clicked", 0).show();
			break;
		case R.id.arrow2:
			Toast.makeText(this, "Arrow2 clicked", 0).show();
			break;
		case R.id.arrow3:
			Toast.makeText(this, "Arrow3 clicked", 0).show();
			break;
		}
	}    
}