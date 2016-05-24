package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class XmlValuesSampleActivity extends Activity {
	//定义颜色
	private int[] colors = {
		R.color.c1,	
		R.color.c2,	
		R.color.c3,	
		R.color.c4,	
		R.color.c5,	
		R.color.c6,	
		R.color.c7,	
		R.color.c8,	
		R.color.c9
	};
	//定义颜色中的文字
	private int[] words = {
		R.string.s1,
		R.string.s2,
		R.string.s3,
		R.string.s4,
		R.string.s5,
		R.string.s6,
		R.string.s7,
		R.string.s8,
		R.string.s9
	};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BaseAdapter ba = new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView tv = new TextView(XmlValuesSampleActivity.this);
				tv.setWidth((int) XmlValuesSampleActivity.this.getResources().getDimension(R.dimen.cell_width));
				tv.setHeight((int)XmlValuesSampleActivity.this.getResources().getDimension(R.dimen.cell_height));
				tv.setText(words[position]);
				tv.setBackgroundColor(getResources().getColor(colors[position]));
				tv.setTextSize(20);
				return tv;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return words.length;
			}
		};
		GridView gv = (GridView)findViewById(R.id.gView);
		gv.setAdapter(ba);
    }
}