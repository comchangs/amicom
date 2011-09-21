package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_ProgressTitle2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.c10_progresstitle2);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			setProgressBarIndeterminateVisibility(true);
			break;
		case R.id.stop:
			setProgressBarIndeterminateVisibility(false);
			break;
		}
	}
}