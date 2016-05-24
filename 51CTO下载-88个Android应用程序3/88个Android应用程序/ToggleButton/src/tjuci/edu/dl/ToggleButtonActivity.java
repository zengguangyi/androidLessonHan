package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ToggleButton tb = (ToggleButton)findViewById(R.id.tb);
        final LinearLayout ll =(LinearLayout)findViewById(R.id.l2);
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					ll.setOrientation(1);
				}else{
					ll.setOrientation(0);
					}
			}
		});
    }
}