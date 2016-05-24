package tjuci.edu.dl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendSMSSampleActivity extends Activity {
	SmsManager smsManager;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        smsManager = SmsManager.getDefault();
       final EditText num = (EditText)findViewById(R.id.num);
        final EditText content = (EditText)findViewById(R.id.content);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PendingIntent pi = PendingIntent.getActivity(SendSMSSampleActivity.this, 0, new Intent(), 0);
				smsManager.sendTextMessage(num.getText().toString(), null, content.getText().toString(), pi, null);
			}
		});
    }
}