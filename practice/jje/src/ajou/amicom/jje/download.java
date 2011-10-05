package ajou.amicom.jje;

import java.io.*;
import java.net.*;

import android.app.Activity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class download extends Activity {
	boolean bUploading = false;
	/** Called when the activity is first created. */
	String html;
    String html1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.button);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Thread uploadThread = new Thread() {
					public void run() {
						
						html = DownloadHtml("http://dev.jwnc.net"); 
						
						mCompleteHandler.sendEmptyMessage(0);
					}
				};
				Thread uploadThread1 = new Thread() {
					public void run() {
						
						html1 = DownloadHtml("http://dev.naver.com/amicom"); 
						
						mCompleteHandler.sendEmptyMessage(0);
					}
				};
							
				uploadThread.start();
				uploadThread1.start();
				//밑에 두 쓰레드가 시작
			}
		});
	}
    public Handler mCompleteHandler = new Handler() {
		public void handleMessage(Message msg) {
			bUploading = false;			//왜 핸들러를 쓸까 : 안드로이드자체에다가 예약할걸 부탁한다
			//멈추는듯한 모습 안보여줌
			//Toast.makeText(C16_ANR2.this, "업로드를 완료했습니다.", 0).show();
			
			TextView result = (TextView)findViewById(R.id.result);
			result.setText(html);
			TextView result1 = (TextView)findViewById(R.id.result1);
			result1.setText(html1);
						
		}
	};

	
	//* 자바의 네트워크 클래스 사용
	String DownloadHtml(String addr) {
		StringBuilder html = new StringBuilder(); 
		try {
			URL url = new URL(addr);
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
				}
				conn.disconnect();
			}
		} 
		catch (Exception ex) {;}
		return html.toString();
	}
	
	}