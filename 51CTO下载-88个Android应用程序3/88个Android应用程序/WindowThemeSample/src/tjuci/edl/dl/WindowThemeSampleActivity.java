package tjuci.edl.dl;

import android.app.Activity;
import android.os.Bundle;

public class WindowThemeSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.style);
        setContentView(R.layout.main);
    }
}