package exam.andexam;

import android.app.*;
import android.content.*;
import android.location.*;
import android.os.*;

public class C24_LocationAlert extends Activity {
	LocationManager mLocMan;
	PendingIntent mPending;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c24_locationalert);

		mLocMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Intent intent = new Intent(this, C24_FishingReceiver.class);
		mPending = PendingIntent.getBroadcast(this, 0, intent, 0);
	}

	public void onResume() {
		super.onResume();
		mLocMan.addProximityAlert(37.94, 127.81, 500, -1, mPending);
	}	

	public void onPause() {
		super.onPause();
		mLocMan.removeProximityAlert(mPending);
	}
}

