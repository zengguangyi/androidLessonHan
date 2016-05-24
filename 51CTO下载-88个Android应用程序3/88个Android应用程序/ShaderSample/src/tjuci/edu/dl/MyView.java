package tjuci.edu.dl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
	Bitmap b;
	Paint paint ;
	Shader shader;
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		b = BitmapFactory.decodeResource(getResources(), R.drawable.q7);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		//位图
//		shader = new BitmapShader(b, TileMode.REPEAT, TileMode.MIRROR);
		//线性
		int[] colors = new int[]{
				Color.RED,Color.GREEN,Color.BLUE
		};
//		shader = new LinearGradient(0, 0, 100, 100, colors, null, TileMode.REPEAT);
		//圆形渐变
//		shader = new RadialGradient(100, 100, 80, colors, null, TileMode.REPEAT);
		//角度渐变
//		shader = new SweepGradient(160, 160, colors, null);
		//混合渐变
		Shader shader1 = new LinearGradient(0, 0, 100, 100, colors, null, TileMode.REPEAT);
		Shader shader2 = new RadialGradient(100, 100, 80, colors, null, TileMode.REPEAT);
		shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DARKEN);
		paint = new Paint();
		paint.setShader(shader);
		paint.setColor(Color.BLUE);
		canvas.drawRect(0, 0, 500, 500, paint);
	}
}
