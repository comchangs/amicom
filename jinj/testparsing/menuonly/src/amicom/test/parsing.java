package amicom.test;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;



import amicom.test.R.string;
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

public class parsing {

	public static String menulist[] = new String[50];
	public static String menulist1 = "";
	public static String menulist2 = "";
	public static String menulist3 = "";
	public static String menulist4 = "";
	public static String menulist5 = "";
	public static String menulist6 = "";
	public static String menulist7 = "";
	public static String menulist8 = "";
	public static String menulist9 = "";
	public static String menulist10 = "";
	public static String menulist11 = "";
	public static String menulist12 = "";
	public static String menulist13 = "";
	public static String menulist14 = "";
	public static String menulist15 = "";
	public static String menulist16 = "";
	

	public static String menutime1 = "";
	public static String menutime2 = "";
	public static String menutime3 = "";
	public static String menutime4 = "";

	
	
	public parsing() {

		HttpGet httpget = new HttpGet(
				"http://www.ajou.ac.kr/campus_life/food/today.jsp");
		DefaultHttpClient client = new DefaultHttpClient();
		StringBuilder html = new StringBuilder();
		
		
		int listnum = 0;
		int linecompare = -1;

		String cafestart = "<!-- 아향 테이블 시작 -->";
		String cafeend = "<!-- 교직원식당 테이블 끝 -->";
		String cafename1 = "dummy_string";
		String cafename2 = "lineend";
		String nomenu = "등록된 식단이 없습니다.";

		String breakfast = "아침";
		String lunch = "점심";
		String dinner = "저녁";
		String snack = "분식";

		String cafe1 = "<!-- 아향 테이블 시작 -->";
		String cafe2 = "<!-- 아향플러스 테이블 시작 -->";
		String cafe3 = "<!-- 기숙사식당 테이블 시작 -->";
		String cafe4 = "<!-- 교직원식당 테이블 시작 -->";
		
		menutime1 = "아향";
		menutime2 = "기숙사 식당";
		menutime3 = "학생회관 식당";
		menutime4 = "교직원 식당";
		
		try {
			HttpResponse response = client.execute(httpget);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "EUC-KR"));
			for (;;) {
				String line = br.readLine();
				String linecapy = line;
				
				
				
				int check3 = linecapy.indexOf(nomenu);
				if (check3 != linecompare) {
					menulist[listnum] = nomenu;
					listnum += 1;
				}

				String time1 = "/campus_life/food/img/food_tbl_fimg01.gif";
				String time2 = "/campus_life/food/img/food_tbl_fimg02.gif";
				String time3 = "/campus_life/food/img/food_tbl_fimg03.gif";
				String time4 = "/campus_life/food/img/food_tbl_fimg04.gif";

				int check5 = linecapy.indexOf(time1);
				if (check5 != linecompare) {
					menulist[listnum] = breakfast;
					listnum += 1;
				}
				int check6 = linecapy.indexOf(time2);
				if (check6 != linecompare) {
					menulist[listnum] = lunch;
					listnum += 1;
				}
				int check7 = linecapy.indexOf(time3);
				if (check7 != linecompare) {
					menulist[listnum] = dinner;
					listnum += 1;
				}
				int check8 = linecapy.indexOf(time4);
				if (check8 != linecompare) {
					menulist[listnum] = snack;
					listnum += 1;
				}

				String startmenu = "	<td style='word-break:break-all'>";
				String endmenu = "</td>";

				int check9 = linecapy.indexOf(startmenu);
				if (check9 != linecompare) {
					String menumod1 = linecapy;
					String menumod2 = menumod1.replaceAll("amp;", "");
					String menumod3 = menumod2.replaceAll("&nbsp;", "");

					String menumod4 = menumod3.replaceFirst(startmenu, "");
					String menumod5 = menumod4.replaceFirst(endmenu, "\n");

					menulist[listnum] = menumod5;
					listnum += 1;
				}

				int check2 = linecapy.indexOf(cafeend);
				if (check2 != linecompare) {
					menulist[listnum] = cafename2;
					listnum += 1;
					break;
				}

				int check10 = linecapy.indexOf(cafe1);
				if (check10 != linecompare) {
					menulist[listnum] = menutime1;
					listnum += 1;
				}

				int check11 = linecapy.indexOf(cafe2);
				if (check11 != linecompare) {
					menulist[listnum] = menutime2;
					listnum += 1;
				}
				int check12 = linecapy.indexOf(cafe3);
				if (check12 != linecompare) {
					menulist[listnum] = menutime3;
					listnum += 1;
				}
				int check13 = linecapy.indexOf(cafe4);
				if (check13 != linecompare) {
					menulist[listnum] = menutime4;
					listnum += 1;
				}
				
			}
			br.close();
		} catch (Exception e) {
			;
		}

		int allline = 0;
		int cutline = 0;
		
		for (allline = 0; allline < listnum; allline++) {
			if (menulist[allline] == cafename1) {
				cutline = allline + 1;
				break;
			}
		}

		for (allline = cutline; allline < listnum; allline++) {
			
			int cafecheck1 = menulist[allline].indexOf(menutime1);	//아향시작
			if (cafecheck1 != linecompare) {
				allline += 1;
				if (menulist[allline] == nomenu) {
					menulist1 = nomenu + "\n";
					menulist5 = nomenu + "\n";
					menulist9 = nomenu + "\n";
					menulist13 = nomenu + "\n";
				}			
				int divcheck1 = menulist[allline].indexOf(breakfast);	//아침
				if (divcheck1 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(lunch) == linecompare);allline += 1){
						menulist1 += menulist[allline];			//아침메뉴
					}					
				}
				
				int divcheck5 = menulist[allline].indexOf(lunch);	//점심
				if (divcheck5 != linecompare ) {
					allline += 1;
					for(;(menulist[allline].indexOf(dinner) == linecompare);allline += 1){
						menulist5 += menulist[allline];		//점심메뉴
					}
				}
				
				int divcheck9 = menulist[allline].indexOf(dinner);	//저녁
				if (divcheck9 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(snack) == linecompare);allline += 1){
						menulist9 += menulist[allline];		//저녁메뉴
					}
				}
				
				int divcheck13 = menulist[allline].indexOf(snack);	//분식
				if (divcheck13 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(menutime2) == linecompare);allline += 1){
						menulist13 += menulist[allline];	//분식메뉴
					}
				}
				
			}
			
			
			int cafecheck2 = menulist[allline].indexOf(menutime2);	//학식시작
			if (cafecheck2 != linecompare) {
				allline += 1;
				if (menulist[allline] == nomenu) {
					menulist2 = nomenu + "\n";
					menulist6 = nomenu + "\n";
					menulist10 = nomenu + "\n";
					menulist14 = nomenu + "\n";
				}				
				int divcheck2 = menulist[allline].indexOf(breakfast);	//아침
				if (divcheck2 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(lunch) == linecompare);allline += 1){
						menulist2 += menulist[allline];			//아침메뉴
					}					
				}
				
				int divcheck6 = menulist[allline].indexOf(lunch);	//점심
				if (divcheck6 != linecompare ) {
					allline += 1;
					for(;(menulist[allline].indexOf(dinner) == linecompare);allline += 1){
						menulist6 += menulist[allline];		//점심메뉴
					}
				}
				
				int divcheck10 = menulist[allline].indexOf(dinner);	//저녁
				if (divcheck10 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(snack) == linecompare);allline += 1){
						menulist10 += menulist[allline];		//저녁메뉴
					}
				}
				
				int divcheck14 = menulist[allline].indexOf(snack);	//분식
				if (divcheck14 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(menutime3) == linecompare);allline += 1){
						menulist14 += menulist[allline];	//분식메뉴
					}
				}
				}
				
			
			
			
			int cafecheck3 = menulist[allline].indexOf(menutime3);	//기식시작
			if (cafecheck3 != linecompare) {
				allline += 1;
				if (menulist[allline] == nomenu) {
					menulist3 = nomenu + "\n";
					menulist7 = nomenu + "\n";
					menulist11 = nomenu + "\n";
					menulist15 = nomenu + "\n";
				}	
				int divcheck3 = menulist[allline].indexOf(breakfast);	//아침
				if (divcheck3 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(lunch) == linecompare);allline += 1){
						menulist3 += menulist[allline];			//아침메뉴
					}					
				}
				
				int divcheck7 = menulist[allline].indexOf(lunch);	//점심
				if (divcheck7 != linecompare ) {
					allline += 1;
					for(;(menulist[allline].indexOf(dinner) == linecompare);allline += 1){
						menulist7 += menulist[allline];		//점심메뉴
					}
				}
				
				int divcheck11 = menulist[allline].indexOf(dinner);	//저녁
				if (divcheck11 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(snack) == linecompare);allline += 1){
						menulist11 += menulist[allline];		//저녁메뉴
					}
				}
				
				int divcheck15 = menulist[allline].indexOf(snack);	//분식
				if (divcheck15 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(menutime4) == linecompare);allline += 1){
						menulist15 += menulist[allline];	//분식메뉴
					}
				}
				
			}
			
			int cafecheck4 = menulist[allline].indexOf(menutime4);	//교직원시작
			if (cafecheck4 != linecompare) {
				allline += 1;
				if (menulist[allline] == nomenu) {
					menulist4 = nomenu + "\n";
					menulist8 = nomenu + "\n";
					menulist12 = nomenu + "\n";
					menulist16 = nomenu + "\n";
				}	
				int divcheck4 = menulist[allline].indexOf(breakfast);	//아침
				if (divcheck4 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(lunch) == linecompare);allline += 1){
						menulist4 += menulist[allline];			//아침메뉴
					}					
				}
				
				int divcheck8 = menulist[allline].indexOf(lunch);	//점심
				if (divcheck8 != linecompare ) {
					allline += 1;
					for(;(menulist[allline].indexOf(dinner) == linecompare);allline += 1){
						menulist8 += menulist[allline];		//점심메뉴
					}
				}
				
				int divcheck12 = menulist[allline].indexOf(dinner);	//저녁
				if (divcheck12 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(snack) == linecompare);allline += 1){
						menulist12 += menulist[allline];		//저녁메뉴
					}
				}
				
				int divcheck16 = menulist[allline].indexOf(snack);	//분식
				if (divcheck16 != linecompare) {
					allline += 1;
					for(;(menulist[allline].indexOf(cafename2) == linecompare);allline += 1){
						menulist16 += menulist[allline];	//분식메뉴
					}
				}
				
			}

			if (menulist[allline] == cafename2)
				break;
			
			
			
		
		}	//전체 for문 닫기 
	
			
		
	}
}

