package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class C05_CustomFont extends Activity {
	Typeface mFont;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vw = new MyView(this);
		setContentView(vw);
		
		mFont = Typeface.createFromAsset(getAssets(), 
				"balloons.ttf");
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			Paint Pnt = new Paint();
			String str = "Custom Font Test";
			
			Pnt.setAntiAlias(true);
			Pnt.setTypeface(mFont);
			Pnt.setTextSize(30);
			canvas.drawText(str, 10, 40, Pnt);
		}
	}
}
