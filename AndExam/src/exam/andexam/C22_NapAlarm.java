package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C22_NapAlarm extends Activity {
	static final int NAPNOTI = 1;
    NotificationManager mNotiManager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c22_napalarm);
        mNotiManager = (NotificationManager)getSystemService(
        		NOTIFICATION_SERVICE);
    }

	public void mOnClick(View v) {
		Toast.makeText(C22_NapAlarm.this, "안녕히 주무세요", 0).show();
		v.postDelayed(new Runnable() {
			public void run() {
    			Notification noti = new Notification(R.drawable.napalarm,
    					"일어나세요",System.currentTimeMillis());
    			noti.defaults |= Notification.DEFAULT_SOUND;
    			// 진동 사용
    			noti.defaults |= (Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
    			// 커스텀 진동
    			noti.vibrate = new long[] {1000,1000,500,500,200,200,200,200,200,200};
    			noti.flags |= Notification.FLAG_INSISTENT;
    			
    			Intent intent = new Intent(C22_NapAlarm.this, C22_NapEnd.class);
    			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    			PendingIntent content = PendingIntent.getActivity(
    					C22_NapAlarm.this, 0, intent, 0);
    			noti.setLatestEventInfo(C22_NapAlarm.this, "기상 시간", 
    					"일어나! 일할 시간이야.", content);
    			
    			mNotiManager.notify(C22_NapAlarm.NAPNOTI, noti);
			}
		}, 5 * 1000);
	}
}
