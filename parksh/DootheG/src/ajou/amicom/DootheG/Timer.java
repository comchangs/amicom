package ajou.amicom.DootheG;





import android.app.*;
import android.os.*;
import android.widget.*;

public class Timer extends Activity{
	int value=0;
	TextView mText;

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mText=(TextView)findViewById(R.id.timer);
		mhandler.sendEmptyMessage(0);
	}
		Handler mhandler = new Handler() {
		 public void handleMessage(Message msg){
			 value++;
			 mText.setText("TIME = " + value);
			 mhandler.sendEmptyMessageDelayed(0,1000);
		 } 
		};
	
		
	
	}
