package tjuci.edu.dl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MediaProviderSampleActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button seeBtn,addBtn;
        final ListView listView;
        final ArrayList<String> names = new ArrayList<String>();
        final ArrayList<String> desc = new ArrayList<String>();
        final ArrayList<String> fileNames = new ArrayList<String>();
        seeBtn = (Button)findViewById(R.id.see);
        addBtn = (Button)findViewById(R.id.add);
        listView = (ListView)findViewById(R.id.listView);
        seeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor cursor = getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, null, null, null);
				while(cursor.moveToNext()){
					names.add(cursor.getString(cursor.getColumnIndex(Media.DISPLAY_NAME)));
					desc.add(cursor.getString(cursor.getColumnIndex(Media.DESCRIPTION)));
					byte[] data = cursor.getBlob(cursor.getColumnIndex(Media.DATA));
					fileNames.add(new String(data,0,data.length-1));
				}
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
if(names.size() == 0 || names == null){
	Toast.makeText(MediaProviderSampleActivity.this, "暂时没有图片", Toast.LENGTH_SHORT).show();
}
				for(int i = 0; i < names.size(); i ++ ){
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("name", names.get(i));
					map.put("desc", desc.get(i));
					list.add(map);
				}
				SimpleAdapter sa = new SimpleAdapter(MediaProviderSampleActivity.this, list, R.layout.line, new String[]{"name","desc"}, new int[]{R.id.name,R.id.desc});
				listView.setAdapter(sa);
			}
		});
        addBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put(Media.DISPLAY_NAME, "jinta");
				values.put(Media.DESCRIPTION, "金塔");
				values.put(Media.MIME_TYPE, "image/jpeg");
				Uri uri = getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, values);
				Bitmap bitmap = BitmapFactory.decodeResource(MediaProviderSampleActivity.this.getResources(), R.drawable.jinta);
				OutputStream os = null;
				try {
					os = getContentResolver().openOutputStream(uri);
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100,os);
					os.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    }
}