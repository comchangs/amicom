package ajou.amicom.DootheG;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class DootheGActivity extends Activity {
	int mCount = 0;
	TextView mTextCount;
	int value=0;
	TextView mText;

	/** Called when the activity is first created. */
		public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mTextCount=(TextView)findViewById(R.id.count);

		mText=(TextView)findViewById(R.id.timer);
		mhandler.sendEmptyMessage(0);
		
		}
		
		Handler mhandler = new Handler() {
			 public void handleMessage(Message msg){
				 value++;
				 mText.setText("경과시간 = " + value);
				 mhandler.sendEmptyMessageDelayed(0,1000);
			 } 
			};
		
			/*@Override
			public boolean onTouchEvent(MotionEvent event) {
			int touchX=(int) event.getX();
			int touchY=(int) event.getY();
			int touchAction=event.getAction();
			if (touchAction==MotionEvent.ACTION_DOWN) { 
				 
			}
			return true;
		}*/

		public void mOnClick(View v) {
			switch (v.getId()) {
			case R.id.click1:
				mCount++;
	 		mTextCount.setText("점수 = " + mCount);
	 		
				break;
			case R.id.click2:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click3:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click4:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click5:
				mCount++;
			mTextCount.setText("점수 = " + mCount);
			break;
			case R.id.click6:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click7:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click8:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click9:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click10:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click11:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click12:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click13:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click14:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click15:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click16:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click17:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click18:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click19:
				mCount++;
				mTextCount.setText("점수 = " + mCount);
				break;
			case R.id.click20:
				mCount--;
				mTextCount.setText("점수 = " + mCount);
		break;
		
		
			}
		

	
	
	}
}