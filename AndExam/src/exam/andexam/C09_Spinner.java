package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class C09_Spinner extends Activity {
	ArrayAdapter<CharSequence> adspin;
	boolean mInitSpinner;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c09_spinner);

		Spinner spin = (Spinner)findViewById(R.id.myspinner);
		spin.setPrompt("과일을 고르세요.");

		adspin = ArrayAdapter.createFromResource(this, R.array.fruits, 
				android.R.layout.simple_spinner_item);
		adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adspin);

		spin.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, 
					int position, long id) {
				/* 초기화시의 선택 제외시
				if (mInitSpinner == false) {
					mInitSpinner = true;
					return;
				}
				//*/
				Toast.makeText(C09_Spinner.this,adspin.getItem(position) + "는 맛있다.",
						Toast.LENGTH_SHORT).show();
			}
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
}
