package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class MenuItemSampleActivity extends Activity {
	// 喜欢的颜色
	final int COLOR_RED = 0x11;
	final int COLOR_BLACK = 0x12;
	final int COLOR_YELLOW = 0x13;

	// 3中颜色的数组
	MenuItem m[] = new MenuItem[3];

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	// 创建菜单项
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		SubMenu m1 = menu.addSubMenu("你喜欢的颜色");
		m[0] = m1.add(0, COLOR_RED, 1, "红色").setChecked(true);
		m[1] = m1.add(0, COLOR_BLACK, 2, "黑色").setChecked(true);
		m[2] = m1.add(0, COLOR_YELLOW, 3, "黄色").setChecked(true);
		m[1].setAlphabeticShortcut('o');
		return super.onCreateOptionsMenu(menu);
	}

	// 在菜单被选时调用此方法
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case COLOR_RED:
			if(item.isChecked()){
				item.setChecked(false);
			}else{
				item.setChecked(true);
			}
			show();
			break;
		case COLOR_BLACK:
			if(item.isChecked()){
				item.setChecked(false);
			}else{
				item.setChecked(true);
			}
			show();
			break;
		case COLOR_YELLOW:
			if(item.isChecked()){
				item.setChecked(false);
			}else{
				item.setChecked(true);
			}
			show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	private void show() {
		// TODO Auto-generated method stub
		TextView tView = (TextView)findViewById(R.id.tView);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m.length; i ++){
			if(m[i].isChecked()){
				sb.append(m[i] + "/");
			}
		}
		tView.setText("你喜欢的颜色是 " + sb.toString());
	}
}