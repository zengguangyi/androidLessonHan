package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class MenuItemSampleActivity extends Activity {
	// ϲ������ɫ
	final int COLOR_RED = 0x11;
	final int COLOR_BLACK = 0x12;
	final int COLOR_YELLOW = 0x13;

	// 3����ɫ������
	MenuItem m[] = new MenuItem[3];

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	// �����˵���
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		SubMenu m1 = menu.addSubMenu("��ϲ������ɫ");
		m[0] = m1.add(0, COLOR_RED, 1, "��ɫ").setChecked(true);
		m[1] = m1.add(0, COLOR_BLACK, 2, "��ɫ").setChecked(true);
		m[2] = m1.add(0, COLOR_YELLOW, 3, "��ɫ").setChecked(true);
		m[1].setAlphabeticShortcut('o');
		return super.onCreateOptionsMenu(menu);
	}

	// �ڲ˵���ѡʱ���ô˷���
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
		tView.setText("��ϲ������ɫ�� " + sb.toString());
	}
}