package tjuci.edu.dl;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SufaceVideoTestActivity extends Activity implements OnClickListener{
	SurfaceView sf;
	SurfaceHolder sh;
	Button play,pause;
	MediaPlayer mp;
	String path = "/sdcard/test.mp4";
	boolean isPause = false;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sf = (SurfaceView)findViewById(R.id.surfaceView);
        sh = sf.getHolder();
        sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        play = (Button)findViewById(R.id.btn1);
        pause = (Button)findViewById(R.id.btn2);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        mp = new MediaPlayer();
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == play){
			isPause = false;
			playSound(path);
		}else if(v == pause){
			if(isPause == false){
				mp.pause();
				isPause = true;
			}else{
				mp.start();
				isPause = false;
			}
		}
	}
	public void playSound(String strPath){
		if(mp.isPlaying()){//ÕýÔÚ²¥·Å
			mp.reset();
		}
//		mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mp.setDisplay(sh);
		try {
			mp.setDataSource(strPath);
			mp.prepare();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mp.start();
	}
}