package exam.andexam;

import java.util.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C10_PickerDialog extends Activity {
	int mYear, mMonth, mDay, mHour, mMinute;
	TextView mTxtDate;
	TextView mTxtTime;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_pickerdialog);
		
		mTxtDate = (TextView)findViewById(R.id.txtdate);
		mTxtTime = (TextView)findViewById(R.id.txttime);

		Calendar cal = new GregorianCalendar();
		mYear = cal.get(Calendar.YEAR);
		mMonth = cal.get(Calendar.MONTH);
		mDay = cal.get(Calendar.DAY_OF_MONTH);
		mHour = cal.get(Calendar.HOUR_OF_DAY);
		mMinute = cal.get(Calendar.MINUTE);
		
		UpdateNow();
	}
	
	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnchangedate:
			new DatePickerDialog(C10_PickerDialog.this, mDateSetListener, 
					mYear, mMonth, mDay).show();
			break;
		case R.id.btnchangetime:
			new TimePickerDialog(C10_PickerDialog.this, mTimeSetListener, 
					mHour, mMinute, false).show();
			break;
		}
	}
	
	DatePickerDialog.OnDateSetListener mDateSetListener = 
		new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			UpdateNow();
		}            
	};
	
	TimePickerDialog.OnTimeSetListener mTimeSetListener = 
		new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet (TimePicker view, int hourOfDay, int minute) {
			mHour = hourOfDay;
			mMinute = minute;
			UpdateNow();
		}            
	};

	void UpdateNow() {
		mTxtDate.setText(String.format("%d/%d/%d", mYear, 
				mMonth + 1, mDay));
		mTxtTime.setText(String.format("%d:%d", mHour, mMinute));
	}
}
