package exam.andexam;

import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.util.*;
import android.widget.*;

public class C28_Battery extends AppWidgetProvider {
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, 
			int[] appWidgetIds) {
		Intent intent = new Intent(context, C28_BatteryService.class);
		context.startService(intent);
	}

	public void onDeleted(Context context) {
		Intent intent = new Intent(context, C28_BatteryService.class);
		context.stopService(intent);
    }
}
