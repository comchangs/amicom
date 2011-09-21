package exam.external;

import java.io.*;

import android.*;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import exam.andexam.R;

public class C19_ShareFile extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c19_sharefile);
		
		final EditText edit;
		edit = (EditText)findViewById(R.id.edittext);

		Button btnload = (Button)findViewById(R.id.load);
		btnload.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				try {
					Context Other = createPackageContext("exam.andexam", 
							Context.CONTEXT_IGNORE_SECURITY);
					FileInputStream fis = Other.openFileInput("test.txt");
					byte[] data = new byte[fis.available()];
					while (fis.read(data) != -1) {;}
					fis.close();
					edit.setText(new String(data));
				} catch (NameNotFoundException e) {
					edit.setText("Package Not Found");
				}
				catch (FileNotFoundException e) {
					edit.setText("File Not Found");
				}
				catch (Exception e) {;}
			}
		});
	}
}
