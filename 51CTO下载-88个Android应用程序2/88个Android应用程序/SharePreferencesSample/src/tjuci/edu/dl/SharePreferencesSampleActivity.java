package tjuci.edu.dl;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreferencesSampleActivity extends Activity {
	SharedPreferences preferences;
	Button readBtn, writeBtn;
	Editor editor;
	EditText edit;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		preferences = getSharedPreferences("myPreference", MODE_PRIVATE);
		editor = preferences.edit();
		writeBtn = (Button)findViewById(R.id.write);
		readBtn = (Button)findViewById(R.id.read);
		edit = (EditText)findViewById(R.id.edit);
		writeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
				editor.putString("time", sdf.format(new Date()));
				editor.putInt("random", (int)(Math.random()*100));
				editor.commit();
			}
		});
		readBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String date = preferences.getString("time", null);
				int radom = preferences.getInt("random", 0);
				edit.setText(date + "  " + radom );
				Toast.makeText(SharePreferencesSampleActivity.this, "时间为:" + date + " 随机数:" + radom , Toast.LENGTH_SHORT).show();
			}
		});
	}
}