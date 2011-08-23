package amicom.test;


import android.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;



import android.app.Activity;
import android.content.*;

import java.util.ArrayList;
import java.io.*;
import java.net.*;

import javax.xml.parsers.*;

import net.htmlparser.jericho.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import android.util.*;
import android.widget.*;

public class xmlTest extends Activity {
	/** Called when the activity is first created. */
	public static String cnt = "";
	String []items = null;
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		HttpPostData();		//cnt값 설정함
		
		 String yourUrl = "http://library.ajou.ac.kr/cache/book_search_ok1.asp?subs=1&"+cnt+"&searchct=&navi=&text1=사람&text2=&text3=&text4=&subject2=&cbo_p=&views=자료명%20=%20사람";
		 
        
	   String content = getHtmltoText(yourUrl);
	     items = content.split("단위");		// 배열에 검색 결과 목록 나눠 저장
	     Log.i("AjouTest", "items");

	     
	        ArrayList<String> booklist = new ArrayList<String>();
	        booklist.add(items[0]);
	        booklist.add(items[1]);
	        booklist.add(items[2]);
	        booklist.add(items[3]);
	        booklist.add(items[4]);
	        booklist.add(items[5]);
	        booklist.add(items[6]);
	        booklist.add(items[7]);
	        booklist.add(items[8]);
	        booklist.add(items[9]);
	        booklist.add(items[10]);
	        booklist.add(items[11]);
	        booklist.add(items[12]);
	        booklist.add(items[13]);
	        booklist.add(items[14]);
	       
	      
	        ArrayAdapter<String> Adapter;
	        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, booklist);
	        
	
	        ListView list = (ListView)findViewById(R.id.list);
	        list.setAdapter(Adapter);        	//연결해 출력
	    }

		
		
	public void HttpPostData() {
		try {

			URL url1 = new URL(
			"http://library.ajou.ac.kr/cache/book_search_ok.asp?subs=1"); // URL
																									// 설정
	HttpURLConnection http1 = (HttpURLConnection) url1.openConnection(); // 접속
	Log.i("AjouTest", "접속");
	// --------------------------
	// 전송 모드 설정 - 기본적인 설정이다
	// --------------------------
	http1.setDefaultUseCaches(false);
	http1.setDoInput(true); // 서버에서 읽기 모드 지정
	http1.setDoOutput(true); // 서버로 쓰기 모드 지정
	http1.setRequestMethod("POST"); // 전송 방식은 POST

	// 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
	http1.setRequestProperty("Accept", "Accept: image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap, application/x-shockwave-flash, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
	http1.setRequestProperty("Accept-Language", "ko-KR");
	http1.setRequestProperty("Referer",
			"http://library.ajou.ac.kr/cache/book_search.asp?subs=1");
	
	http1.setRequestProperty("content-type", "application/x-www-form-urlencoded");
	
	http1.setRequestProperty("User-Agent",
			"Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; MASM; InfoPath.2; .NET4.0C; Media Center PC 6.0)");
	http1.setRequestProperty("Host", "library.ajou.ac.kr");
	//http.setRequestProperty("Pragma", "no-cache");
	 http1.setRequestProperty("Cookie",
	 "ASPSESSIONIDAASRQCTS=DPIILJBBGKIJHANAJPLNBHOI; countkok=%A4%BF%A4%C0%A4%A1%A4%C0%A4%BF");
	// http.setRequestProperty("Content-Length", "270");
	Log.i("AjouTest", "헤더생성");
	// --------------------------
	// 서버로 값 전송
	// --------------------------
	

	StringBuffer buffer = new StringBuffer();

	
	String parameter = null;
	parameter = new String(
			"form_name=search.text1&form_name2=search.subject&is_opened=false&is_opened2=false&opt=0&navi=&smethod=on&chk=A&cbo_k1=dat08&text1=%BB%E7%B6%F7&year1=&year2=&image.x=34&image.y=8");

	buffer.append(parameter);

	OutputStreamWriter outStream = new OutputStreamWriter(
			http1.getOutputStream(), "UTF-8");
	PrintWriter writer = new PrintWriter(outStream);
	writer.write(buffer.toString());
	writer.flush();
	Log.i("AjouTest", "바디생성");
	// --------------------------
	// 서버에서 전송받기
	// --------------------------

	InputStreamReader tmp = new InputStreamReader(
			http1.getInputStream(), "UTF-8");
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
	Log.i("AjouTest", "222");
	Toast.makeText(xmlTest.this, "전송 후 결과 받음", 0).show();

			
			
			
		int a = myResult.indexOf("cnt");
		Log.i("AjouTest", Integer.toString(a));

		int b = myResult.indexOf("&amp;searchct");
		Log.i("AjouTest", Integer.toString(b));
	
		cnt = myResult.substring(a,b);
		Log.i("AjouTest", "이거야"+cnt);
	
		} catch (MalformedURLException e) {
			Toast.makeText(xmlTest.this, "MalformedURLException", 0).show();
		} catch (IOException e) {
			Toast.makeText(xmlTest.this, "IOException", 0).show();
		}
	} // HttpPostData

public String getHtmltoText(String sourceUrlString) {
 Source source = null;
 String content = null;

 try {

	 URL sUrl= new URL(sourceUrlString);
	   	 InputStream is = sUrl.openStream(); 
	 source=new Source(new InputStreamReader(is,"euc-kr"));

	 source.fullSequentialParse();
	 
  content = source.getTextExtractor().toString();
 
  int a = content.indexOf("건 출력");
  content = content.substring(a);
	
	content = content.replaceAll("대출가능","대출가능 단위" );
	content = content.replaceAll("대출불가능","대출불가능 단위" );
	content = content.replaceAll("건 출력","" );
	content = content.replaceAll("중앙도서관","" );
	

} catch (Exception e) {
e.printStackTrace();
}

return content;

  }
 


protected void onListItemClick(ListView l, View v, int position, long id) {
	
	switch (position) {
	case 0: {
		Intent intent = new Intent(xmlTest.this, list0.class);
		startActivity(intent);
		break;
	}
	
	case 1: {
		Intent intent = new Intent(xmlTest.this, list1.class);
		startActivity(intent);
		break;
    	}
      
	
	
	case 2: {
		Intent intent = new Intent(xmlTest.this, list2.class);
		startActivity(intent);
		break;
	}
    
	case 3: {
		Intent intent = new Intent(xmlTest.this, list3.class);
		startActivity(intent);
		break;
		}
    
	case 4: {
		Intent intent = new Intent(xmlTest.this, list4.class);
		startActivity(intent);
		break;
    	}
	
	case 5: {
		Intent intent = new Intent(xmlTest.this, list5.class);
		startActivity(intent);
		break;
		}
	
	
	}
}

}



