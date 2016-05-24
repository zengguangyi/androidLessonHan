package tjuci.edu.dl;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostSampleActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost th = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.main, th.getTabContentView(), true);
        th.addTab(th.newTabSpec("tab1").setIndicator("已接电话").setContent(R.id.tab1));
        th.addTab(th.newTabSpec("tab2").setIndicator("未接电话").setContent(R.id.tab2));
        th.addTab(th.newTabSpec("tab3").setIndicator("已拨电话").setContent(R.id.tab3));
    }
}