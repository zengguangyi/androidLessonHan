package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class ProgressBarSampleActivity extends Activity {
	/** Called when the activity is first created. */
	// ģ�������СΪ100������
	private int[] data = new int[100];
	// ������ɶ�--Ĭ��Ϊ0
	private int hasdata = 0;
	//״̬��ɶ�
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

		// ����һ���߳�
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
		//���100��1
		data[hasdata++] = 1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hasdata;
	}
}