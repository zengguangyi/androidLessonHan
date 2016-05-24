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
        //�õ����Բ��ֵ�����
        LinearLayout layout =(LinearLayout)findViewById(R.id.root);
        //�������Զ����View
        final MyView myView = new MyView(this);//thisָ������
        //�����Զ����齨������Ⱥ����߶�
        myView.setMinimumHeight(300);
        myView.setMinimumWidth(300);
        myView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//����λ��
				myView.current_x = (int)event.getX();
				myView.current_y = (int)event.getY();
				//����λ��֮��ʼ���»�
				myView.invalidate();
				//����true������Ѿ������˱��¼�
				return true;
			}
		});
        layout.addView(myView);
    }
}