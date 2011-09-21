package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C16_BackWork extends Activity {
	TextView mResult;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.c16_backwork);

		mResult = (TextView)findViewById(R.id.result);
	}
	
	public void mOnClick(View v) {
		int start = 0, end = 100;
		int result;
		setProgressBarIndeterminateVisibility(true);
		result = Accumulate(start, end);
		mResult.setText("" + result);
		setProgressBarIndeterminateVisibility(false);
	}
	
	int Accumulate(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
			try { Thread.sleep(20); } catch (InterruptedException e) {;}
		}
		return sum;
	}
}


