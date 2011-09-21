package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_CustomNotiView extends Activity {
	static final int NAPNOTI = 1;
    NotificationManager mNotiManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c22_napalarm);
        mNotiManager = (NotificationManager)getSystemService(
        		NOTIFICATION_SERVICE);
    }
        
	public void mOnClick(View v) {
		Toast.makeText(C22_CustomNotiView.this, "안녕히 주무세요", 0).show();
		v.postDelayed(new Runnable() {
			public void run() {
    			Notification noti = new Notification(R.drawable.napalarm,
    					"일어나세요",System.currentTimeMillis());
    			noti.defaults |= Notification.DEFAULT_SOUND;
    			noti.flags |= Notification.FLAG_INSISTENT;
    			
    			Intent intent = new Intent(C22_CustomNotiView.this,C22_NapEnd.class);
    			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    			PendingIntent content = PendingIntent.getActivity(
    					C22_CustomNotiView.this, 0, intent, 0);
    			
    			RemoteViews napView = new RemoteViews(getPackageName(), 
    					R.layout.c22_customnotiview);
    			noti.contentView = napView;
    			noti.contentIntent = content;
    			
    			// 통지 출력
    			mNotiManager.notify(C22_NapAlarm.NAPNOTI, noti);
			}
		}, 5 * 1000);
	}
}