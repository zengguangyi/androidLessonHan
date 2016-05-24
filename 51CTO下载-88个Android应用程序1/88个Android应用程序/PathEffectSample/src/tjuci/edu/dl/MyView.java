package tjuci.edu.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.view.View;

public class MyView extends View {
	PathEffect[] pe = new PathEffect[7];
	int[] colors;
	Path path;
	Paint paint;
	// phase是逐步前进的意思
	float phase;

	public MyView(Context context) {
		super(context);
		// 创建画笔
		path = new Path();
		// 定义颜色
		colors = new int[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.RED,
				Color.GREEN, Color.YELLOW, Color.MAGENTA };
		// 定义起始位置为(0,0)
		path.moveTo(10, 10);
		// 定义路径中需要经过的点 (15个点)
		for (int i = 0; i < 15; i++) {
			path.lineTo(10 + i * 20, 10 +(int) (Math.random() * 60));
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint = new Paint();
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(4);
		// 定义画板为白色
		canvas.drawColor(Color.WHITE);
		pe[0] = null;
		// 此PathEffect为圆滑的弧形
		pe[1] = new CornerPathEffect(10);
		// 离散的线
		// 第一个参数为离散在弧上的间距
		// 第二个参数为离散的程度
		pe[2] = new DiscretePathEffect(3, 10);
		// Dash为破折号的意思。 应该是破这行
		// 其中第一个参数是new float[]{} 表示其中的间隔和距离
		// phase表示相位
		pe[3] = new DashPathEffect(new float[] { 20, 5, 5, 20 }, phase);
		//先建立一个Path 然后创建PathDashPathEffect对象  其中p为path
		Path p = new Path();
		p.addRect(0,0,8,8,Path.Direction.CW);
		pe[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
		//此方法表示两个组合的PathEffect
		pe[5] = new ComposePathEffect(pe[2], pe[4]);
		//结果和pe[5]类似
		pe[6] = new SumPathEffect(pe[4], pe[3]);
		// 开始画七条线
		for (int i = 0; i < pe.length; i++) {
			// 如果没有paint.setPathEffect(),那么系统默认为paint.setPathEffect(null);
			paint.setPathEffect(pe[i]);
			paint.setColor(colors[i]);
			canvas.drawPath(path, paint);
			//使画板平移(0,60)
			canvas.translate(0, 60);
		}
		phase++;
		invalidate();
	}
}
