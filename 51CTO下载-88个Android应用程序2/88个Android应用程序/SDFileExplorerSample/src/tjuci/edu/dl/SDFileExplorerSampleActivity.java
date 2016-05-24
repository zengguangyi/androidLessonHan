package tjuci.edu.dl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SDFileExplorerSampleActivity extends Activity {
	ListView listView;
	Button btn;
	TextView tv;
	// 当前路径文件
	File parentFile;
	// 当前路径的所有子文件
	File[] childFile;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 得到所有组件
		listView = (ListView) findViewById(R.id.listView);
		btn = (Button) findViewById(R.id.upPageBtn);
		tv = (TextView) findViewById(R.id.parentPath);
		// sdcard路径
		File root = new File("/mnt/sdcard/");
		if (root.exists()) {// 是否存在sdcard
			parentFile = root;
			childFile = root.listFiles();
			inflateListView(childFile);
		}
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				if(childFile[position].isFile()){//是文件: true
					return;
				}else{
					File[] temp = childFile[position].listFiles();
					if(temp == null || temp.length == 0){
						Toast.makeText(SDFileExplorerSampleActivity.this,"文件夹是空的",Toast.LENGTH_SHORT).show();
					}else{
						parentFile = childFile[position];
						childFile = temp;
						inflateListView(childFile);
					}
				}
			}
		});
		//上一页
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if((parentFile.getName()).equals("/mnt/sdcard")){
					Toast.makeText(SDFileExplorerSampleActivity.this, "当前为第一页", Toast.LENGTH_SHORT).show();
				}else{
					parentFile = parentFile.getParentFile();
					childFile = parentFile.listFiles();
					inflateListView(childFile);
				}
			}
		});
	}
	
	/***
	 * 
	 * @param file
	 *            所有子文件的数组
	 */
	public void inflateListView(File[] files) {
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < files.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (files[i].isDirectory()) {// 文件时文件夹 : true
				map.put("icon", R.drawable.folder);
			} else {
				map.put("icon", R.drawable.file);
			}
			map.put("fileName", files[i].getName());
			lists.add(map);
		}
		SimpleAdapter sa = new SimpleAdapter(SDFileExplorerSampleActivity.this,
				lists, R.layout.mylist, new String[] { "icon", "fileName" },
				new int[] { R.id.iv1, R.id.tv1 });
		listView.setAdapter(sa);
		try {
			tv.setText("当前路径："+parentFile.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}