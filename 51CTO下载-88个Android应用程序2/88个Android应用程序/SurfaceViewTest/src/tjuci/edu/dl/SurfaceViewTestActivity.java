package tjuci.edu.dl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SurfaceView sv = (SurfaceView)findViewById(R.id.sv);
        final SurfaceHolder sh= sv.getHolder();
        final Paint paint = new Paint();
        sh.addCallback(new Callback() {
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
			}
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				Canvas canvas = sh.lockCanvas();
				Bitmap b = BitmapFactory.decodeResource(SurfaceViewTestActivity.this.getResources(), R.drawable.sun);
				canvas.drawBitmap(b, 0, 0, null);
				sh.unlockCanvasAndPost(canvas);
				sh.lockCanvas(new Rect(0, 0, 0, 0));
				sh.unlockCanvasAndPost(canvas);
			}
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
			}
		});
        sv.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN){
					int x = (int) event.getX();
					int y = (int) event.getY();
					paint.setColor(Color.RED);
					Canvas canvas = sh.lockCanvas(new Rect(x-50, y-50, x+50, y+50));
//					canvas.save();
					canvas.rotate(30, x, y);
					canvas.drawRect(x-40, y-40, x, y, paint);
//					canvas.restore();
					paint.setColor(Color.GREEN);
					canvas.drawRect(x, y, x+40, y+40, paint);
					sh.unlockCanvasAndPost(canvas);
					sh.lockCanvas(new Rect(0, 0, 0, 0));
					sh.unlockCanvasAndPost(canvas);
				}
				return false;
			}
		});
    }
}