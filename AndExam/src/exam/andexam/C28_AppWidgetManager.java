package exam.andexam;

import java.util.*;

import android.app.*;
import android.appwidget.*;
import android.os.*;
import android.widget.*;

public class C28_AppWidgetManager extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c28_appwidgetmanager);
		
		AppWidgetManager mAWM = AppWidgetManager.getInstance(this);
		List<AppWidgetProviderInfo> mList = mAWM.getInstalledProviders();
		
		String result = "count = " + mList.size() + "\n";
		for (AppWidgetProviderInfo info : mList) {
			result += info.toString() + "\n";
		}
		TextView resulttxt = (TextView)findViewById(R.id.result);
		resulttxt.setText(result);
	}
}
