package tjuci.edu.dl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				String data = "http://www.baidu.com";
				Uri uri = Uri.parse(data);
				intent.setAction(intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
			}
		});
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				String data = "tel:13321366513";
				Uri uri = Uri.parse(data);
				intent.setAction(intent.ACTION_DIAL);
				intent.setData(uri);
				startActivity(intent);
			}
		});
    }
}