package ajou.amicom.Caltest;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class Caltest extends AppWidgetProvider {
	
	@Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds )
    {
        RemoteViews remoteViews;

		 ComponentName Caltest;
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_BROWSABLE); 
        intent.setComponent(new ComponentName("ajou.amicom.Caltest", "ajou.amicom.Caltest.PopActivity"));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        remoteViews = new RemoteViews( context.getPackageName(), R.layout.main );
        Caltest = new ComponentName( context, Caltest.class );
        remoteViews.setOnClickPendingIntent(R.id.btn01, pendingIntent);
        appWidgetManager.updateAppWidget( Caltest, remoteViews );
        
        
    }
}


