package android.ajou.amicom;


import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

public class One extends Activity{
	GameView gv;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		gv =  new GameView(this);
		setContentView(gv);
	}
	

	class Shape {
		final static int CIRCLE = 0;
		
		int what;
		int color;
		Rect rt;
	}
	
	class GameView extends View {
		final static int BLANK = 0;
		final static int PLAY = 1;
		final static int DELAY = 1500;
		int status;
		ArrayList<Shape> arShape =  new ArrayList<Shape>();
		Random Rnd = new Random();
		Activity mParent;
		
		public GameView(Context context){
			super(context);
			mParent = (Activity)context;
			status = BLANK;
			mHandler.sendEmptyMessageDelayed(0,DELAY);
		}
		
		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.BLACK);
			if (status == BLANK){
				return;
			}
			
			int idx;
			for (idx = 0; idx < arShape.size(); idx++){
				Paint Pnt =  new Paint();
				Pnt.setAntiAlias(true);
				Pnt.setColor(arShape.get(idx).color);
				
				Rect rt = arShape.get(idx).rt;
				switch (arShape.get(idx).what){
				case Shape.CIRCLE:
					canvas.drawCircle(rt.left + rt.width()/2, rt.top + rt.height()/2, idx, Pnt);
					break;
				}
			}
		}
		
	void AddNewShape(){
		Shape shape = new Shape();
		int idx;
		@SuppressWarnings("unused")
		boolean bFindIntersect;
		Rect rt = new Rect();
	
		for (;;){
		
			int Size =  32 + 16 * Rnd.nextInt(3);
			
			rt.left = Rnd.nextInt(getWidth());
			rt.top = Rnd.nextInt(getHeight());
			rt.right =  rt.left + Size;
			rt.bottom = rt.top + Size;
			
			if(rt.right>getWidth()||rt.bottom>getHeight()){
				continue;
			}
		
			bFindIntersect = false;
			for(idx = 0; idx< arShape.size(); idx ++){
				if(rt.intersect(arShape.get(idx).rt) == true){
					bFindIntersect = true;
				}
			}
			
			if (bFindIntersect = false){
				break;
			}
		}
		
		shape.what = Rnd.nextInt(3);
		
		switch (Rnd.nextInt(5)){
		case 0:
			shape.color = Color.WHITE;
			break;
		case 1:
			shape.color = Color.RED;
			break;
		case 2:
			shape.color = Color.GREEN;
			break;
		case 3:
			shape.color = Color.BLUE;
			break;
		case 4:
			shape.color = Color.YELLOW;
			break;
		}
		
		shape.rt = rt;
		arShape.add(shape);
	}

	int FindShapeIdx(int x, int y){
		int idx;
		
		for (idx = 0; idx < arShape.size(); idx++){
			if(arShape.get(idx).rt.contains(x,y)){
				return idx;
			}
		}
		return -1;
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(Message msg){
			AddNewShape();
			status = PLAY;
			invalidate();
			
			String title;
			title = "기억력게임-" + arShape.size() + "단계";
			mParent.setTitle(title);
		}
	};
 }
}

	 