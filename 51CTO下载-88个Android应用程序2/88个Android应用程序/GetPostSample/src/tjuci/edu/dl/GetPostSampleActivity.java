package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GetPostSampleActivity extends Activity {
	Button get,post;
	EditText show;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        get = (Button)findViewById(R.id.getBtn);
        post = (Button)findViewById(R.id.postBtn);
        show = (EditText)findViewById(R.id.editText);
        get.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				show.setText(GetPostUtils.sendGet("http://www.taobao.com", null));
			}
		});
        post.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				show.setText(GetPostUtils.sendPost("http://www.taobao.com", null));
			}
		});
    }
}