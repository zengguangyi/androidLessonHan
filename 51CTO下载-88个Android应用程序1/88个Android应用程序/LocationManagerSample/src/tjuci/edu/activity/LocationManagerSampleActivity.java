package tjuci.edu.activity;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.EditText;

public class LocationManagerSampleActivity extends Activity {
	
	EditText et;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et = (EditText)findViewById(R.id.et);
        //得到LocationManager对象
        final LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 8, new LocationListener() {
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// 当LocationManager的provider的状态改变时被调用
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// 当LocationManager的provider可用时调用
				updateView(lm.getLastKnownLocation(provider));
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// 当LocationManager的provider不可用时调用
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// 当GPS定位信息发生改变时 调用
				updateView(location);
			}
		});
    }
    public void updateView(Location location){
    	if(location != null){
    		StringBuffer sb = new StringBuffer();
    		sb.append("实时的位置信息:");
    		sb.append("\n经度:");
    		sb.append(location.getLongitude());
    		sb.append("\n纬度:");
    		sb.append(location.getLatitude());
    		sb.append("\n高度:");
    		sb.append(location.getAltitude());
    		sb.append("\n方向:");
    		sb.append(location.getBearing());
    		et.setText(sb.toString());
    	}else{
    		et.setText("");
    	}
    }
}