package tjuci.edu.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MusicBoxActivity extends Activity implements OnClickListener {
	// 定义监听器的action
	public static String MusicBoxServiceBroadcastReciever = "tjuci.edu.serivcebroadcast";
	public static String MusicBoxActivityBroadcastReciever = "tjuci.edu.activitybroadcast";
	ImageButton btn1,btn2;
	// 三种状态 0x11未播放 0x12播放 0x13暂停
	// int status = 0x11;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 显示播放和暂停
		btn1 = (ImageButton) findViewById(R.id.btn1);
		// 显示停止
		btn2 = (ImageButton) findViewById(R.id.btn2);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		// 注册broadcast来监听返回的值
		IntentFilter filter = new IntentFilter();
		filter.addAction(MusicBoxActivityBroadcastReciever);
		this.registerReceiver(new MyMusicBoxActivitBroadcastReciever(), filter);
		// 调用一个service 系统内部的操作
		Intent intent = new Intent(this, MusicBoxService.class);
		startService(intent);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MusicBoxServiceBroadcastReciever);
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// 播放和暂停的按钮
		case R.id.btn1:
			intent.putExtra("control", "btn1");
			break;
		// 停止按钮
		case R.id.btn2:
			intent.putExtra("control", "btn2");
			break;
		}
		this.sendBroadcast(intent);
	}

	public class MyMusicBoxActivitBroadcastReciever extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			int status = intent.getIntExtra("status", -1);
			switch (status) {
			case 0x11:
				btn1.setImageResource(R.drawable.play);
				break;
			case 0x12:
				btn1.setImageResource(R.drawable.pause);
				break;
			case 0x13:
				btn1.setImageResource(R.drawable.play);
				break;
			}
		}
	}
}