package exam.andexam;

import android.content.*;
import android.widget.*;

public class C22_AlarmReceiver extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "It's time to start", 
				Toast.LENGTH_LONG).show();
	}
}