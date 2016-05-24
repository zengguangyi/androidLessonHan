package tjuci.edu.dl;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MoveBackgroundSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class MyView extends View{
    	Bitmap b ;
    	//记录背景位图的实际高度
    	int back_height ;
    	//图片开始的位置
    	int width;
    	final int height = 20;
    	private int startY = back_height - height ;
		public MyView(Context context) {
			super(context);
			b = BitmapFactory.decodeResource(context.getResources(), R.drawable.q10);
			back_height = b.getHeight();
			width = b.getWidth();
			final Handler h = new Handler(){
				@Override
				public void handleMessage(Message msg) {
					if(msg.what == 0x123){
						if(startY <= 3){
							startY = back_height - height;
						}else{
							startY -= 3;
						}
					}
					invalidate();
				}
			};
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					h.sendEmptyMessage(0x123);
				}
			}, 0,100);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			Bitmap b2 = Bitmap.createBitmap(b, 0, startY, width, height);
			canvas.drawBitmap(b2, 0, 0, null);
		}
    }
}