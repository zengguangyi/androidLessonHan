package tjuci.edu.dl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlanView extends View {

	// 飞机的位置
	public float currentx;
	public float currenty;
	// 定义分级的位图图片
	Bitmap plan;

	public PlanView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		plan = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.plan);
		setFocusable(true);
	}

	// 重写onDraw 此方法在调用invalidate()以后被调用
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
				super.onDraw(canvas);
		Paint p = new Paint();
		canvas.drawBitmap(plan, currentx, currenty, p);
		
	}
}
