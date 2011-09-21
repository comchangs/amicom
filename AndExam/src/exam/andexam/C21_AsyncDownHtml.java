package exam.andexam;

import java.io.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

/* 자바의 네트워크 클래스 사용
public class C21_AsyncDownHtml extends Activity {
	ProgressDialog mProgress;
	DownThread mThread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_downhtml);

		Button btn = (Button)findViewById(R.id.down);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mProgress = ProgressDialog.show(C21_AsyncDownHtml.this, 
						"Wait", "Downloading...");
				mThread = new DownThread("http://www.google.com");
				mThread.start();
			}
		});
	}

	class DownThread extends Thread {
		String mAddr;
		String mResult;

		DownThread(String addr) {
			mAddr = addr;
			mResult = "";
		}

		public void run() {
			StringBuilder html = new StringBuilder(); 
			try {
				URL url = new URL(mAddr);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				if (conn != null) {
					conn.setConnectTimeout(10000);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						BufferedReader br = new BufferedReader(
								new InputStreamReader(conn.getInputStream()));
						for (;;) {
							String line = br.readLine();
							if (line == null) break;
							html.append(line + '\n'); 
						}
						br.close();
						mResult = html.toString();
					}
					conn.disconnect();
				}
			} 
			catch (Exception ex) {;}
			mAfterDown.sendEmptyMessage(0);
		}
	}

	Handler mAfterDown = new Handler() {
		public void handleMessage(Message msg) {
			mProgress.dismiss();
			TextView result = (TextView)findViewById(R.id.result);
			result.setText(mThread.mResult);
		}
	};
}
//*/

//* 아파치 클래스 사용
public class C21_AsyncDownHtml extends Activity {
	ProgressDialog mProgress;
	DownThread mThread;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_downhtml);

		Button btn = (Button)findViewById(R.id.down);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				mProgress = ProgressDialog.show(C21_AsyncDownHtml.this, 
						"Wait", "Downloading...");
				mThread = new DownThread("http://www.google.com");
				mThread.start();
			}
		});
	}

	class DownThread extends Thread {
		String mAddr;

		DownThread(String addr) {
			mAddr = addr;
		}

		public void run() {
			HttpGet get = new HttpGet(mAddr);
			DefaultHttpClient client = new DefaultHttpClient();
			try {
				client.execute(get,mResHandler);
			} 
			catch (Exception e) {;}
		}
	}

	ResponseHandler<String> mResHandler = new ResponseHandler<String>() {
		public String handleResponse(HttpResponse response) {
			StringBuilder html = new StringBuilder(); 
			try {
				BufferedReader br = new BufferedReader(new 
						InputStreamReader(response.getEntity().getContent()));
				for (;;) {
					String line = br.readLine();
					if (line == null) break;
					html.append(line + '\n'); 
				}
				br.close();

				Message message = mAfterDown.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("result", html.toString());
				message.setData(bundle);
				mAfterDown.sendMessage(message);
			} catch (Exception e) {;}
			return html.toString();
		}
	};

	Handler mAfterDown = new Handler() {
		public void handleMessage(Message msg) {
			mProgress.dismiss();
            String sresult = msg.getData().getString("result");
			TextView result = (TextView)findViewById(R.id.result);
			result.setText(sresult);
		}
	};
}
//*/

