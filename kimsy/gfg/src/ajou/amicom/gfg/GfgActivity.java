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
   if (msg.what == 0) { // ȭ���� ��������
    vw.invalidate();
    mHandler.sendEmptyMessageDelayed( 0, 50 );
    
   }
  }
 };
 
 // ��� ��ü
 protected class Block{
  int x; // ����� x ��ǥ
  int y; // ����� y �¤Ф�
  int width; // ����� ����ũ��
  int height; // ����� ����ũ��
  
  


  Rect rt; // ����� �簢����
  boolean bExist; // ����� ���翩��
 

  // �ʱ�ȭ
  Block( int x, int y, int width, int height, boolean exist ){   
   this.x = x;
   this.y = y;
   this.width = width;
   this.height = height;
   bExist = exist;
   
   rt = new Rect( x, y, x + width, y + height );   
  }
  
  // ����� ball �簢������ ��ġ�� �κ��� �����ϴ��� �Ǻ��Ѵ�.
  int isCrash( Rect ball ){
   
   // ball rect �� rt rect �� ��ġ��
   if( Rect.intersects( ball, rt ) )
   {
    if( rt.top > ball.top ) // ����� �����ִ�.     
     return 1;
    else // �Ʒ��� �ִ�.
     return 2;
   }   
   return 0; // ��ġ�� ������ 0  ����
  }
  
  // ����� �μ���
  void breakBlock(){
   bExist = false;
  }
 }

 protected class MyView extends View {

  int xstep; // �׸��� x��
  int ystep; // �׸��� y��ǥ
  int xMov; // �׸��� X �� ����
  int yMov; // �׸��� Y �� ����
  int movement = 15; // �׸��� �̵��ӵ� 0.1 �ʴ� 6��
  int size; // �׸��� ũ��
  
  Rect rect; // �׸� �簢 ����
  Rect barRect; // �� �簢 ����
  
  int xBar; // ���� x��ġ
  int yBar; // ���� y ��ġ  
  
  int barWidth = 60;// ���� �ʺ�
  int barHeight = 10; // ���� ����
  
  int blockXpos; // ����� ������ġ
  int blockYpos; 
  int blockSize; // ����� ũ��
  
  int score = 0;
  int score2= 5;
  Paint paint = new Paint();  

  Block[] blocks;
  Block[] blocks2;
  Block[] blocks3;
  public MyView(Context context) {
   super(context); // ȭ����� ������ ��ġ�� ����


   xstep = new Random().nextInt(100);
   ystep = new Random().nextInt(200); // ������ ��ġ�� ����
  
   xMov = -10;
   yMov = 10;
   
   size = 12; // �׸�ũ�� 4�� ����
   
   xBar = 100;
   yBar = 300;
   
   barRect = new Rect();
   
   barRect.left = xBar;
   barRect.top = yBar;
   barRect.right = barRect.left + barWidth;
   barRect.bottom = barRect.top + barHeight; // ���� �簢���� ����
   
   rect = new Rect();
   
   rect.left = xstep; // �簢 ���� ����
   rect.top = ystep;
   rect.right = xstep + size;
   rect.bottom = xstep + size;
   
   blockXpos = 30; // ����� ���� ��ġ
   blockYpos = 30;
   blockSize = 20; // ����� ũ��
   
   
   
   // ��� �迭��ü ���� �ʱ�ȭ
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
   pnt.setColor(Color.WHITE); // �Ķ��� ���� ����
   canvas.drawColor(Color.BLACK); // ������ ���
   paint.setColor(Color.WHITE);  
   paint.setAntiAlias(true);
   paint.setTextSize(20);
   paint.setTypeface(Typeface.create("", Typeface.BOLD));  
   
   
   
   if (xstep+size> getWidth()) {
    xMov=-xMov;
    xstep = getWidth()-size;
   }// ���� ���� �ε�ģ ��
   if (xstep < 0) {
    xMov=-xMov;
    xstep = 0;
   } // ���ʺ��� �ε�ģ ���
   if (ystep < 0) {
    yMov=-yMov;
    ystep = 0;    
   }
   // �����ʺ�
   if (ystep + size > getHeight()) {
	   xstep = 140;
	   ystep = 150; // ������ ��ġ�� ����
	   score2-=1;
    /*makeAngle( 180, 180 );
    ystep = getHeight() -  size; // ���� �������°� ����*/
   }
   //�Ʒ��� ��
   
		   
   xstep += xMov; // �׸� ��
   ystep += yMov; // ������ ���� �ε�ģ ���
   
   rect.left = xstep;
   rect.top = ystep;
   rect.right = rect.left + size;
   rect.bottom = rect.top + size;
   
   paint.setColor(Color.WHITE);
   canvas.drawText("Score " + score, 30, 20, paint); 
   paint.setColor(Color.BLUE);                    // Cyan ��?
   canvas.drawText("Life"+score2, 140,20, paint); 
   
       



   int n;
   int m;
   int k;
   
   for( int i = 0 ; i < 12 ; i++ ){
    if( blocks[ i ].bExist ){
     n = blocks[ i ].isCrash( rect );     
     if( n == 1 ){ // ����� �����ִ� ��� �������� Ƣ���Ѵ�.
      yMov=-yMov;
      blocks[ i ].breakBlock();
      score+=15;
      break;
     }else if( n == 2 ){ // ����� �Ʒ��ִ°ܤ����� �Ʒ������� Ƣ���Ѵ�.
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
	     if( m== 1 ){ // ����� �����ִ� ��� �������� Ƣ���Ѵ�.
	      yMov=-yMov;
	      blocks2[ i ].breakBlock();
	      score+=10;
	      break;
	     }else if( m == 2 ){ // ����� �Ʒ��ִ°ܤ����� �Ʒ������� Ƣ���Ѵ�.
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
	     if( k== 1 ){ // ����� �����ִ� ��� �������� Ƣ���Ѵ�.
	      yMov=-yMov;
	      blocks3[ i ].breakBlock();
	      score+=6;
	      break;
	     }else if( k == 2 ){ // ����� �Ʒ��ִ°ܤ����� �Ʒ������� Ƣ���Ѵ�.
	    	 yMov=-yMov;
	      blocks3[ i ].breakBlock();
	      score+=6;
	      break;
	     }
	    }    
	   }
   
   // �ٿ� �׸� ��ĥ��� �������� Ƣ�� �Ѵ�
   if( Rect.intersects( barRect , rect ) ){
	   yMov=-yMov;
   }
   
  
   
   
   canvas.drawRect( rect, pnt); // �׸� �׸���   
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
