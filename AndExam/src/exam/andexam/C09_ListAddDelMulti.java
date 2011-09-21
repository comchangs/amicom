package exam.andexam;

import java.util.*;

import android.app.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class C09_ListAddDelMulti extends Activity {
	ArrayList<String> Items;
	ArrayAdapter<String> Adapter;
	ListView list;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c09_listadddel);

		Items = new ArrayList<String>();
		Items.add("First");
		Items.add("Second");
		Items.add("Third");
		Items.add("Fourth");
		Items.add("Fifth");

		Adapter = new ArrayAdapter<String>(this, android.R.layout.
				simple_list_item_multiple_choice, Items);
		list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		list.setOnItemClickListener(mItemClickListener);
	}

	public void mOnClick(View v) {
		EditText ed = (EditText)findViewById(R.id.newitem);
		switch (v.getId()) {
		case R.id.add:
			String text = ed.getText().toString();
			if (text.length() != 0) {
				Items.add(text);
				ed.setText("");
				Adapter.notifyDataSetChanged();
			}
			break;
		case R.id.delete:
			SparseBooleanArray sb = list.getCheckedItemPositions();
			if (sb.size() != 0) {
				for (int i = list.getCount() - 1; i >= 0 ; i--) {
					if (sb.get(i)) {
						Items.remove(i);
					}
				}
				list.clearChoices();
				Adapter.notifyDataSetChanged();
			}
			break;
		}
	}
	
	AdapterView.OnItemClickListener mItemClickListener = 
		new AdapterView.OnItemClickListener() {
		@SuppressWarnings("unchecked")
		public void onItemClick(AdapterView parent, View view, int position, long id) {
			String mes;
			mes = "Select Item = " + Items.get(position);
			Toast.makeText(C09_ListAddDelMulti.this,mes,Toast.LENGTH_SHORT).show();
		}
	};
}
