package tjuci.edu.dl;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SQLiteSampleActivity extends Activity {
	EditText title, content;
	ListView listView;
	Button btn;
	SQLiteDatabase db = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		title = (EditText) findViewById(R.id.title);
		content = (EditText) findViewById(R.id.content);
		listView = (ListView) findViewById(R.id.listView);
		btn = (Button) findViewById(R.id.btn);
		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/my.db3",
				null);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					// TODO Auto-generated method stub
					insertData(db, title.getText().toString(), content
							.getText().toString());
					Cursor cursor = db.rawQuery("select * from mydb", null);// ��ѯ�Ľ����
																			// ---����ResultSet
					inflateCursor(cursor);
				} catch (Exception e) {
					db.execSQL("create table mydb(_id integer primary key autoincrement,title varchar(255),content varchar(255))");
					insertData(db, title.getText().toString(), content
							.getText().toString());
					Cursor cursor = db.rawQuery("select * from mydb", null);// ��ѯ�Ľ����
																			// ---����ResultSet
					inflateCursor(cursor);
				}
			}
		});
	}

	public void insertData(SQLiteDatabase db, String title, String content) {
		db.execSQL("insert into mydb(_id,title,content) values(null,?,?)",
				new String[] { title, content });
	}

	public void inflateCursor(Cursor cursor) {
		SimpleCursorAdapter sca = new SimpleCursorAdapter(this, R.layout.line,
				cursor, new String[] { "title", "content" }, new int[] {
						R.id.tv1, R.id.tv2 });
		listView.setAdapter(sca);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(db != null && db.isOpen()){
			db.close();
		}
	}
}