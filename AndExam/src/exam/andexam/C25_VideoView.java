package exam.andexam;

import android.app.*;
import android.os.*;
import android.widget.*;

public class C25_VideoView extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c25_videoview);
		
		VideoView video = (VideoView)findViewById(R.id.videoview);
		String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
		video.setVideoPath(sd + "/testvideo.mp4");
		
		final MediaController mc = new MediaController(C25_VideoView.this);
		video.setMediaController(mc);
		video.postDelayed(new Runnable() {
			public void run() {
				mc.show(0);
			}
		},100);
		//video.start();
	}
}

