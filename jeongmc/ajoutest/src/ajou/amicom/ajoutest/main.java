package ajou.amicom.ajoutest;

import java.io.*;
import java.net.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.*;
import android.widget.*;

public class main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		HttpPostData();
	}

	public void HttpPostData() {
		try {
			// --------------------------
			// URL 설정하고 접속하기
			// --------------------------
			URL url = new URL(
					"http://haksa.ajou.ac.kr/uni/uni/cour/tlsn/findCourPersonalTakingLessonAply.action"); // URL
																											// 설정
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
			Log.i("AjouTest", "접속");
			// --------------------------
			// 전송 모드 설정 - 기본적인 설정이다
			// --------------------------
			http.setDefaultUseCaches(false);
			http.setDoInput(true); // 서버에서 읽기 모드 지정
			http.setDoOutput(true); // 서버로 쓰기 모드 지정
			http.setRequestMethod("POST"); // 전송 방식은 POST

			// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
			http.setRequestProperty("Accept", "*/*");
			http.setRequestProperty("Accept-Language", "ko-KR");
			http.setRequestProperty("Referer",
					"http://haksa.ajou.ac.kr/aimsDdx1.5.2.swf");
			http.setRequestProperty("x-flash-version", "10,3,181,26");
			http.setRequestProperty("content-type", "text/xml;charset=utf-8");
			http.setRequestProperty("Accept-Encoding", "gzip, deflate");
			http.setRequestProperty("User-Agent",
					"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; MASN)");
			http.setRequestProperty("Host", "haksa.ajou.ac.kr");
			//http.setRequestProperty("Pragma", "no-cache");
			// http.setRequestProperty("Cookie",
			// "PHAROS_VISITOR=000000000131c7d833155e68ca1e000f; JSESSIONID=xjJsZSjAbTs3qAl0bLmxjMlYukPiCyex3OFGW1vr0CpbcOMTHWNbftYw91Vm0P7C.hakdang_servlet_engine2; ssotoken=zLabtQxo4DivPTbUTfuJ%2F2P7Nzqm5fYw1abwwbgkQpI0VVVj3IbLeTJmJTj83gTrugceRNoBLie0izSmOBgQ9LGgGWgUX%2FyVv1VnuHTkNwUkp1g5e0u9HZvcviD5BnsmByjKUNB79stTXMYvTEQbKg%3D%3D; SSOGlobalLogouturl=get^http://portal.ajou.ac.kr/com/sso/logout.jsp$; PDNM=%C1%A4%B9%AE%C3%A2; PDGR=%C7%D0%BA%CE%BB%FD; PDTEL=0635333519; PDDEC=DS03001003001; PDDE=%BB%EA%BE%F7%C1%A4%BA%B8%BD%C3%BD%BA%C5%DB%B0%F8%C7%D0%C0%FC%B0%F8; PDCN=200621756; PDID=%C1%A4%B9%AE%C3%A2; PDFAX=01071313519; PDSCHOOLREG=%C0%E7%C7%D0; PDREAD=1; PDLEND=1; PDEM=comchangs%40ajou%2Eac%2Ekr; PDGRC=13; PHAROS_VISITOR=000000000131c7c0951958bdca1e000f; JSESSIONID=gHFb1Zg8Kj77onlny2dqJHDnkwkwyv453rg2KijoOYY2gQIAHRp5isDR11zjHQRp.hakdang_servlet_engine1");
			// http.setRequestProperty("Content-Length", "270");
			Log.i("AjouTest", "헤더생성");
			// --------------------------
			// 서버로 값 전송
			// --------------------------
			

			StringBuffer buffer = new StringBuffer();

			String stdnum = "200621756"; // 학번
			String parameter = null;
			parameter = new String(
					"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
							+ "<root>\n<params>\n"
							+ "<param id=\"strYy\" type=\"STRING\">2011</param>\n"
							+ "<param id=\"strShtmCd\" type=\"STRING\">U0002001</param>\n"
							+ "<param id=\"strStdNo\" type=\"STRING\">"
							+ stdnum
							+ "</param>\n"
							+ "<param id=\"admin\" type=\"STRING\">admin</param>\n"
							+ "</params>\n" + "</root>");

			buffer.append(parameter);

			OutputStreamWriter outStream = new OutputStreamWriter(
					http.getOutputStream(), "UTF-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();
			Log.i("AjouTest", "바디생성");
			// --------------------------
			// 서버에서 전송받기
			// --------------------------

			InputStreamReader tmp = new InputStreamReader(
					http.getInputStream(), "UTF-8");
			Log.i("AjouTest", "1");
			BufferedReader reader = new BufferedReader(tmp);
			Log.i("AjouTest", "2");
			StringBuilder builder = new StringBuilder();
			Log.i("AjouTest", "3");
			String str;
			Log.i("AjouTest", "4");
			while ((str = reader.readLine()) != null) { // 서버에서 라인단위로 보내줄 것이므로
														// 라인단위로 읽는다
				
				builder.append(str + "\n"); // View에 표시하기 위해 라인 구분자 추가 }
			}
			Log.i("AjouTest", "전송받음");

			String myResult = builder.toString(); // 전송결과를 전역 변수에 저장
			((TextView) (findViewById(R.id.text_result))).setText(myResult);
			Toast.makeText(main.this, "전송 후 결과 받음", 0).show();
		} catch (MalformedURLException e) {
			Toast.makeText(main.this, "MalformedURLException", 0).show();
		} catch (IOException e) {
			Toast.makeText(main.this, "IOException", 0).show();
		}
	} // HttpPostData
}