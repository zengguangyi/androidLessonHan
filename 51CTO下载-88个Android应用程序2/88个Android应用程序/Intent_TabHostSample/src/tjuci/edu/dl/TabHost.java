package tjuci.edu.dl;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class TabHost extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.widget.TabHost tHost = getTabHost();
        tHost.addTab(tHost.newTabSpec("tab1").setIndicator("11111").setContent(new Intent(this,One.class)));
        tHost.addTab(tHost.newTabSpec("tab2").setIndicator("22222").setContent(new Intent(this,Two.class)));
        tHost.addTab(tHost.newTabSpec("tab3").setIndicator("33333").setContent(new Intent(this,Three.class)));
    }
}