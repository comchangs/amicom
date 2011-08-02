package android.ajou.amicom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class One extends View{

	 private static final float RADIUS = 30;
	 private Paint backgroundPaint;
	 private Paint myPaint1;
	 private Paint myPaint2;
	 private Paint myPaint3;
	 private Paint myPaint4;
	 private Paint myPaint5;
	 private Paint myPaint6;
	 
	 public One(Context context, AttributeSet attrs){
	 super(context, attrs);
	 
	 backgroundPaint = new Paint();
	 backgroundPaint.setColor(Color.YELLOW);
	 
	 myPaint1 = new Paint();
	 myPaint2 = new Paint();
	 myPaint3 = new Paint();
	 myPaint4 = new Paint();
	 myPaint5 = new Paint();
	 myPaint6 = new Paint();

	 myPaint1.setColor(Color.BLUE);
	 myPaint2.setColor(Color.BLUE);
	 myPaint3.setColor(Color.BLUE);
	 myPaint4.setColor(Color.BLUE);
	 myPaint5.setColor(Color.BLUE);
	 myPaint6.setColor(Color.BLUE);
	 
	 myPaint1.setAntiAlias(true);
	 myPaint2.setAntiAlias(true);
	 myPaint3.setAntiAlias(true);
	 myPaint4.setAntiAlias(true);
	 myPaint5.setAntiAlias(true);
	 myPaint6.setAntiAlias(true);
	 }

	@Override
	public boolean onTouchEvent(MotionEvent event){
	 int action = event.getAction();
	 switch(action){
	 
	 case MotionEvent.ACTION_DOWN:		 
	 case MotionEvent.ACTION_MOVE:

	 final float a = event.getX();
	 final float b = event.getY();
	 
	 if(Math.sqrt(Math.pow(a - 240, 2) + Math.pow(b - 100, 2)) <= RADIUS){
		 myPaint1.setColor(Color.RED);
	 } 
	 else if(Math.sqrt(Math.pow(a - 220, 2) + Math.pow(b - 120, 2)) <= RADIUS){
		 myPaint2.setColor(Color.RED);
	 }
	 else if(Math.sqrt(Math.pow(a - 200, 2) + Math.pow(b - 140, 2)) <= RADIUS){
		 myPaint3.setColor(Color.RED);
	 }	
	 else if(Math.sqrt(Math.pow(a - 180, 2) + Math.pow(b - 160, 2)) <= RADIUS){
		 myPaint4.setColor(Color.RED);
	 } 
	 else if(Math.sqrt(Math.pow(a - 160, 2) + Math.pow(b - 180, 2)) <= RADIUS){
		 myPaint5.setColor(Color.RED);
	 }
	 else if(Math.sqrt(Math.pow(a - 140, 2) + Math.pow(b - 200, 2)) <= RADIUS){
		 myPaint6.setColor(Color.RED);
	 }	
	 return true;
	 
	 case MotionEvent.ACTION_UP:
	 case MotionEvent.ACTION_CANCEL:
	 
	  break;
	 }
	 
	 return(true);
	} 

	@Override
	public void onDraw(Canvas canvas){
	 int width = canvas.getWidth();
	 int height = canvas.getHeight();
	 canvas.drawRect(0, 0, width, height, backgroundPaint);
	 canvas.drawCircle(240, 100, RADIUS, myPaint1);
	 canvas.drawCircle(220, 120, RADIUS, myPaint2);
	 canvas.drawCircle(200, 140, RADIUS, myPaint3);
	 canvas.drawCircle(180, 160, RADIUS, myPaint4);
	 canvas.drawCircle(160, 180, RADIUS, myPaint5);
	 canvas.drawCircle(140, 200, RADIUS, myPaint6);

	  invalidate();
	}
	
	}