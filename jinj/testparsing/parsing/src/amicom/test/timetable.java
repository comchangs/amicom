package amicom.test;

import java.io.*;
import java.net.*;
import java.util.*;

import org.xmlpull.v1.*;


import android.app.*;
import android.content.*;
import android.content.res.*;
import android.content.res.AssetManager.AssetInputStream;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class timetable extends Activity {
	static String[] temp;
    static int i = 0;
    static int j = 0;
	//String personXMLString = "";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);  	
/*
        try {
        	 Log.i("jin", "0");
            personXMLString = getXMLFileFromAssets();
            Log.i("jin", "11.");
     } catch (IOException e) {

           // TODO Auto-generated catch block

                  e.printStackTrace();
                  Log.i("jin", "111.");
     }
 */
    
        HttpPostData();
     
   
     TextView tv1 = (TextView)findViewById(R.id.sub1);
     tv1.setText(temp[0].toString());
   
     TextView tv2 = (TextView)findViewById(R.id.sub2);
     tv2.setText( temp[1].toString());
  
     TextView tv3 = (TextView)findViewById(R.id.sub3);
     tv3.setText( temp[2].toString());
  
     TextView tv4 = (TextView)findViewById(R.id.sub4);
     tv4.setText( temp[3].toString());
  
     TextView tv5 = (TextView)findViewById(R.id.sub5);
     tv5.setText( temp[4].toString());
    
     TextView tv6 = (TextView)findViewById(R.id.sub6);
     tv6.setText( temp[5].toString());

     TextView tv7 = (TextView)findViewById(R.id.sub7);
     tv7.setText( temp[6].toString());
   
     TextView tv8 = (TextView)findViewById(R.id.sub8);
     tv8.setText( temp[7].toString());
    
     TextView tv9 = (TextView)findViewById(R.id.sub9);
     tv9.setText( temp[8].toString());
    
    
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

			String stdnum = ""; // 학번 ** 테스트시 입력 후 하기 바람!!
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
			PullParserFromXML(myResult);
			Toast.makeText(this, "전송 후 결과 받음", 0).show();
		} catch (MalformedURLException e) {
			Toast.makeText(this, "MalformedURLException", 0).show();
		} catch (IOException e) {
			Toast.makeText(this, "IOException", 0).show();
		}
	} // HttpPostData
/*
	private String getXMLFileFromAssets() throws IOException {
        AssetManager assetManager = getResources().getAssets();
        AssetInputStream ais = (AssetInputStream)assetManager.open("time.xml");      
        BufferedReader br = new BufferedReader(new InputStreamReader(ais));

        String line;
        StringBuilder data = new StringBuilder();
        while((line=br.readLine()) != null)
               data.append(line);
        Log.i("jin", data.toString());
        return data.toString();

  }
*/
    
	private void PullParserFromXML(String data) {
		temp = new String[9];
		
		for (int i=0; i<9; i++) {
			temp[i] = " ";
		}
		Log.i("jin", "parsing..");
		boolean ltRoomNm = false;	//강의실
    	boolean ltTmNm = false;		//
    	boolean sbjtKorNm = false;
    	boolean modDttm = false;
		
		try{
        	

        	XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
        	XmlPullParser parser = parserCreator.newPullParser();
        	String tag;
        	parser.setInput( new StringReader(data));

        	Log.i("jin", "parsing..");
        	int parserEvent = parser.getEventType();
        	
        	
        
        	
        	while (parserEvent != XmlPullParser.END_DOCUMENT ){
        		
        		switch(parserEvent){
        		  case XmlPullParser.START_DOCUMENT:            // 문서의 시작
        			  Log.i("jin", "시작?");
                      break;


                case XmlPullParser.END_DOCUMENT: 
                	Log.i("jin", "끝");// 문서의 끝
                      break;

                      
        		case XmlPullParser.TEXT:
        			tag = parser.getName();
        			
        			if (ltRoomNm) {
        				temp[i] = parser.getText();
        				        				
        			}
        			if (ltTmNm) {
        				Log.i("jin",  parser.getText() );
        				temp[i] += " : "+ parser.getText();       
        				
        			}
        			if (modDttm) {
        				j=1;
        			}
        			
        			if (sbjtKorNm) {
        				Log.i("jin",  parser.getText() );  
        				temp[i] = parser.getText()+" : "+temp[i];
        				if(j!=1)
        					i++;
        				else
        					j=0;
        			}
        			break;
        			
        		case XmlPullParser.END_TAG:
        			tag = parser.getName();
        			if (tag.compareTo("ltRoomNm") == 0) {
        				ltRoomNm = false;
        			}
        			if (tag.compareTo("ltTmNm") == 0) {
        				ltTmNm = false;
        			}
        			if (tag.compareTo("modDttm") == 0) {
        				modDttm = false;
        			}
        			if (tag.compareTo("sbjtKorNm") == 0) {
        				sbjtKorNm = false;
        			}
        			break;	
        			
        		case XmlPullParser.START_TAG:
        			tag = parser.getName();

        			if (tag.compareTo("ltRoomNm") == 0) {
        				ltRoomNm = true;
        			}
        			if (tag.compareTo("ltTmNm") == 0) {
        				ltTmNm = true;
        			}
        			if (tag.compareTo("modDttm") == 0) {
        				modDttm = true;
        			}
        			if (tag.compareTo("sbjtKorNm") == 0) {
        				sbjtKorNm = true;
        			}
        			break;




        		}
        		parserEvent = parser.next();
        	}
        	Log.i("XML", "parse complete");
        }catch( Exception e ){
        	Log.e("dd", "Error in network call", e);
        }
	}
	
}
