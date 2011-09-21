package exam.andexam;

import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.widget.*;

public class C28_BatteryService extends Service {
	public int onStartCommand (Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(mBRBattery, filter);
		return START_STICKY;
	}

	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mBRBattery);
	}

	BroadcastReceiver mBRBattery = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
				int scale, level, ratio;
				scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
				level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
				ratio = level * 100 / scale;

				RemoteViews views = new RemoteViews(context.getPackageName(), 
						R.layout.c28_battery);
				views.setTextViewText(R.id.gauge, "" + ratio + "%");
				AppWidgetManager wm = AppWidgetManager.getInstance(
						C28_BatteryService.this);
				ComponentName widget = new ComponentName(context, C28_Battery.class);
				wm.updateAppWidget(widget, views);
			}
		}
	};
};

