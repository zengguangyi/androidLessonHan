package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

public class ListViewTweenSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView)findViewById(R.id.listView);
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        int width = d.getWidth();
        int height = d.getHeight();
        listView.setAnimation(new MyAnimation(width/2, height/2, 3500));
    }
}