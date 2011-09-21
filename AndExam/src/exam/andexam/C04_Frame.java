package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C04_Frame extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c04_frame);

		Button btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ImageView img=(ImageView)findViewById(R.id.img);
				if (img.getVisibility() == View.VISIBLE) {
					img.setVisibility(View.INVISIBLE);
				} else {
					img.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}