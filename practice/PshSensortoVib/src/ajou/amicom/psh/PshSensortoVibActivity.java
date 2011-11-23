package ajou.amicom.psh;


import java.util.*;
import android.app.*;
import android.content.*;
import android.hardware.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class PshSensortoVibActivity extends Activity {
	final static String TAG = "MotionCounter";
	final static float G = SensorManager.STANDARD_GRAVITY;
	SensorManager mSm;
	TextView mCounterText;
	int mCounter = 100;
	long mApplyTime;
	int mSenGap = 1000;
	float mSenRange = 16.0f;
	int mSenSpeed = 800;
	ArrayList<AccelValue> arValue = new ArrayList<AccelValue>();
	final static int MAXCOUNT = 20;
	Vibrator mVib;
	
	
	class AccelValue {
		float[] value = new float[3];
		long time;
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		String vibratorService = Context.VIBRATOR_SERVICE;
		mVib = (Vibrator)getSystemService(vibratorService);
		
		mSm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		mSm.registerListener(mSensorListener, mSm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_GAME);

		mCounterText = (TextView)findViewById(R.id.counter);
		UpdateValueText();
		long[] pattern = {1000, 2000, 4000, 8000, 16000};
		mVib.vibrate(pattern, 3); 

		
		
		findViewById(R.id.incsen).setOnClickListener(mClickListener);
		findViewById(R.id.decsen).setOnClickListener(mClickListener);
		findViewById(R.id.incgap).setOnClickListener(mClickListener);
		findViewById(R.id.decgap).setOnClickListener(mClickListener);
		findViewById(R.id.incspeed).setOnClickListener(mClickListener);
		findViewById(R.id.decspeed).setOnClickListener(mClickListener);
	}

	// �ı��Ǳ� ������ ��� �����ؾ� ��
	protected void onDestroy() {
		super.onDestroy();
		mSm.unregisterListener(mSensorListener);
	
	}

	SensorEventListener mSensorListener = new SensorEventListener() {
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}

		public void onSensorChanged(SensorEvent event) {
			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				// ���Ӱ� ť ����� �迭�� ����
				AccelValue av = new AccelValue();
				av.value[0] = event.values[0];
				av.value[1] = event.values[1];
				av.value[2] = event.values[2];
				av.time = event.timestamp / 100000L;
				if (arValue.size() == MAXCOUNT) {
					arValue.remove(0);
				}
				arValue.add(av);

				// �ν� ������ ������ �ʾ����� ����
				long now = System.currentTimeMillis();
				if (now - mApplyTime < mSenGap) {
					break;
				}
				
				TextView txtresult = (TextView)findViewById(R.id.result);
				String result = "";

				// ������ �Ⱓ���� �� ���� ���Ӱ��� �ּ�, �ִ밪 �� ���� ���
				float[] min = new float[] { 100, 100, 100};
				float[] max = new float[] { -100, -100, -100};
				for (int i = arValue.size() - 1; i >= 0; i--) {
					AccelValue v = arValue.get(i); 
					if (av.time - v.time > mSenSpeed) {
						result += "�˻� ���� = " + (arValue.size() -1) + " ~ " + i + "\n"; 
						break;
					}
					for (int j = 0; j < 3; j++) {
						min[j] = Math.min(min[j], v.value[j]);
						max[j] = Math.max(max[j], v.value[j]);
					}
				}
				float[] diff = new float[3];
				for (int j = 0; j < 3; j++) {
					diff[j] = Math.abs(max[j] - min[j]);
					result += "diff[" + j + "] = " + diff[j] + "\n";
				}

				txtresult.setText(result);

				// X �� ���� - ����
				if (diff[0] > mSenRange) {
				
					mVib.vibrate(1000);
					mApplyTime = now;
					mCounter++;
					mCounterText.setText("" + mCounter);
					arValue.clear();
					
					break;
				}

				// Y �� ���� - ����
				if (diff[1] > mSenRange) {
					mVib.vibrate(1000);
					mApplyTime = now;
					mCounter = 100;
					mCounterText.setText("" + mCounter);
					arValue.clear();
					
					break;
					
				}

				// Z �� ���� - ����
				if (diff[2] > mSenRange) {
					mVib.vibrate(1000);
					mApplyTime = now;
					mCounter--;
					mCounterText.setText("" + mCounter);
					arValue.clear();
					break;
				}

				break;
			}
		}
	};

	float Deg2Rad(float deg) {
		return (deg * (float)Math.PI) / 180;
	}

	View.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.incsen:
			case R.id.decsen:
				mSenRange += (v.getId() == R.id.incsen ? 1.0f:-1.0f);
				break;
			case R.id.incgap:
			case R.id.decgap:
				mSenGap += (v.getId() == R.id.incgap ? 500:-500);
				break;
			case R.id.incspeed:
			case R.id.decspeed:
				mSenSpeed += (v.getId() == R.id.incspeed ? 100:-100);
				break;
			}
			UpdateValueText();
		}
	};

	void UpdateValueText() {
		TextView txtsen = (TextView)findViewById(R.id.txtsen);
		txtsen.setText("�ΰ��� : " + (int)mSenRange);
		TextView txtgap = (TextView)findViewById(R.id.txtgap);
		txtgap.setText("���� : " + mSenGap);
		TextView txtspeed = (TextView)findViewById(R.id.txtspeed);
		txtspeed.setText("�ӵ� : " + mSenSpeed);
	}
}
