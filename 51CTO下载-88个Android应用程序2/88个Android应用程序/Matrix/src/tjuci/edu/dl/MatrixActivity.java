package tjuci.edu.dl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MatrixActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyDraw(this));
	}
	class MyDraw extends View {
		Matrix m;
		// 图片的位相
		Bitmap b;
		// 位相的宽和高
		int width;
		int height;
		// 定义倾斜和缩放 true:缩放 false:倾斜
		boolean isScale;
		// 等比例缩放
		float scale = 1.0f;
		// 倾斜
		float kx = 0.0f;

		public MyDraw(Context context) {
			super(context);
			m = new Matrix();
			b = ((BitmapDrawable) this.getResources().getDrawable(
					R.drawable.q11)).getBitmap();
			width = b.getWidth();
			height = b.getHeight();
			// 使当前视图获得焦点
			this.setFocusable(true);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			m.reset();
			if (isScale) {
				// 缩放
				m.setScale(scale, scale);
			} else {
				// 倾斜
				m.setSkew(kx, 0);
			}
			Paint paint = new Paint();
			Bitmap b2 = Bitmap.createBitmap(b, 0, 0, width, height, m, true);
			canvas.drawBitmap(b2, m, paint);
		}
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_LEFT:
				isScale = false;
				kx -= 1;
				postInvalidate();
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				isScale = false;
				kx += 1;
				postInvalidate();
				break;
			case KeyEvent.KEYCODE_DPAD_UP:
				isScale = true;
				scale += 1;
				postInvalidate();
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				isScale = true;
				scale -= 1;
				postInvalidate();
				break;
			}
			return true;
		}

	}
}