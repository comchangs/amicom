package exam.andexam;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.widget.*;

public class C08_ReadResource extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c08_readresource);

		Resources res = getResources();
		TextView text = (TextView)findViewById(R.id.text);

		String str = res.getString(R.string.textstr);
		text.setText(str);
		// 리소스 ID를 전달해도 잘 동작한다.
		//text.setText(R.string.textstr);
		int textcolor = res.getColor(R.color.textcolor);
		text.setTextColor(textcolor);
		float textsize = res.getDimension(R.dimen.textsize);
		text.setTextSize(textsize);
		// 두 호출문은 제대로 동작하지 않음
		//text.setTextColor(R.color.textcolor);
		//text.setTextSize(R.dimen.textsize);
	}
}