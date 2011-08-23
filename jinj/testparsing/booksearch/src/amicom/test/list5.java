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

public class list5 extends Activity {
	/** Called when the activity is first created. */
	String cnt = xmlTest.cnt;
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

				 String yourUrl = "http://library.ajou.ac.kr/cache/book_detail.asp?"+cnt+"&cbo_s=fld11&ct=5";
			        
			        TextView tv = (TextView)findViewById(R.id.sub0);
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
			     
			     
				
				
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
			 


			 
				
			  
			  return content;

			    }
			   
			}


