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
        //�õ�LocationManager����
        final LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateView(l);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 8, new LocationListener() {
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// ��LocationManager��provider��״̬�ı�ʱ������
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// ��LocationManager��provider����ʱ����
				updateView(lm.getLastKnownLocation(provider));
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// ��LocationManager��provider������ʱ����
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// ��GPS��λ��Ϣ�����ı�ʱ ����
				updateView(location);
			}
		});
    }
    public void updateView(Location location){
    	if(location != null){
    		StringBuffer sb = new StringBuffer();
    		sb.append("ʵʱ��λ����Ϣ:");
    		sb.append("\n����:");
    		sb.append(location.getLongitude());
    		sb.append("\nγ��:");
    		sb.append(location.getLatitude());
    		sb.append("\n�߶�:");
    		sb.append(location.getAltitude());
    		sb.append("\n����:");
    		sb.append(location.getBearing());
    		et.setText(sb.toString());
    	}else{
    		et.setText("");
    	}
    }
}