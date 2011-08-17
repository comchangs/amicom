package amicom.test;
import java.io.*;
import java.net.*;
import java.util.*;

import net.htmlparser.jericho.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;


import android.app.*;
import android.os.*;
import android.sax.*;
import android.view.*;
import android.widget.*;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.*;
import android.widget.TabHost.TabContentFactory;
import android.view.View;

import java.io.*;
import java.net.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.*;
import android.widget.*;

public class xmlTest extends Activity {
	 String[] arr = null;
      int i=0;
	
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);

			 String yourUrl = " http://library.ajou.ac.kr/cache/book_search_ok1.asp?subs=1&cnt=369&searchct=&navi=&text1=????&text2=&text3=&text4=&subject2=&cbo_p=&views=??????%20=%20????";
		        
		        TextView tv = (TextView)findViewById(R.id.menu1);
		        tv.setText(getHtmltoText(yourUrl)); 
		    }

	

	 
	     
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
				
				content = content.replaceAll("대출가능","대출가능\n\n" );
				content = content.replaceAll("대출불가능","대출불가능\n\n" );
				content = content.replaceAll("건 출력]","" );
				content = content.replaceAll("중앙도서관","" );
				content = content.replaceAll("[ ]","");
				content = content.replaceAll("]","]\n" );
			 
			
			
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 


		 
			
		  
		  return content;

		    }
		   
		}




