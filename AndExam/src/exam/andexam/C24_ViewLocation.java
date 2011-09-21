package exam.andexam;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C24_ViewLocation extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c24_viewlocation);
		
		Button btn = (Button)findViewById(R.id.view63);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				double latitude = 37.519576;
				double longitude = 126.940245;
				
				String pos = String.format("geo:%f,%f?z=16", latitude, longitude);
				Uri uri = Uri.parse(pos);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
	}
}
