package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerSample2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BaseAdapter ba = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView tv = new TextView(SpinnerSample2Activity.this);
				tv.setText(position + "");
				tv.setTextSize(20);
				return tv;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// 一共有几个选项
				return 10;
			}
		};
		Spinner s = (Spinner)findViewById(R.id.spinner);
		s.setAdapter(ba);
    }
}