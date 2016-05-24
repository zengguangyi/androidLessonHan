package tjuci.edu.dl;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SundPoolSampleActivity extends Activity implements OnClickListener {
	SoundPool soundPool;
	Map<Integer, Integer> soundMap;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn1, btn2, btn3;
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		soundPool= new SoundPool(5, AudioManager.STREAM_SYSTEM, 5);
		soundMap = new HashMap<Integer, Integer>();
		soundMap.put(1, soundPool.load(this, R.raw.arrow, 1));
		soundMap.put(2, soundPool.load(this, R.raw.bomb, 1));
		soundMap.put(3, soundPool.load(this, R.raw.shot, 1));
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1:
			soundPool.play(soundMap.get(1), 1, 1, 0, 0, 1);
			break;

		case R.id.btn2:
			soundPool.play(soundMap.get(2), 1, 1, 0, 0, 1);
			break;
		case R.id.btn3:
			soundPool.play(soundMap.get(3), 1, 1, 0, 0, 1);
			break;
		}
	}
}