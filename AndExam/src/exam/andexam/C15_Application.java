package exam.andexam;

import android.app.*;

public class C15_Application extends Application {
	private int mMode;
	static final int BEGINNER = 0;
	static final int PREFESSIONAL = 1;

	public void onCreate() {
		super.onCreate();
		mMode = BEGINNER;
	}

	public void onTerminate() {
		super.onTerminate();
	}
	
	public int getMode() {
		return mMode;
	}
	
	public void setMode(int aMode) {
		mMode = aMode;
	}
}