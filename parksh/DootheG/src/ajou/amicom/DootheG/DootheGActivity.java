package ajou.amicom.DootheG;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class DootheGActivity extends Activity {
	int mCount = 0;
	TextView mTextCount;
	/** Called when the activity is first created. */
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mTextCount=(TextView)findViewById(R.id.count);
		
		}

		public void mOnClick(View v) {
			switch (v.getId()) {
			case R.id.click1:
				mCount++;
	 		mTextCount.setText("" + mCount);
				break;
			case R.id.click2:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click3:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click4:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click5:
				mCount++;
			mTextCount.setText("" + mCount);
			break;
			case R.id.click6:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click7:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click8:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click9:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click10:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click11:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click12:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click13:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click14:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click15:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click16:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click17:
				mCount--;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click18:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click19:
				mCount++;
				mTextCount.setText("" + mCount);
				break;
			case R.id.click20:
				mCount--;
				mTextCount.setText("" + mCount);
		break;
		
		
			}
		

	
	
	}
}