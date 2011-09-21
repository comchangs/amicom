package ajou.amicom.jmc.alarmclock;

import android.app.*;
import android.content.Context;
import android.os.*;

public class Dididi extends Activity{

	 
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	 setContentView(R.layout.dididi);
	  Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	  vibe.vibrate(500);   

	 }

}
