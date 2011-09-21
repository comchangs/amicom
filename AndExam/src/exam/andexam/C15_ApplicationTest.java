package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C15_ApplicationTest extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c15_applicationtest);

		UpdateNowMode();
	}

	void UpdateNowMode() {
		TextView txtMode = (TextView)findViewById(R.id.mode);
		C15_Application app = (C15_Application)getApplication();
		if (app.getMode() == C15_Application.BEGINNER) {
			txtMode.setText("현재 모드 : 초보자 모드");
		} else {
			txtMode.setText("현재 모드 : 숙련자 모드");
		}
	}

	public void mOnClick(View v) {
		C15_Application app = (C15_Application)getApplication();
		switch (v.getId()) {
		case R.id.beginner:
			app.setMode(C15_Application.BEGINNER);
			break;
		case R.id.professional:
			app.setMode(C15_Application.PREFESSIONAL);
			break;
		}
		UpdateNowMode();
	}
}


