package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_ScrollView extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_scrollview);

		ScrollView svw = (ScrollView)findViewById(R.id.scr);
		//svw.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
		//svw.setVerticalFadingEdgeEnabled(false);
		//svw.setVerticalScrollBarEnabled(false);
		svw.addView(new ColorView(this));
	}
}

class ColorView extends View {
	public ColorView(Context context) {
		super(context);
	}

	public void onDraw(Canvas canvas) {
		Paint Pnt = new Paint();
		for (int y = 0;y < 1280;y += 5) {
			Pnt.setARGB(255, 255 - y / 5, 255 - y / 5, 255);
			canvas.drawRect(0, y, 1280, y + 5, Pnt);
		}
	}

	protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(1280, 1280);
	}
}
