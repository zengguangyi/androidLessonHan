package tjuci.edu.dl;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/***
 * 做动态桌面   触屏移动时  有圈
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
		//初始化 画笔
		Paint paint;
		//定义触屏位置
		float x;
		float y;
		//圈的半径
		int r = 10;
		SurfaceHolder sh;
		//定义一个Handler
		Handler handler  = new Handler();
		Runnable runable = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				drawFrame();
			}
		};
		
		//在初始化Engine时被调用
		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			paint = new Paint();
			paint.setColor(Color.RED);
			paint.setStrokeWidth(2);
			paint.setStyle(Paint.Style.STROKE);
			//使用触屏
			setTouchEventsEnabled(true);
		}
		@Override
		public void onDestroy() {
			super.onDestroy();
			handler.removeCallbacks(runable);
		}
		
		//当可见度改变时被调用
		@Override
		public void onVisibilityChanged(boolean visible) {
				if(visible){
					drawFrame();
				}else{
					handler.removeCallbacks(runable);
				}
		}

		//当触屏时被回调
		@Override
		public void onTouchEvent(MotionEvent event) {
			//移动时调用
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
		
		//画圈
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