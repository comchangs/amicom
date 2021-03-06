package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class C17_Translate2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			Paint Pnt = new Paint();
			Pnt.setAntiAlias(true);

			Pnt.setColor(Color.WHITE);
			String[] arStr = { "One", "Two", "Three", "Four", "Five", "Six" };

			for (String s : arStr) {
				canvas.drawText(s, 10, 20, Pnt);
				canvas.translate(0,30);
			}
		}
	}
}