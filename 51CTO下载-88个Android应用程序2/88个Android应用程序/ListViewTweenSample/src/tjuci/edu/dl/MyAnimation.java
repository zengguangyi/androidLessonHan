package tjuci.edu.dl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {
	int center_x;
	int center_y;
	// 持续时间
	int duration;

	public MyAnimation(int center_x, int center_y, int duration) {
		this.center_x = center_x;
		this.center_y = center_y;
		this.duration = duration;
	}

	// 定义Camera
	Camera camera;

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		// 设置MyAnimation的属性
		setDuration(duration);
		setFillAfter(true);
		setInterpolator(new LinearInterpolator());// 匀速
		camera = new Camera();
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		camera.save();
		camera.translate(100.0f - 100.0f * interpolatedTime,
				150.0f * interpolatedTime - 150.0f,
				80.0f - 80.0f * interpolatedTime);
		camera.rotateX(360 * interpolatedTime);
		camera.rotateY(360 * interpolatedTime);
		Matrix matrix = t.getMatrix();
		camera.getMatrix(matrix);
		matrix.preTranslate(-center_x, -center_y);
		matrix.postTranslate(center_x, center_y);
		camera.restore();
	}
}
