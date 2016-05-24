package tjuci.edu.dl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterSampleActivity extends Activity {
	/** Called when the activity is first created. */
	private String[] name = { "小明", "小红", "小李", "小王", "小张" };
	private int[] imageId = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listview);
		List<Map<String, Object>> list_map = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < name.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", name[i]);
			map.put("imageId", imageId[i]);
			list_map.add(map);
		}
		SimpleAdapter sa = new SimpleAdapter(this, list_map, R.layout.main,
				new String[] { "name", "imageId" }, new int[] { R.id.textView,
						R.id.imageView });
		listView.setAdapter(sa);
	}
}