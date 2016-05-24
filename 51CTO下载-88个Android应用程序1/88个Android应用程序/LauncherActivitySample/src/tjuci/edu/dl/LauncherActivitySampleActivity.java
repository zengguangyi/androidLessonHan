package tjuci.edu.dl;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class LauncherActivitySampleActivity extends LauncherActivity {
	
	String[] names= {"设置程序参数","查看星际兵种"};
	//定义两个Activity
	Class<?>[] clazzs = {PreferenceActivity.class,ExpandableListActivity.class};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        this.setListAdapter(adapter);
    }
    @Override
	protected Intent intentForPosition(int position) {
		// TODO Auto-generated method stub
		return new Intent(this, clazzs[position]);
	}
}