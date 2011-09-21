package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C09_ManyItem extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c09_listview);

		((ListView)findViewById(R.id.list)).setAdapter(new ManyAdapter(this));
	}
}

class ManyAdapter extends BaseAdapter {
	Context maincon;
	LayoutInflater Inflater;

	public ManyAdapter(Context context) {
		maincon = context;
		Inflater = (LayoutInflater)context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return 1000;
	}

	public String getItem(int position) {
		return "" + position;
	}

	public long getItemId(int position) {
		return position;
	}

	// 각 항목의 뷰 생성
	public View getView(int position, View convertView, ViewGroup parent) {
		String log = "position = " + position + ", ";
		if (convertView == null) {
			convertView = Inflater.inflate(android.R.layout.simple_list_item_1, 
					parent, false);
			log += "convertView is null";
		} else {
			log += "convertView is not null";
		}
		Log.d("ManyItem", log);
		TextView txt = (TextView)convertView.findViewById(android.R.id.text1);
		txt.setText("ManyItem ListView : " + position);
		return convertView;
	}
}
