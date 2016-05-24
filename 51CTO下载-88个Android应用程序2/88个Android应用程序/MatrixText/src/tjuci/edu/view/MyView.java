package tjuci.edu.view;

import tjuci.edu.dl.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
	Bitmap bitmap;
	Paint paint;
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q7);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setAntiAlias(true);
		paint.setColor(Color.RED);
		paint.setTextSize(15);
		canvas.drawBitmap(bitmap, 10, 10, paint);
		canvas.save();
		Matrix m1 = new Matrix();
		m1.setTranslate(500, 10);
		Matrix m2 = new Matrix();
		m2.setRotate(15);
		Matrix m3 = new Matrix();
		m3.setConcat(m1, m2);
		m1.setScale(0.8f, 0.8f);
		m2.setConcat(m1, m3);
		canvas.drawBitmap(bitmap, m2, paint);
		canvas.restore();
		canvas.save();
		paint.setAlpha(180);
		m1.setTranslate(200, 100);
		m2.setScale(1.3f, 1.3f);
		m3.setConcat(m2, m1);
		canvas.drawBitmap(bitmap, m3, paint);
		paint.reset();
		canvas.restore();
		paint.setTextSize(40);
		canvas.drawText("图片的宽度 "+ bitmap.getWidth(), 20, 220, paint);
		canvas.drawText("图片的高度 "+ bitmap.getHeight(), 150, 220, paint);
		paint.reset();
	}
}
