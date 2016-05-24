package tjuci.edu.dl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class SMSLisenterBroadcastReciver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		abortBroadcast();
		// TODO Auto-generated method stub
		if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
			StringBuilder sb  = new StringBuilder();
			Bundle bundle = intent.getExtras();
			if(bundle != null){
				Object[] pdus = (Object[])bundle.get("pdus");
				SmsMessage[] messages = new SmsMessage[pdus.length];
				for(int i = 0; i < pdus.length; i ++){
					messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				}
				for(SmsMessage message:messages){
					sb.append("短信来源：")
					.append(message.getDisplayOriginatingAddress())
					.append("\n-------短信内容----------\n")
					.append(message.getDisplayMessageBody());
				}
			}
			Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
		}
	}
}