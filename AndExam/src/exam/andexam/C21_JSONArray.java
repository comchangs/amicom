package exam.andexam;

import java.io.*;

import javax.xml.parsers.*;

import org.json.*;
import org.w3c.dom.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C21_JSONArray extends Activity {
	TextView mResult;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_jsonparser);

		mResult = (TextView)findViewById(R.id.result);
	}

	public void mOnClick(View v) {
		String Json = "[8,9,6,2,9]";
		try {
			int sum = 0;
			JSONArray ja = new JSONArray(Json);
			for (int i = 0; i < ja.length(); i++) {
				sum += ja.getInt(i);
			}
			mResult.setText("Sum = " + sum);
		} catch (JSONException e) {
			Toast.makeText(v.getContext(), e.getMessage(), 0).show();
		}
	}
}
