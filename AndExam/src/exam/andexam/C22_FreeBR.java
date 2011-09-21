package exam.andexam;

import android.content.*;

public class C22_FreeBR extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Intent intent2 = new Intent(context, C21_DownHtml.class);
		intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent2);
	}
}