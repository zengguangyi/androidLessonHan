package tjuci.edu.dl;

import java.io.IOException;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	int[] images = new int[] { R.drawable.lijiang, R.drawable.qiao,
			R.drawable.shuangta, R.drawable.shui };
	int index = 0;
	WallpaperManager wm;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		wm = WallpaperManager.getInstance(MyService.this);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		if (index >= images.length) {
			index = 0;
		}
		try {
			wm.setResource(images[index++]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
