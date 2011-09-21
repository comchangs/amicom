package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C15_CustomTitle extends Activity {
	TextView mCaption;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Window win = getWindow();
		win.requestFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.c15_customtitle);
		win.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.c15_customtitle_title);
		mCaption = (TextView)findViewById(R.id.rightcaption);
	
		findViewById(R.id.btnchange).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mCaption.setText("새로운 캡션");
			}
		});	
	}
}
