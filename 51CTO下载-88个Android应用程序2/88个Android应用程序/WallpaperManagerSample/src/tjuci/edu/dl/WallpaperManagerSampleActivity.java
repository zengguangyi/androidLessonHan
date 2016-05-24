package tjuci.edu.dl;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WallpaperManagerSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final AlarmManager am = (AlarmManager)this.getSystemService(Service.ALARM_SERVICE);
        final Button start = (Button)findViewById(R.id.start);
        final Button stop = (Button)findViewById(R.id.stop);
		Intent intent = new Intent(WallpaperManagerSampleActivity.this,MyService.class);
		final PendingIntent pi = PendingIntent.getService(WallpaperManagerSampleActivity.this, 0, intent, 0);
        start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				am.setRepeating(AlarmManager.RTC_WAKEUP, 0, 5000, pi);
				start.setEnabled(false);
				stop.setEnabled(true);
			}
		});
        stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				start.setEnabled(true);
				stop.setEnabled(false);
				am.cancel(pi);
			}
		});
    }
}