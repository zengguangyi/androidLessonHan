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
	//定义飞机速度
	float speed = 10;
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlanView pView = new PlanView(this);
        setContentView(pView);
        pView.setBackgroundColor(Color.WHITE);
        //通过窗口管理器得到Display 从而得到宽和高
        WindowManager wm = this.getWindowManager();
        Display display = wm.getDefaultDisplay();
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();
        //设置飞机的初始位置
        pView.currentx = screenWidth/2;
        pView.currenty = screenHeight - 100;
        //设置监听器
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
				//调用invalidate()方法  从而回调onDraw()方法
				pView.invalidate();
				return true;
			}
		});
    }
}