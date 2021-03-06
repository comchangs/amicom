package exam.andexam;

import java.io.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class C21_DomParser extends Activity {
	TextView mResult;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c21_domparser);

		mResult = (TextView)findViewById(R.id.result);
	}
	
	public void mOnClick(View v) {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
			"<order><item>Mouse</item></order>";

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputStream istream = new ByteArrayInputStream(xml.getBytes("utf-8"));
			Document doc = builder.parse(istream);
	
			Element order = doc.getDocumentElement();
			NodeList items = order.getElementsByTagName("item");
			Node item = items.item(0);
			Node text = item.getFirstChild();
			String ItemName = text.getNodeValue();
			mResult.setText("주문 항목 : " + ItemName);
		} 
		catch (Exception e) {
			Toast.makeText(v.getContext(), e.getMessage(), 0).show();
		}
	}	
}
