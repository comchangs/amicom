package exam.andexam;

import android.os.*;
import android.view.*;

import com.google.android.maps.*;

public class C24_MapView extends MapActivity {
	MapView mMap;
	MapController mControl;
	protected boolean isRouteDisplayed() {
		return false;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c24_mapview);

		mMap = (MapView)findViewById(R.id.mapview);
		mControl = mMap.getController();
		mControl.setZoom(16);
		mMap.setBuiltInZoomControls(true);

		GeoPoint pt = new GeoPoint(37881311, 127729968);
		mControl.setCenter(pt);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0,1,0,"지도");
		menu.add(0,2,0,"위성");
		menu.add(0,3,0,"거리");
		menu.add(0,4,0,"교통");
		menu.add(0,5,0,"춘천시청");
		menu.add(0,6,0,"강원도청");

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			mMap.setSatellite(false);
			return true;
		case 2:
			mMap.setSatellite(true);
			return true;
		case 3:
			mMap.setStreetView(true);
			return true;
		case 4:
			mMap.setTraffic(true);
			return true;
		case 5:
			mControl.animateTo(new GeoPoint(37881311, 127729968));
			return true;
		case 6:
			mControl.animateTo(new GeoPoint(37885269, 127729592));
			return true;
		}
		return false;
	}
}