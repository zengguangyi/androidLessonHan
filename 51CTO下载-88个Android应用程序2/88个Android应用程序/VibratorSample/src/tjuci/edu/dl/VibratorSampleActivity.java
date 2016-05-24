package tjuci.edu.dl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;

public class VibratorSampleActivity extends Activity {
	Vibrator vibrator;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	if(event.getAction() == MotionEvent.ACTION_DOWN){
    		vibrator.vibrate(2000);
    	}
    	return false;
    }
}