package amicom.test;



import android.app.*;
import android.app.TabActivity;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
public class menuonly extends  TabActivity {
    public static parsing parsing;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();
        final parsing parsing = new parsing();
        
		tabHost.addTab(tabHost.newTabSpec("breakfast").setIndicator("아침")
				.setContent(new Intent(this, breakfast.class)));
		tabHost.addTab(tabHost.newTabSpec("lunch").setIndicator("점심")
				.setContent(new Intent(this, lunch.class)));
		tabHost.addTab(tabHost.newTabSpec("dinner").setIndicator("저녁")
				.setContent(new Intent(this, dinner.class)));
		tabHost.addTab(tabHost.newTabSpec("snack").setIndicator("분식")
				.setContent(new Intent(this, snack.class)));
	}
}
