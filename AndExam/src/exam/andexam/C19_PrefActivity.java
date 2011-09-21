package exam.andexam;

import android.os.*;
import android.preference.*;

public class C19_PrefActivity extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.c19_prefactivity);
    }
}