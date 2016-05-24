package tjuci.edu.dl;

import java.io.File;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewSampleActivity extends Activity {
	MediaController mediaController;
	VideoView vv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.main);
		mediaController = new MediaController(this);
		vv = (VideoView) findViewById(R.id.vv);
		File file = new File("/mnt/sdcard/test.mp4");
		vv.setVideoPath(file.getAbsolutePath());
		vv.setMediaController(mediaController);
		mediaController.setMediaPlayer(vv);
		vv.requestFocus();
	}
}