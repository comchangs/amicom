package exam.andexam;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class C14_TabTest3 extends TabActivity {
	TabHost mTab;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tag")
                .setIndicator("Price")
                .setContent(new Intent(this, C08_GramPrice.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("StopWatch")
                .setContent(new Intent(this, C10_StopWatch.class)));
        
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Score")
                .setContent(new Intent(this, C10_SportsScore.class)));
	}
}