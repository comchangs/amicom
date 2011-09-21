package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C08_ImageButton extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c08_imagebutton);

		ImageButton imgbtn = (ImageButton)findViewById(R.id.imagebtn);
		imgbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(C08_ImageButton.this, "Image Button Clicked", 
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}