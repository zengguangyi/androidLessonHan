package tjuci.edu.activity;

import tjuci.edu.dl.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button startBtn,stopBtn;
        startBtn = (Button)findViewById(R.id.startBtn);
        stopBtn = (Button)findViewById(R.id.stopBtn);
        final Intent intent = new Intent();
        intent.setAction("tjuci.edu.serviece.myservice");
        startBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ServiceSampleActivity.this.startService(intent);
			}
		});
        stopBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ServiceSampleActivity.this.stopService(intent);
			}
		});
    }
}