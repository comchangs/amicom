package amicom.test;

import java.io.*;
import java.net.*;
import java.util.*;

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

public class lunch extends Activity {
	String menutime1 = menuonly.parsing.menutime1;
	String menulist5 = menuonly.parsing.menulist5;
	String menutime2 = menuonly.parsing.menutime2;
	String menulist6 = menuonly.parsing.menulist6;
	String menutime3 = menuonly.parsing.menutime3;
	String menulist7 = menuonly.parsing.menulist7;
	String menutime4 = menuonly.parsing.menutime4;
	String menulist8 = menuonly.parsing.menulist8;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView result1 = (TextView) findViewById(R.id.time1);
		result1.setText(menutime1);
		
		TextView result2 = (TextView) findViewById(R.id.menu1);
		result2.setText(menulist5);
		
		TextView result3 = (TextView) findViewById(R.id.time2);
		result3.setText(menutime2);
		
		TextView result4 = (TextView) findViewById(R.id.menu2);
		result4.setText(menulist6);
		
		TextView result5 = (TextView) findViewById(R.id.time3);
		result5.setText(menutime3);
		
		TextView result6 = (TextView) findViewById(R.id.menu3);
		result6.setText(menulist7);
		
		TextView result7 = (TextView) findViewById(R.id.time4);
		result7.setText(menutime4);
		
		TextView result8 = (TextView) findViewById(R.id.menu4);
		result8.setText(menulist8);
}}