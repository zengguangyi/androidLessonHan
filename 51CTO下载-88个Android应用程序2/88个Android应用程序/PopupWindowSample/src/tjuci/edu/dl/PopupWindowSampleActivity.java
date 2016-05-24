package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupWindowSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View root = this.getLayoutInflater().inflate(R.layout.root, null);
        final PopupWindow pWindow = new PopupWindow(root,280,360);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pWindow.showAsDropDown(v);
				pWindow.showAtLocation(findViewById(R.id.btn), Gravity.CENTER, 20, 20)
				;
			}
		});
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pWindow.dismiss();
			}
		});
    }
}