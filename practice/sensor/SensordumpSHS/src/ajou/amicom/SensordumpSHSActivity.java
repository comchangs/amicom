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
			// Ư���� ó���� �ʿ����
		}

		public void onSensorChanged(SensorEvent event) {
			// �ŷڼ����� ���� ����
			if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
				//return;
			}

			float[] v = event.values;
			float[] u = event.values;
			
			switch (event.sensor.getType()) {
			case Sensor.TYPE_LIGHT:
				mTxtLight.setText("���� = " + ++mLightCount + "ȸ : " + v[0]);
				break;
			case Sensor.TYPE_PROXIMITY:
				mTxtProxi.setText("���� = " + ++mProxiCount + "ȸ : " + v[0]);
				break;
			case Sensor.TYPE_PRESSURE:
				mTxtPress.setText("�з� = " + ++mPressCount + "ȸ : " + v[0]);
				break;
			case Sensor.TYPE_ORIENTATION:
				mTxtOrient.setText("���� = " + ++mOrientCount + "ȸ : \n  azimuth:" +  
						u[0] + "\n  pitch:" + u[1] + "\n  roll:" + u[2]);
				break;
			case Sensor.TYPE_ACCELEROMETER:
				mTxtAccel.setText("���� = " + ++mAccelCount + "ȸ : \n  X:" + 
						v[0] + "\n  Y:" + v[1] + "\n  Z:" + v[2]);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				mTxtMagnetic.setText("�ڱ� = " + ++mMagneticCount + "ȸ : \n  X:" +  
						v[0] + "\n  Y:" + v[1] + "\n  Z:" + v[2]);
				break;
			}
			float a = u[1];
	 float c = Math.abs(a);
	 float b = u[2];
	 float d = Math.abs(b);
	
 
if(u[1]>0 &&  c>d){
	mTextreuslt1.setText("����");
}
else if(u[1]>0 && c>d){
	mTextreuslt1.setText("����");
}
else if(u[1]<0 && c>d){
	mTextreuslt1.setText("����");
}
else if(u[1]<0 && c>d){
	mTextreuslt1.setText("����");
}
else if(u[0]>0 && c<d){
	mTextreuslt1.setText("����");
}
else if(u[0]<0 && c<d){
	mTextreuslt1.setText("������");
}

		}

    };
}
