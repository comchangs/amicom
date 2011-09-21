package exam.andexam;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C12_Ruler extends Activity {
	Ruler mRuler;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c12_ruler);
		
		mRuler = (Ruler)findViewById(R.id.ruler);
		RadioGroup RadioUnit = (RadioGroup)findViewById(R.id.rulerunit);
		RadioUnit.setOnCheckedChangeListener(mCheckRadio);
	}

	// 단위 변경시 룰러에게 알림
	RadioGroup.OnCheckedChangeListener mCheckRadio = new RadioGroup.OnCheckedChangeListener() {
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.mili:
				mRuler.setMili(true);
				break;
			case R.id.inch:
				mRuler.setMili(false);
				break;
			}
		}
	};
}

class Ruler extends View {
	boolean mMili;
	public Ruler(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public Ruler(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public Ruler(Context context) {
		super(context);
		init();
	}

	void init() {
		mMili = true;
	}
	
	public void setMili(boolean aMili) {
		mMili = aMili;
		invalidate();
	}

	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.LTGRAY);
		Paint Pnt = new Paint();
		Pnt.setColor(Color.BLACK);
		Pnt.setTextAlign(Paint.Align.CENTER);
		
		int unit;
		int x, y;
		Resources res = getResources();
		DisplayMetrics dm = res.getDisplayMetrics();

		// 텍스트는 15dip 크기
		int textsize = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, dm);
		Pnt.setTextSize(textsize);
		
		// 1단위, 5단위, 10단위의 눈금 길이 미리 계산
		int one = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, dm);
		int five = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, dm);
		int ten = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, dm);
		
		// 단위 변환에 사용할 상수 미리 구해 둠
		int unitdim;
		if (mMili) {
			unitdim = TypedValue.COMPLEX_UNIT_MM;
		} else {
			unitdim = TypedValue.COMPLEX_UNIT_IN;
		}

		for (unit = 0;;unit++) {
			Pnt.setAntiAlias(false);
			// 밀리미터는 1단위, 인치는 0.1단위로 눈금 표시
			if (mMili) {
				x = (int)TypedValue.applyDimension(unitdim, unit, dm);
			} else {
				x = (int)TypedValue.applyDimension(unitdim, unit/10.0f, dm);
			}
			// 뷰의 폭을 넘을 때까지 그린다.
			if (x > getWidth()) {
				break;
			}
			// 눈금의 길이 계산
			if (unit % 10 == 0) {
				y = ten;
			} else if (unit % 5 == 0) {
				y = five;
			} else {
				y = one;
			}
			canvas.drawLine(x, 0, x, y, Pnt);

			// 매 10단위마다 텍스트 출력. 안티 알리아싱 적용
			if (unit % 10 == 0) {
				Pnt.setAntiAlias(true);
				String text;
				if (mMili) {
					text = "" + unit;
				} else {
					text = "" + (unit / 10);
				}
				canvas.drawText(text, x, y + textsize, Pnt);
			}
		}
	}
}
