package exam.andexam;

import android.app.*;
import android.os.*;
import android.widget.*;

public class C10_Rating extends Activity {
	RatingBar mRating;
	TextView mRateText;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c10_rating);

		mRating = (RatingBar)findViewById(R.id.ratingbar);
		mRateText = (TextView)findViewById(R.id.ratetext);

		mRating.setOnRatingBarChangeListener(new 
				RatingBar.OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating, 
					boolean fromUser) {
				mRateText.setText("Now Rate : " + rating);
			}
		});
	}
}