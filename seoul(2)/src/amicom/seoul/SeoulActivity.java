package amicom.seoul;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SeoulActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startActivity(new Intent(this, start_Activity.class));
        ArrayList<String> arGeneral = new ArrayList<String>();

        arGeneral.add("��õ�����ڽ�");

        arGeneral.add("�׸������ڽ�");



       

        //����͸� �����

        ArrayAdapter<String> Adapter;

        //�����ڴ� ArrayAdapter(Context context, int textViewResourceId, List<T> objects)

        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);

 

        //����Ʈ�並 xml�� �������ְ�

        ListView list = (ListView)findViewById(R.id.list);

        list.setAdapter(Adapter);
    }
}