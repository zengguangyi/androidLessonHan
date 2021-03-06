package tjuci.edu.dl;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class SensorSampleActivity extends Activity implements
		SensorEventListener {
	EditText ortationEdit, magneticEdit, temeratureEdit, lightEdit,
			pressureEdit;
	SensorManager sm;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ortationEdit = (EditText) findViewById(R.id.orientationEdit);
		magneticEdit = (EditText) findViewById(R.id.magneticEdit);
		temeratureEdit = (EditText) findViewById(R.id.temeratureEdit);
		lightEdit = (EditText) findViewById(R.id.lightEdit);
		pressureEdit = (EditText) findViewById(R.id.pressureEdit);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	}

	@Override
	protected void onResume() {
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this,
				sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
				SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_TEMPERATURE),
				SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_LIGHT),
				SensorManager.SENSOR_DELAY_GAME);
		sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_PRESSURE),
				SensorManager.SENSOR_DELAY_GAME);
		super.onResume();
	}

	@Override
	protected void onPause() {
		sm.unregisterListener(this);
		super.onPause();
	}

	@Override
	protected void onStop() {
		sm.unregisterListener(this);
		super.onStop();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float[] values = event.values;
		StringBuffer sb = null;
		int type = event.sensor.getType();
		switch (type) {
		case Sensor.TYPE_ORIENTATION:
			sb = new StringBuffer();
			sb.append("绕Z:" + values[0])
			.append("\n绕X:" + values[1])
			.append("\n绕X:" + values[2]);
			ortationEdit.setText(sb.toString());
			break;

		case Sensor.TYPE_MAGNETIC_FIELD:
			sb = new StringBuffer();
			sb.append("X方向的角度:" + values[0])
			.append("\nY方向的角度:" + values[1])
			.append("\nZ方向的角度:" + values[2]);
			magneticEdit.setText(sb.toString());
			break;
		case Sensor.TYPE_TEMPERATURE:
			sb = new StringBuffer();
			sb.append("温度为:" + values[0]);
			temeratureEdit.setText(sb.toString());
			break;
		case Sensor.TYPE_LIGHT:
			sb = new StringBuffer();
			sb.append("光强为:" + values[0]);
			lightEdit.setText(sb.toString());
			break;
		case Sensor.TYPE_PRESSURE:
			sb = new StringBuffer();
			sb.append("当前压力为:" + values[0]);
			pressureEdit.setText(sb.toString());
			break;
		}
	}
}