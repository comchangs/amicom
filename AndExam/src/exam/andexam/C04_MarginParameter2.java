package exam.andexam;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.widget.*;

public class C04_MarginParameter2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setBackgroundColor(Color.LTGRAY);

		Button btn = new Button(this);
		btn.setText("Button With Margin");

		LinearLayout.LayoutParams parambtn = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		parambtn.setMargins(0, 30, 0, 30);
		linear.addView(btn, parambtn);

		setContentView(linear);
    }
}