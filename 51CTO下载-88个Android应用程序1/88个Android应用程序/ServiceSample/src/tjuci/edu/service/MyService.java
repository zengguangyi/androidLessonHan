package tjuci.edu.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("Service", "onBind");
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d("Service", "onCreate");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("Service", "onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("Service", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
}
