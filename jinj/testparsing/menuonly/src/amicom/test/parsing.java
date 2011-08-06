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

	public static String menutime1 = "";
	public static String menutime2 = "";
	public static String menutime3 = "";
	public static String menutime4 = "";

	public static String nomenulist = "";
	
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
		
		try {
			HttpResponse response = client.execute(httpget);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "EUC-KR"));
			for (;;) {
				String line = br.readLine();
				String linecapy = line;

				int check1 = linecapy.indexOf(cafestart);
				if (check1 != linecompare) {
					menulist[listnum] = cafename1;
					listnum += 1;
				}

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

					String menumod4 = menumod3.replaceFirst(startmenu, "\n");
					String menumod5 = menumod4.replaceFirst(endmenu, "");

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
					menulist[listnum] = cafe1;
					listnum += 1;
				}

				int check11 = linecapy.indexOf(cafe2);
				if (check11 != linecompare) {
					menulist[listnum] = cafe2;
					listnum += 1;
				}
				html.append(line + '\n');
			}
			br.close();
		} catch (Exception e) {
			;
		}

		int allline = 0;
		int cutline = 0;
		int divline = 0;
		

		for (allline = 0; allline < listnum; allline++) {
			if (menulist[allline] == cafename1) {
				cutline = allline + 1;
				break;
			}
		}

		for (allline = cutline; allline < listnum; allline++) {

			if (menulist[allline] == cafename2)
				break;

			if (menulist[allline] == nomenu) {
				menutime1 += nomenu;
				break;
			}

			int divcheck1 = menulist[allline].indexOf(breakfast);
			if (divcheck1 != linecompare) {
				divline = 1;
				allline += 1;
			}

			int divcheck2 = menulist[allline].indexOf(lunch);
			if (divcheck2 != linecompare) {
				//menutime2 = "기숙사 식당";
				divline = 2;
				allline += 1;
			}
			int divcheck3 = menulist[allline].indexOf(dinner);
			if (divcheck3 != linecompare) {
				//menutime3 = "학생회관 식당";
				divline = 3;
				allline += 1;
			}
			int divcheck4 = menulist[allline].indexOf(snack);
			if (divcheck4 != linecompare) {
				//menutime4 = "교직원 식당";
				divline = 4;
				allline += 1;
			}
			int divcheck5 = menulist[allline].indexOf(cafe2);
			if (divcheck5 != linecompare) {
				//menutime4 = "교직원 식당";
				divline = 5;
				allline += 1;
			}
			
			if (divline == 1) {
				menulist1 += menulist[allline];
			} else if (divline == 2) {
				menulist2 += menulist[allline];
			} else if (divline == 3) {
				menulist3 += menulist[allline];
			} else if (divline == 4) {
				menulist4 += menulist[allline];
			}
			if (divcheck5 < allline) {
				menulist5 += menulist[allline];
			}
			menutime1 = "아향";
			menutime2 = "기숙사 식당";
			menutime3 = "학생회관 식당";
			menutime4 = "교직원 식당";
		}
		
		
}
	}

