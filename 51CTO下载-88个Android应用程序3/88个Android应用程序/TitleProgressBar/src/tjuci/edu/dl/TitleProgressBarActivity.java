package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class TitleProgressBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.main);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 setProgressBarVisibility(true);
			     setProgressBarIndeterminateVisibility(true);
			}
		});
        btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 setProgressBarVisibility(false);
			     setProgressBarIndeterminateVisibility(false);
			}
		});
    }
}