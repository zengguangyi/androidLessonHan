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
	//此方法重画时调用
	@Override
	protected void onDraw(Canvas canvas) {
		//canvas可以看做画板
		super.onDraw(canvas);
		//创建画笔
		Paint p = new Paint();
		p.setColor(Color.RED);
		canvas.drawCircle(current_x, current_y, 5, p);
	}


}
