package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;

public class C18_ViewFlipper extends Activity {
	ViewFlipper mFlip;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c18_viewflipper);
		
		mFlip = (ViewFlipper)findViewById(R.id.flip);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnprev:
			mFlip.showPrevious();
			break;
		case R.id.btnnext:
			mFlip.showNext();
			break;
		case R.id.chkflip:
			if (mFlip.isFlipping()) {
				mFlip.stopFlipping();
			} else {
				mFlip.startFlipping();
			}
			break;
		case R.id.chkanim:
			if (mFlip.getInAnimation() == null) {
				mFlip.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.viewin));
				mFlip.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.viewout));
			} else {
				mFlip.setInAnimation(null);
				mFlip.setOutAnimation(null);
			}
			break;
		}
	}
}
