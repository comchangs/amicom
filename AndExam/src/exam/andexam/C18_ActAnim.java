package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;

public class C18_ActAnim extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c18_actanim);

		overridePendingTransition(0, 0);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnquit:
			finish();
			overridePendingTransition(0, R.anim.exitanim);
			break;
		}
	}
}

