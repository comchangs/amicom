package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class C18_GridAnim extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c18_gridanim);

		GridView grid = (GridView)findViewById(R.id.grid);
		ImageAdapter Adapter = new ImageAdapter(this);
		grid.setAdapter(Adapter);
	}

	class ImageAdapter extends BaseAdapter {
		private Context mContext;

		int[] picture = { R.drawable.pride, R.drawable.dog, R.drawable.cloud };

		public ImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return 30;
		}

		public Object getItem(int position) {
			return picture[position % 3];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
				imageView.setAdjustViewBounds(false);
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(picture[position % 3]);

			return imageView;
		}
	}
}

