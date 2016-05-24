package tjuci.edu.dl;

import tjuci.edu.dl.customview.MyView;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class TouchCircleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //得到线性布局的容器
        LinearLayout layout =(LinearLayout)findViewById(R.id.root);
        //创建出自定义的View
        final MyView myView = new MyView(this);//this指上下文
        //设置自定义组建的最大宽度和最大高度
        myView.setMinimumHeight(300);
        myView.setMinimumWidth(300);
        myView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//设置位置
				myView.current_x = (int)event.getX();
				myView.current_y = (int)event.getY();
				//设置位置之后开始重新画
				myView.invalidate();
				//返回true则表明已经处理了本事件
				return true;
			}
		});
        layout.addView(myView);
    }
}