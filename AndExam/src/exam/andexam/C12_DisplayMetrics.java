package exam.andexam;

import android.app.*;
import android.os.*;
import android.util.*;
import android.widget.*;

public class C12_DisplayMetrics extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c12_displaymetrics);

		//DisplayMetrics dm = new DisplayMetrics();
		//getWindowManager().getDefaultDisplay().getMetrics(dm);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		String str = "widthPixels=" + dm.widthPixels +
			"\nheightPixels=" + dm.heightPixels +
			"\ndensityDpi=" + dm.densityDpi + 
			"\ndensity=" + dm.density + 
			"\nscaledDensity=" + dm.scaledDensity + 
			"\nxdpi=" + dm.xdpi + 
			"\nydpi=" + dm.ydpi;
		TextView info = (TextView)findViewById(R.id.result);
		info.setText(str);
	}
}