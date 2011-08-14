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
	String personXMLString = "";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);  	
        try {
        	 Log.i("jin", "0");
            personXMLString = getXMLFileFromAssets();
            Log.i("jin", "11.");
     } catch (IOException e) {

           // TODO Auto-generated catch block

                  e.printStackTrace();
                  Log.i("jin", "111.");
     }
     PullParserFromXML(personXMLString);
     
   
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
