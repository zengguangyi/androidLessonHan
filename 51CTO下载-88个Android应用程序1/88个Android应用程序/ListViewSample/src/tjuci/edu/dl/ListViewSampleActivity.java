package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] str = {"aaaa","bbbbbb","cccccc","vvvvvvvv","ddd","ee"};
        ListView listView = (ListView)findViewById(R.id.lsitview);
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,str);
        listView.setAdapter(arrAdapter);
    }
}