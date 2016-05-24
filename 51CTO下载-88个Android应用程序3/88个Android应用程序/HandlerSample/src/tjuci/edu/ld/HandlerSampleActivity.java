package tjuci.edu.ld;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class HandlerSampleActivity extends Activity {
	//����仯����Ƭ
	int[] images = {
			R.drawable.q1,
			R.drawable.q6,
			R.drawable.q7,
			R.drawable.q8,
			R.drawable.q9,
	};
	//���崫�ݰ���Ϣ
	int SIGN = 0x11;
	//������Ƭ˳��
	int num = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageView image = (ImageView)findViewById(R.id.image);
        final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if(msg.what == SIGN){
					image.setImageResource(images[num ++]);
					if(num >= 4){
						num = 0;
					}
				}
			}
        };
        new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.what = SIGN;
				handler.sendMessage(msg);
			}
		}, 0,200);
    }
}