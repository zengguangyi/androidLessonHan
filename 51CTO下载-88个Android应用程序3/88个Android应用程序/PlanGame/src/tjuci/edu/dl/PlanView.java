package tjuci.edu.dl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlanView extends View {

	// �ɻ���λ��
	public float currentx;
	public float currenty;
	// ����ּ���λͼͼƬ
	Bitmap plan;

	public PlanView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		plan = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.plan);
		setFocusable(true);
	}

	// ��дonDraw �˷����ڵ���invalidate()�Ժ󱻵���
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
				super.onDraw(canvas);
		Paint p = new Paint();
		canvas.drawBitmap(plan, currentx, currenty, p);
		
	}
}
