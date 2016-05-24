package tjuci.edu.dl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class LogicAlertDialogSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Builder b = new AlertDialog.Builder(this);
        Button mainBtn = (Button)findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TableLayout tl = (TableLayout)getLayoutInflater().inflate(R.layout.log, null);
				b.setView(tl);
				b.setNegativeButton("µÇÂ½", null);
				b.setPositiveButton("È¡Ïû", null);
				 b.create().show();
			}
		});
       
    }
}