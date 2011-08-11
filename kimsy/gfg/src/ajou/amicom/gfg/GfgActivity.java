package ajou.amicom.gfg;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class GfgActivity extends Activity {
 MyView vw;

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  vw = new MyView(this);
  setContentView(vw);
  mHandler.sendEmptyMessage( 0 );
  
  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);


 }

 Handler mHandler = new Handler() {
  public void handleMessage(Message msg) {
   if (msg.what == 0) { // 화면을 갱신해줌
    vw.invalidate();
    mHandler.sendEmptyMessageDelayed( 0, 50 );
    
   }
  }
 };
 
 // 블록 객체
 protected class Block{
  int x; // 블록의 x 좌표
  int y; // 블록의 y 좌ㅠㅛ
  int width; // 블록의 가로크기
  int height; // 블록의 세로크기
  
  


  Rect rt; // 블록의 사각영역
  boolean bExist; // 블록의 존재여부
 

  // 초기화
  Block( int x, int y, int width, int height, boolean exist ){   
   this.x = x;
   this.y = y;
   this.width = width;
   this.height = height;
   bExist = exist;
   
   rt = new Rect( x, y, x + width, y + height );   
  }
  
  // 블록이 ball 사각영역과 겹치는 부분이 존재하는지 판별한다.
  int isCrash( Rect ball ){
   
   // ball rect 와 rt rect 가 겹치면
   if( Rect.intersects( ball, rt ) )
   {
    if( rt.top > ball.top ) // 블록이 위에있다.     
     return 1;
    else // 아래에 있다.
     return 2;
   }   
   return 0; // 겹치지 않으면 0  리턴
  }
  
  // 블록을 부순다
  void breakBlock(){
   bExist = false;
  }
 }

 protected class MyView extends View {

  int xstep; // 네모의 x좌
  int ystep; // 네모의 y좌표
  int xMov; // 네모의 X 축 증감
  int yMov; // 네모의 Y 축 증감
  int movement = 15; // 네모의 이동속도 0.1 초당 6픽
  int size; // 네모의 크기
  
  Rect rect; // 네모 사각 영역
  Rect barRect; // 바 사각 영역
  
  int xBar; // 바의 x위치
  int yBar; // 바의 y 위치  
  
  int barWidth = 60;// 바의 너비
  int barHeight = 10; // 바의 높이
  
  int blockXpos; // 블록의 시작위치
  int blockYpos; 
  int blockSize; // 블록의 크기
  
  int score = 0;
  int score2= 5;
  Paint paint = new Paint();  

  Block[] blocks;
  Block[] blocks2;
  Block[] blocks3;
  public MyView(Context context) {
   super(context); // 화면안의 랜덤한 위치에 생성


   xstep = new Random().nextInt(100);
   ystep = new Random().nextInt(200); // 임의의 위치에 생성
  
   xMov = -10;
   yMov = 10;
   
   size = 12; // 네모크기 4로 설정
   
   xBar = 100;
   yBar = 300;
   
   barRect = new Rect();
   
   barRect.left = xBar;
   barRect.top = yBar;
   barRect.right = barRect.left + barWidth;
   barRect.bottom = barRect.top + barHeight; // 바의 사각영역 설정
   
   rect = new Rect();
   
   rect.left = xstep; // 사각 영역 설정
   rect.top = ystep;
   rect.right = xstep + size;
   rect.bottom = xstep + size;
   
   blockXpos = 30; // 블록의 시작 위치
   blockYpos = 30;
   blockSize = 20; // 블록의 크기
   
   
   
   // 블록 배열객체 생성 초기화
   blocks = new Block[ 12 ];
   for( int i = 0; i <12 ; i++ ){
	    blocks[ i ] = new Block( blockXpos+i*(blockSize+2), blockYpos, blockSize, blockSize, true );
	   }
   blocks2 = new Block[ 10 ];
   for( int i = 0; i<10;i++){
	   blocks2[i]  = new Block(blockXpos+i*(blockSize+2)+30,blockYpos+blockSize,blockSize,blockSize,true);
   }
   blocks3 = new Block[ 7];
   for( int i = 0; i<7;i++){
	   blocks3[i]  = new Block(blockXpos+i*(blockSize+2)+60,blockYpos+blockSize+blockSize,blockSize,blockSize,true);
   }
  }
	  
  

  public void onDraw(Canvas canvas) {

   Paint pnt = new Paint(); 
   pnt.setColor(Color.WHITE); // 파란색 색깔 선택
   canvas.drawColor(Color.BLACK); // 검은색 배경
   paint.setColor(Color.WHITE);  
   paint.setAntiAlias(true);
   paint.setTextSize(20);
   paint.setTypeface(Typeface.create("", Typeface.BOLD));  
   
   
   
   if (xstep+size> getWidth()) {
    xMov=-xMov;
    xstep = getWidth()-size;
   }// 왼쪽 벽에 부딧친 경
   if (xstep < 0) {
    xMov=-xMov;
    xstep = 0;
   } // 윗쪽벽에 부딧친 경우
   if (ystep < 0) {
    yMov=-yMov;
    ystep = 0;    
   }
   // 오른쪽벽
   if (ystep + size > getHeight()) {
	   xstep = 140;
	   ystep = 150; // 임의의 위치에 생성
	   score2-=1;
    /*makeAngle( 180, 180 );
    ystep = getHeight() -  size; // 벽에 들어가버리는것 방지*/
   }
   //아래쪽 벽
   
		   
   xstep += xMov; // 네모 이
   ystep += yMov; // 오른쪽 벽에 부딧친 경우
   
   rect.left = xstep;
   rect.top = ystep;
   rect.right = rect.left + size;
   rect.bottom = rect.top + size;
   
   paint.setColor(Color.WHITE);
   canvas.drawText("Score " + score, 30, 20, paint); 
   paint.setColor(Color.BLUE);                    // Cyan 색?
   canvas.drawText("Life"+score2, 140,20, paint); 
   
       



   int n;
   int m;
   int k;
   
   for( int i = 0 ; i < 12 ; i++ ){
    if( blocks[ i ].bExist ){
     n = blocks[ i ].isCrash( rect );     
     if( n == 1 ){ // 블록이 위에있는 경우 위쪽으로 튀게한다.
      yMov=-yMov;
      blocks[ i ].breakBlock();
      score+=15;
      break;
     }else if( n == 2 ){ // 블록이 아래있는겨ㅑㅇ우 아래쪽으로 튀게한다.
    	 yMov=-yMov;
      blocks[ i ].breakBlock();
      score+=15;
      break;
     }
    }    
   }
   for( int i = 0 ; i < 10 ; i++ ){
	    if( blocks2[ i ].bExist ){
	     m = blocks2[ i ].isCrash( rect );     
	     if( m== 1 ){ // 블록이 위에있는 경우 위쪽으로 튀게한다.
	      yMov=-yMov;
	      blocks2[ i ].breakBlock();
	      score+=10;
	      break;
	     }else if( m == 2 ){ // 블록이 아래있는겨ㅑㅇ우 아래쪽으로 튀게한다.
	    	 yMov=-yMov;
	      blocks2[ i ].breakBlock();
	      score+=10;
	      break;
	     }
	    }    
	   }
   for( int i = 0 ; i < 7 ; i++ ){
	    if( blocks3[ i ].bExist ){
	     k = blocks3[ i ].isCrash( rect );     
	     if( k== 1 ){ // 블록이 위에있는 경우 위쪽으로 튀게한다.
	      yMov=-yMov;
	      blocks3[ i ].breakBlock();
	      score+=6;
	      break;
	     }else if( k == 2 ){ // 블록이 아래있는겨ㅑㅇ우 아래쪽으로 튀게한다.
	    	 yMov=-yMov;
	      blocks3[ i ].breakBlock();
	      score+=6;
	      break;
	     }
	    }    
	   }
   
   // 바와 네모가 겹칠경우 윗쪽으로 튀게 한다
   if( Rect.intersects( barRect , rect ) ){
	   yMov=-yMov;
   }
   
  
   
   
   canvas.drawRect( rect, pnt); // 네모 그리기   
   canvas.drawRect( xBar - barWidth / 2, yBar, xBar + barWidth, yBar + 10, pnt );   
   pnt.setColor( Color.RED);   
   
   for( int i = 0 ; i <12 ; i++ ){
    if( blocks[ i ].bExist ){
     canvas.drawRect( blocks[ i ].rt, pnt );     
    }
   }
   pnt.setColor( Color.BLUE);
   for( int i = 0 ; i <10 ; i++ ){
	    if( blocks2[ i ].bExist ){
	     canvas.drawRect( blocks2[ i ].rt, pnt );     
	    }
	   }
   pnt.setColor( Color.GREEN);
   for( int i = 0 ; i <7 ; i++ ){
	    if( blocks3[ i ].bExist ){
	     canvas.drawRect( blocks3[ i ].rt, pnt );     
	    }
	   }
  }
 
  public boolean onTouchEvent(MotionEvent event) {
      if (event.getAction() == MotionEvent.ACTION_MOVE) {    
    	  xBar=(int) event.getX();
    	  
    barRect.left = xBar;
    barRect.top = yBar;
    barRect.right = barRect.left + barWidth;
    barRect.bottom = barRect.top + barHeight; 
      }
      return true;
      }
 }
}
