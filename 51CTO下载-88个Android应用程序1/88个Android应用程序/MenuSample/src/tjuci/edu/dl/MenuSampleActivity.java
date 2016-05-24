package tjuci.edu.dl;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MenuSampleActivity extends Activity {

	// 定义字体大小标示符
	final int FONT_2 = 0x112;
	final int FONT_4 = 0x113;
	final int FONT_10 = 0x114;
	final int FONT_12 = 0x115;
	final int FONT_16 = 0x116;
	// 定义普通菜单标示符
	final int NORMAL = 0x111b;
	// 定义颜色的标示符
	final int FONT_RED = 0x123;
	final int FONT_GREEN = 0x124;
	final int FONT_YELLOW = 0x125;
	EditText edit;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		edit = (EditText) findViewById(R.id.editText);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 添加字体大小的子菜单
		SubMenu sub = menu.addSubMenu("字体大小");
		sub.setIcon(R.drawable.q1);
		sub.setHeaderIcon(R.drawable.q1);
		sub.setHeaderTitle("选择字体大小");
		sub.add(0, FONT_2, 0, "2号字体");
		sub.add(0, FONT_4, 1, "4号字体");
		sub.add(0, FONT_10, 2, "10号字体");
		sub.add(0, FONT_16, 3, "16号字体");
		sub.add(0, FONT_12, 4, "12号字体");

		// 添加谱图菜单
		menu.add(0, NORMAL, 0, "普通菜单");

		// 添加字体颜色的菜单
		SubMenu sub2 = menu.addSubMenu("字体颜色");
		sub2.setIcon(R.drawable.q2);
		sub2.setHeaderIcon(R.drawable.q2);
		sub2.setHeaderTitle("选择字体颜色");
		sub2.add(0, FONT_GREEN, 0, "绿色");
		sub2.add(0, FONT_RED, 1, "红色");
		sub2.add(0, FONT_YELLOW, 2, "黄色");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case FONT_2:
			edit.setTextSize(2 * 2);
			break;
		case FONT_4:
			edit.setTextSize(4 * 2);
			break;
		case FONT_10:
			edit.setTextSize(10 * 2);
			break;
		case FONT_12:
			edit.setTextSize(12 * 2);
			break;
		case FONT_16:
			edit.setTextSize(16 * 2);
			break;
		case NORMAL:
			Toast.makeText(MenuSampleActivity.this, "选择了普通菜单",
					Toast.LENGTH_SHORT).show();
			break;
		case FONT_GREEN:
			edit.setTextColor(Color.GREEN);
			break;
		case FONT_RED:
			edit.setTextColor(Color.RED);
			break;
		case FONT_YELLOW:
			edit.setTextColor(Color.YELLOW);
			break;
		}
		return true;
	}

}