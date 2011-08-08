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

        arGeneral.add("추천여행코스");

        arGeneral.add("테마여행코스");



       

        //어댑터를 만들고

        ArrayAdapter<String> Adapter;

        //생성자는 ArrayAdapter(Context context, int textViewResourceId, List<T> objects)

        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);

 

        //리스트뷰를 xml과 연결해주고

        ListView list = (ListView)findViewById(R.id.list);

        list.setAdapter(Adapter);
    }
}