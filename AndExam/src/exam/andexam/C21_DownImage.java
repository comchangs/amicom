package exam.andexam;

import java.io.*;
import java.net.*;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C21_DownImage extends Activity {
	ImageView img;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_downimage);

		img = (ImageView)findViewById(R.id.result);
	}
	
	public void mOnClick(View v) {
		String imageurl;
		switch (v.getId()) {
		case R.id.btndraw:
			imageurl = "http://www.winapi.co.kr/data/child2.jpg";
			try {
				InputStream is = new URL(imageurl).openStream();
				Bitmap bit = BitmapFactory.decodeStream(is);
				if (bit == null) {
					Toast.makeText(this, "bitmap is null", 0).show();
				} else {
					img.setImageBitmap(bit);
				}
				is.close();
			} catch (Exception e) {
				Toast.makeText(this, "Error : " + e.getMessage(), 0).show();
			}
			break;
		case R.id.btndown:
			imageurl = "http://www.winapi.co.kr/data/child3.jpg";
			int idx = imageurl.lastIndexOf('/');
			String localimage = imageurl.substring(idx + 1);
			String path = Environment.getDataDirectory().getAbsolutePath();
			path += "/data/exam.andexam/files/" + localimage;

			if (new File(path).exists() == false) {
				DownloadImage(imageurl, localimage);
			}

			Bitmap bitmap = BitmapFactory.decodeFile(path);
			img.setImageBitmap(bitmap);
			break;
		}
	}
	
	boolean DownloadImage(String Url, String FileName) {
		URL imageurl;
		int Read;
		try {
			imageurl = new URL(Url);
			HttpURLConnection conn= (HttpURLConnection)imageurl.openConnection();
			int len = conn.getContentLength();
			byte[] raster = new byte[len];
			InputStream is = conn.getInputStream();
			FileOutputStream fos = openFileOutput(FileName, 0);

			for (;;) {
				Read = is.read(raster);
				if (Read <= 0) {
					break;
				}
				fos.write(raster,0, Read);
			}

			is.close();
			fos.close();
			conn.disconnect();
		} catch (Exception e) {
			Toast.makeText(this, "Error : " + e.getMessage(), 
					0).show();
			return false;
		}
		return true;
	}
}

