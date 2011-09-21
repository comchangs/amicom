package exam.andexam;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;

public class C08_EditLimit extends Activity {
	EditText mLimitEdit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c08_editlimit);

		mLimitEdit = (EditText)findViewById(R.id.limit);
		mLimitEdit.setFilters(new InputFilter[] {
				new InputFilter.LengthFilter(3)
		});
	}
}