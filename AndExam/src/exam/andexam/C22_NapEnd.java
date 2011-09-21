package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_NapEnd extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c22_napend);

		NotificationManager NM = (NotificationManager) 
			getSystemService(NOTIFICATION_SERVICE);
		NM.cancel(C22_NapAlarm.NAPNOTI);

		Button btn = (Button)findViewById(R.id.end);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});        
	}
}
