package tjuci.edu.dl;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class show extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		@SuppressWarnings("unchecked")
		ArrayList<Map<String,String>> list = (ArrayList<Map<String, String>>) bundle.getSerializable("list");
		SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.line, new String[]{"word","detail"}, new int[]{R.id.showword,R.id.showdetail});
		ListView lv = (ListView)findViewById(R.id.lv);
		lv.setAdapter(sa);
	}
}
