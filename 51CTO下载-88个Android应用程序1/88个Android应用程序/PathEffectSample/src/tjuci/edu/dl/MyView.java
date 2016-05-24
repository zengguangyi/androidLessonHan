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
	// phase����ǰ������˼
	float phase;

	public MyView(Context context) {
		super(context);
		// ��������
		path = new Path();
		// ������ɫ
		colors = new int[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.RED,
				Color.GREEN, Color.YELLOW, Color.MAGENTA };
		// ������ʼλ��Ϊ(0,0)
		path.moveTo(10, 10);
		// ����·������Ҫ�����ĵ� (15����)
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
		// ���廭��Ϊ��ɫ
		canvas.drawColor(Color.WHITE);
		pe[0] = null;
		// ��PathEffectΪԲ���Ļ���
		pe[1] = new CornerPathEffect(10);
		// ��ɢ����
		// ��һ������Ϊ��ɢ�ڻ��ϵļ��
		// �ڶ�������Ϊ��ɢ�ĳ̶�
		pe[2] = new DiscretePathEffect(3, 10);
		// DashΪ���ۺŵ���˼�� Ӧ����������
		// ���е�һ��������new float[]{} ��ʾ���еļ���;���
		// phase��ʾ��λ
		pe[3] = new DashPathEffect(new float[] { 20, 5, 5, 20 }, phase);
		//�Ƚ���һ��Path Ȼ�󴴽�PathDashPathEffect����  ����pΪpath
		Path p = new Path();
		p.addRect(0,0,8,8,Path.Direction.CW);
		pe[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
		//�˷�����ʾ������ϵ�PathEffect
		pe[5] = new ComposePathEffect(pe[2], pe[4]);
		//�����pe[5]����
		pe[6] = new SumPathEffect(pe[4], pe[3]);
		// ��ʼ��������
		for (int i = 0; i < pe.length; i++) {
			// ���û��paint.setPathEffect(),��ôϵͳĬ��Ϊpaint.setPathEffect(null);
			paint.setPathEffect(pe[i]);
			paint.setColor(colors[i]);
			canvas.drawPath(path, paint);
			//ʹ����ƽ��(0,60)
			canvas.translate(0, 60);
		}
		phase++;
		invalidate();
	}
}
