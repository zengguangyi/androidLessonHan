package tjuci.edu.dl;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimationSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageView iv = (ImageView)findViewById(R.id.iv);
        Button btn = (Button)findViewById(R.id.btn);
        final Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
        final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        anim1.setFillAfter(true);//保持最后的状态
        anim2.setFillAfter(true);
        final Handler h = new Handler(){
        	@Override
        	public void handleMessage(Message msg) {
        		if(msg.what == 0x11){
        			iv.startAnimation(anim2);
        		}
        	}
        };
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.startAnimation(anim1);
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						h.sendEmptyMessage(0x11);
					}
				}, 3500);
			}
		});
       
    }
}