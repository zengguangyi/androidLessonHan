package tjuci.edu.dl;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PlanGameActivity extends Activity {
	//����ɻ��ٶ�
	float speed = 10;
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //���ô���û�б���
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //����ȫ��
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlanView pView = new PlanView(this);
        setContentView(pView);
        pView.setBackgroundColor(Color.WHITE);
        //ͨ�����ڹ������õ�Display �Ӷ��õ���͸�
        WindowManager wm = this.getWindowManager();
        Display display = wm.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();
        //���÷ɻ��ĳ�ʼλ��
        pView.currentx = screenWidth/2;
        pView.currenty = screenHeight - 100;
        //���ü�����
        pView.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_DPAD_UP:
					pView.currenty -= speed;
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					pView.currenty += speed;
					break;
				case KeyEvent.KEYCODE_DPAD_LEFT:
					pView.currentx -= speed;
					break;
				case KeyEvent.KEYCODE_DPAD_RIGHT:
					pView.currentx += speed;
					break;
				default:
					break;
				}
				//����invalidate()����  �Ӷ��ص�onDraw()����
				pView.invalidate();
				return true;
			}
		});
    }
}