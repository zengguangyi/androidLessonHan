package tjuci.edu.dl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class First extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("第一个Activity", "我是FirstActivity");
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				ComponentName com = new ComponentName(First.this, Second.class);
				intent.setComponent(com);
				startActivity(intent);
				
				//上述代码可写为 
				//Intent intent = new Intent(First.this, Second.class);
				//startActivity(intent);
			}
		});
    }
}