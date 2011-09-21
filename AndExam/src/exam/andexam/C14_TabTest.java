package exam.andexam;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C14_TabTest extends TabActivity {
	TabHost mTab;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost mTab = getTabHost();

		LayoutInflater inflater = LayoutInflater.from(this);
		inflater.inflate(R.layout.c14_tabtest, mTab.getTabContentView(), true);

		mTab.addTab(mTab.newTabSpec("tag")
				.setIndicator("일반")
				.setContent(R.id.opt_general));

		/* 풀어 쓰기
		TabHost.TabSpec spec = mTab.newTabSpec("tag");
		spec.setIndicator("일반");
		spec.setContent(R.id.opt_general);
		mTab.addTab(spec);
		*/

		mTab.addTab(mTab.newTabSpec("tag")
				.setIndicator("컴파일러")
				.setContent(R.id.opt_compiler));
		mTab.addTab(mTab.newTabSpec("tag")
				.setIndicator("링커")
				.setContent(R.id.opt_linker));
	}
}