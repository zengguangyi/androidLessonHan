package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class ProgressBarSampleActivity extends Activity {
	/** Called when the activity is first created. */
	// 模拟任务大小为100个数组
	private int[] data = new int[100];
	// 任务完成度--默认为0
	private int hasdata = 0;
	//状态完成度
	int status = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Handler h = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what == 0x11){
					ProgressBar pb = (ProgressBar)findViewById(R.id.pb);
					pb.setProgress(status);
				}
			}
		};

		// 构造一个线程
		new Thread() {
			@Override
			public void run() {
				while (status < 100) {
					status = dowork();
					Message m = new Message();
					m.what = 0x11;
					h.handleMessage(m);
				}
			}
		}.start();
	}

	public int dowork() {
		//完成100个1
		data[hasdata++] = 1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hasdata;
	}
}