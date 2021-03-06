package tjuci.edu.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

public class ProximityAlertSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //定义接近区域的大致经度、纬度
        double longitude = 113.39;
        double latitude = 23.13;
        //定义接近区域的半径(5公里)
        float radius = 5000;
        //定义接近区域后 触发的PendingIntent
        Intent intent = new Intent(this,ProximityAlertReciever.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, -1, intent, 0);
        //添加接近警告
        lm.addProximityAlert(latitude, longitude, radius, -1, pi);
    }
}