package com.sh.watchwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sh.watchwidget.WatchWidget;
import com.sh.watchwidget.R;
import com.sh.watchwidget.WatchWidget.UpdateService;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class WatchWidget extends AppWidgetProvider
{
	public static ComponentName mService = null;
	public static boolean endServiceFlag = false;
	
	
	@Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds )
    {
        
        
    } 
        
        static void updateWidget(Context context, 
   			 AppWidgetManager appWidgetManager,
   			 int appWidgetId){
       	
       	endServiceFlag = false;
   		mService = context.startService(new Intent(context, UpdateService.class));
          }
        
   	public static class UpdateService extends Service implements Runnable {
   		

   		private Handler mHandler;
   		private static final int TIMER_PERIOD = 1 * 1000;

   		private long preTime;
   		private long curTime;
		private int text2;
		private int text1;
		private int text3;


   		@Override
   		public void onCreate(){
   			mHandler = new Handler();
   		}
   		
   		@Override
   		public void onStart(Intent intent, int startId){
   			preTime = System.currentTimeMillis();// - DAY_TIME;
   			
   			mHandler.postDelayed(this, 1000);			
   		}
   		
   		@Override
   		public IBinder onBind(Intent intent) {
   			// TODO Auto-generated method stub
   			return null;
   		}

   		public void run() {

   			curTime = System.currentTimeMillis();
   			Log.d("***********","*******************************************");
   			Log.d("curTime]",""+curTime);
   			Log.d("PreTime]",""+preTime);
        
        RemoteViews views = new RemoteViews( this.getPackageName(), R.layout.appwidgetmain );
       
        
        long CUR_PERIOD = curTime - preTime;   
        
        
        if( CUR_PERIOD >= 1000 &&  CUR_PERIOD < 2000)
			views.setTextViewText(R.id.text1, ""+Integer.toString(text1));
			else if (CUR_PERIOD >= 2000 &&  CUR_PERIOD < 3000)	
		    views.setTextViewText(R.id.text2, ""+Integer.toString(text2));
    		else if (CUR_PERIOD > 3000)
    			views.setTextViewText(R.id.text3,""+Integer.toString(text3));
       
        
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
		ComponentName watchWidget = new ComponentName(this, WatchWidget.class);
		appWidgetManager.updateAppWidget(watchWidget, views);
				
    			
    			if(endServiceFlag){
    				return;
    			}else{
  				mHandler.postDelayed(this, TIMER_PERIOD);
    			

        			
    			
    			
    			}
    		} //run end!!!

    	}// class end
}

