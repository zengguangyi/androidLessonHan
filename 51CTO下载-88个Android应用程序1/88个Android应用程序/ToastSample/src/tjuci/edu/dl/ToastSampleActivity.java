package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastSampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 简单的toast
		Button btn1 = (Button) findViewById(R.id.btn1);
		Button btn2 = (Button) findViewById(R.id.btn2);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(ToastSampleActivity.this, "简单的toast",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(ToastSampleActivity.this, null, Toast.LENGTH_SHORT);
				View view = getLayoutInflater().inflate(R.layout.toast, null);
				toast.setView(view);
				toast.show();
			}
		});
	}
}