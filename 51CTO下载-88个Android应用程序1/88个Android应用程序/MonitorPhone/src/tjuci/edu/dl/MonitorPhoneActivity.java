package tjuci.edu.dl;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MonitorPhoneActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final TelephonyManager tManager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		PhoneStateListener phoneStateListener = new PhoneStateListener() {

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				switch (state) {
				case TelephonyManager.CALL_STATE_IDLE:// 无任何状态
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:// 挂机状态
					break;
				case TelephonyManager.CALL_STATE_RINGING:// 来电状态
					OutputStream os = null;
					try {
						os = openFileOutput("phoneList", MODE_APPEND);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintStream ps = new PrintStream(os);
					ps.println(new Date() + " 来电:" + incomingNumber);
					ps.close();
					break;
				default:
					break;
				}
			}
		};
		tManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
	}
}