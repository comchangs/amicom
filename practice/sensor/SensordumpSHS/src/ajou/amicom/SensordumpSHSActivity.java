package ajou.amicom;


import android.app.*;
import android.content.*;
import android.hardware.*;
import android.os.*;
import android.widget.*;

public class SensordumpSHSActivity extends Activity {
	SensorManager mSm;
	TextView mTxtLight, mTxtProxi, mTxtPress, mTxtAccel, mTxtMagnetic, mTxtOrient, mTextreuslt1;
	int mLightCount, mProxiCount, mPressCount;
	int mAccelCount, mMagneticCount, mOrientCount;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mSm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

		mTxtLight =(TextView)findViewById(R.id.light);
		mTxtProxi =(TextView)findViewById(R.id.proxi);
		mTxtPress =(TextView)findViewById(R.id.press);
		mTxtOrient =(TextView)findViewById(R.id.orient);
		mTxtAccel =(TextView)findViewById(R.id.accel);
		mTxtMagnetic =(TextView)findViewById(R.id.magnetic);
		mTextreuslt1 = (TextView)findViewById(R.id.result1);
		
	}
	
    protected void onResume() {
        super.onResume();
		int delay = SensorManager.SENSOR_DELAY_UI;

		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_LIGHT), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_PROXIMITY), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_PRESSURE), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_ORIENTATION), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_TEMPERATURE), delay);
		mSm.registerListener(mSensorListener, 
				mSm.getDefaultSensor(Sensor.TYPE_GYROSCOPE), delay);
    }
    
    protected void onPause() {
        super.onPause();
        
        mSm.unregisterListener(mSensorListener);
    }
    
    SensorEventListener mSensorListener = new SensorEventListener() {
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// 특별히 처리할 필요없음
		}

		public void onSensorChanged(SensorEvent event) {
			// 신뢰성없는 값은 무시
			if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
				//return;
			}

			float[] v = event.values;
			float[] u = event.values;
			
			switch (event.sensor.getType()) {
			case Sensor.TYPE_LIGHT:
				mTxtLight.setText("조도 = " + ++mLightCount + "회 : " + v[0]);
				break;
			case Sensor.TYPE_PROXIMITY:
				mTxtProxi.setText("근접 = " + ++mProxiCount + "회 : " + v[0]);
				break;
			case Sensor.TYPE_PRESSURE:
				mTxtPress.setText("압력 = " + ++mPressCount + "회 : " + v[0]);
				break;
			case Sensor.TYPE_ORIENTATION:
				mTxtOrient.setText("방향 = " + ++mOrientCount + "회 : \n  azimuth:" +  
						u[0] + "\n  pitch:" + u[1] + "\n  roll:" + u[2]);
				break;
			case Sensor.TYPE_ACCELEROMETER:
				mTxtAccel.setText("가속 = " + ++mAccelCount + "회 : \n  X:" + 
						v[0] + "\n  Y:" + v[1] + "\n  Z:" + v[2]);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				mTxtMagnetic.setText("자기 = " + ++mMagneticCount + "회 : \n  X:" +  
						v[0] + "\n  Y:" + v[1] + "\n  Z:" + v[2]);
				break;
			}
			float a = u[1];
	 float c = Math.abs(a);
	 float b = u[2];
	 float d = Math.abs(b);
	
 
if(u[1]>0 &&  c>d){
	mTextreuslt1.setText("앞쪽");
}
else if(u[1]>0 && c>d){
	mTextreuslt1.setText("앞쪽");
}
else if(u[1]<0 && c>d){
	mTextreuslt1.setText("뒤쪽");
}
else if(u[1]<0 && c>d){
	mTextreuslt1.setText("뒤쪽");
}
else if(u[0]>0 && c<d){
	mTextreuslt1.setText("왼쪽");
}
else if(u[0]<0 && c<d){
	mTextreuslt1.setText("오른쪽");
}

		}

    };
}
