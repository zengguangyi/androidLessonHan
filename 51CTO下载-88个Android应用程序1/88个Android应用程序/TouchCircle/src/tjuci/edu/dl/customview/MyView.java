package tjuci.edu.dl.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

	public int current_x = 0;
	public int current_y = 0;
	public MyView(Context context) {
		super(context);
	}
	//�˷����ػ�ʱ����
	@Override
	protected void onDraw(Canvas canvas) {
		//canvas���Կ�������
		super.onDraw(canvas);
		//��������
		Paint p = new Paint();
		p.setColor(Color.RED);
		canvas.drawCircle(current_x, current_y, 5, p);
	}


}
