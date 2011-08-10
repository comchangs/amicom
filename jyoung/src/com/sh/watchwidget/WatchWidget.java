package com.sh.watchwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class WatchWidget extends AppWidgetProvider
{
    @Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds )
    {
        RemoteViews remoteViews;
        ComponentName watchWidget;
        DateFormat format = SimpleDateFormat.getTimeInstance( SimpleDateFormat.MEDIUM, Locale.getDefault() );

        remoteViews = new RemoteViews( context.getPackageName(), R.layout.appwidgetmain );
        watchWidget = new ComponentName( context, WatchWidget.class );
        remoteViews.setTextViewText( R.id.widget_textview, "½Ã°£:" + format.format( new Date()));
        appWidgetManager.updateAppWidget( watchWidget, remoteViews );
        
        
    }
}