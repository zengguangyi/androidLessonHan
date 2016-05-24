package tjuci.edu.dl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dict extends Activity {
	EditText wordEdit,detailEdit,seachWordEdit;
	Button addWordBtn,seachWordBtn;
	MyDB mydb;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        wordEdit = (EditText)findViewById(R.id.wordedit);
        detailEdit = (EditText)findViewById(R.id.detailedit);
        seachWordEdit = (EditText)findViewById(R.id.seachwordedit);
        addWordBtn = (Button)findViewById(R.id.addwordbtn);
        seachWordBtn = (Button)findViewById(R.id.seachbtn);
        mydb = new MyDB(this, "mydb1.db3", 1);
        //ÃÌº”¥ ª„
        addWordBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inflateInsert(mydb.getReadableDatabase(),wordEdit.getText().toString(),detailEdit.getText().toString());
			}
		});
        //≤È’“¥ ª„
        seachWordBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//≤È—Øµƒsql
				String querySql = "select * from mydb where word like ?";
				Cursor cursor = mydb.getWritableDatabase().rawQuery(querySql, new String[]{
						"%"+seachWordEdit.getText().toString() + "%"
				});
				ArrayList<Map<String,String>> list = converCursortoList(cursor);
				Intent intent = new Intent(Dict.this, show.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("list", list);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
    }
    public void inflateInsert(SQLiteDatabase db, String word,String detail){
    	String insertSql = "insert into mydb(_id,word,detail) values(null,?,?)";
    	db.execSQL(insertSql, new String[]{word,detail});
    }
    public ArrayList<Map<String,String>> converCursortoList(Cursor cursor){
    	ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	while(cursor.moveToNext()){
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("word", cursor.getString(1));
    		map.put("detail", cursor.getString(2));
    		list.add(map);
    	}
    	return list;
    }
}