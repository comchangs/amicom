package exam.andexam;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C04_Inflation4 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    LinearLayout linear = new LinearLayout(this);
	    linear.setOrientation(LinearLayout.VERTICAL);
	    linear.setBackgroundColor(Color.LTGRAY);

	    TextView text = (TextView)View.inflate(this, R.layout.c04_mytext, null);

	    linear.addView(text);
	    setContentView(linear);
	}
}