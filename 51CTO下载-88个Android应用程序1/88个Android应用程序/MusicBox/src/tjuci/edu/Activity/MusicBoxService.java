package tjuci.edu.Activity;

import java.io.IOException;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicBoxService extends Service {
	MediaPlayer mp;
	//°´Å¥×´Ì¬
	int status = 0x11;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		mp = new MediaPlayer();
		//×¢²á×Ô¼ºµÄBroadcastReciever  ¼´ MyMusicBroadcastReciever
		IntentFilter filter = new IntentFilter(MusicBoxActivity.MusicBoxServiceBroadcastReciever);
		this.registerReceiver(new MyMusicBroadcastReciever(), filter);
		super.onCreate();
	}
	public class MyMusicBroadcastReciever extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String control = intent.getStringExtra("control");
			if(control.equals("btn1")){//°´Å¥1
				if(status == 0x11){//Î´²¥·Å×´Ì¬
					AssetManager am = MusicBoxService.this.getAssets();
					AssetFileDescriptor afd ;
					try {
						afd = am.openFd("wish.mp3");
						mp.reset();
						mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
						mp.prepare();
					} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
					mp.start();
					status = 0x12;
				}else if(status == 0x12){//²¥·Å×´Ì¬
					mp.pause();
					status = 0x13;
				}else if(status == 0x13){//ÔÝÍ£×´Ì¬
					mp.start();
					status = 0x12;
				}
			}else if(control.equals("btn2")){//°´Å¥2
				if(status == 0x12 || status == 0x13){
					mp.stop();
					status = 0x11;
				}
			}
			Intent sendIntent = new Intent(MusicBoxActivity.MusicBoxActivityBroadcastReciever);
			sendIntent.putExtra("status", status);
			sendBroadcast(sendIntent);
		}
	}
}
