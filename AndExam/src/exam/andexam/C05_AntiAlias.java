package exam.andexam;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;

public class C05_AntiAlias extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView vw = new MyView(this);
		setContentView(vw);
	}

	protected class MyView extends View {
		public MyView(Context context) {
			super(context);
		}

		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			Paint Pnt = new Paint();
			Pnt.setColor(Color.BLACK);
			Pnt.setTextSize(30);

			// 기본 출력
			canvas.drawOval(new RectF(10,10,100,60), Pnt);
			canvas.drawText("Text", 110, 40, Pnt);
			
			// 안티 알리아스 적용
			Pnt.setAntiAlias(true);
			canvas.drawOval(new RectF(10,70,100,120), Pnt);
			canvas.drawText("Text", 110, 100, Pnt);
		}
	}
}
