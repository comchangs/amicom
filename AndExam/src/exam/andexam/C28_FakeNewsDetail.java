package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.widget.*;

public class C28_FakeNewsDetail extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c28_fakenewsdetail);

		Intent intent = getIntent();
		int newsid = intent.getIntExtra("newsid", 100); 
		Log.d(C28_FakeNews.TAG, "Config news id = " + newsid);
		TextView detail = (TextView)findViewById(R.id.detailnews);
		detail.setText("상세 뉴스 보기 : " + newsid);
	}
}
