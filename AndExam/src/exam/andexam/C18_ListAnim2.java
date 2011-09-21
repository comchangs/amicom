package exam.andexam;

import java.util.*;

import android.app.*;
import android.os.*;
import android.view.animation.*;
import android.widget.*;

public class C18_ListAnim2 extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c18_listanim2);

		ArrayAdapter<CharSequence> Adapter;
		Adapter = ArrayAdapter.createFromResource(this, R.array.listanim,
				android.R.layout.simple_list_item_1);
		ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(Adapter);
	}
}
