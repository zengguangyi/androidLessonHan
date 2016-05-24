package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class XmlValuesSampleActivity extends Activity {
	//定义颜色中的文字
	private String[] words;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //注：定义数组的元素  应该在onCreate方法内进行   不能再外面
        //根据Activity的生命周期可知：onCreate方法在创造Activity时 被调用
        words = XmlValuesSampleActivity.this.getResources().getStringArray(R.array.words);
        BaseAdapter ba = new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView tv = new TextView(XmlValuesSampleActivity.this);
				tv.setWidth((int) XmlValuesSampleActivity.this.getResources().getDimension(R.dimen.cell_width));
				tv.setHeight((int)XmlValuesSampleActivity.this.getResources().getDimension(R.dimen.cell_height));
				tv.setText(words[position]);
				tv.setBackgroundDrawable((XmlValuesSampleActivity.this.getResources().obtainTypedArray(R.array.colors)).getDrawable(position));
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
				return words[position];
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