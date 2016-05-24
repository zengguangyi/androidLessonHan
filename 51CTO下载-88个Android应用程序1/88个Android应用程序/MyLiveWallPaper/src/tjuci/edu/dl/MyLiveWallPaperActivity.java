package tjuci.edu.dl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/***
 * ����̬����   �����ƶ�ʱ  ��Ȧ
 * @author admin
 *
 */
public class MyLiveWallPaperActivity extends WallpaperService {
	@Override
	public Engine onCreateEngine() {
		// TODO Auto-generated method stub
		return new MyEngine();
	}
	class MyEngine extends Engine{
		//��ʼ�� ����
		Paint paint;
		//���崥��λ��
		float x;
		float y;
		//Ȧ�İ뾶
		int r = 10;
		SurfaceHolder sh;
		//����һ��Handler
		Handler handler  = new Handler();
		Runnable runable = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				drawFrame();
			}
		};
		
		//�ڳ�ʼ��Engineʱ������
		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			paint = new Paint();
			paint.setColor(Color.RED);
			paint.setStrokeWidth(2);
			paint.setStyle(Paint.Style.STROKE);
			//ʹ�ô���
			setTouchEventsEnabled(true);
		}
		@Override
		public void onDestroy() {
			super.onDestroy();
			handler.removeCallbacks(runable);
		}
		
		//���ɼ��ȸı�ʱ������
		@Override
		public void onVisibilityChanged(boolean visible) {
				if(visible){
					drawFrame();
				}else{
					handler.removeCallbacks(runable);
				}
		}

		//������ʱ���ص�
		@Override
		public void onTouchEvent(MotionEvent event) {
			//�ƶ�ʱ����
			if(event.getAction() == MotionEvent.ACTION_MOVE){
				x = event.getX();
				y = event.getY();
			}
			super.onTouchEvent(event);
		}
		
		@Override
		public void onOffsetsChanged(float xOffset, float yOffset,
				float xOffsetStep, float yOffsetStep, int xPixelOffset,
				int yPixelOffset) {
			drawFrame();
		}
		
		//��Ȧ
		public void drawFrame(){
			Canvas canvas = null;
			sh = getSurfaceHolder();
			canvas = sh.lockCanvas();
			canvas.save();
			canvas.drawCircle(x, y, r, paint);
			canvas.restore();
			sh.unlockCanvasAndPost(canvas);
			handler.removeCallbacks(runable);
			handler.postDelayed(runable, 100);
		}
	}
}