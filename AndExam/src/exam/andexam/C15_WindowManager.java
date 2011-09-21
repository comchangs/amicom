package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C15_WindowManager extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c15_windowmanager);

		WindowManager wm = (WindowManager)getSystemService(
				Context.WINDOW_SERVICE);
		Display dis = wm.getDefaultDisplay();
		TextView result = (TextView)findViewById(R.id.result);
		result.setText("width = " + dis.getWidth() + "\nheight = " + dis.getHeight() +
				"\nrotate = " + dis.getRotation()/*dis.getOrientation()*/);
		
		ImageView img = new ImageView(this);
		img.setImageResource(R.drawable.clover);
		WindowManager.LayoutParams param = new WindowManager.LayoutParams();
		param.gravity=Gravity.LEFT | Gravity.TOP;
		param.x = 20;
		param.y = 5;
		param.width = WindowManager.LayoutParams.WRAP_CONTENT;
		param.height = WindowManager.LayoutParams.WRAP_CONTENT;
		param.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
			WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		param.format = PixelFormat.TRANSLUCENT;

		wm.addView(img, param);
	}
}