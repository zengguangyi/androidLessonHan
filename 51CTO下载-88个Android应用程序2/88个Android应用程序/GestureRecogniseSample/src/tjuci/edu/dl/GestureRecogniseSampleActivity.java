package tjuci.edu.dl;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class GestureRecogniseSampleActivity extends Activity {
	GestureOverlayView gestureView;
	GestureLibrary gestureLibrary;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gestureView = new GestureOverlayView(this);
        gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
        if(gestureLibrary.load()){
        	Toast.makeText(GestureRecogniseSampleActivity.this, "װ�سɹ�", Toast.LENGTH_SHORT).show();
        }else{
        	Toast.makeText(GestureRecogniseSampleActivity.this, "װ��ʧ��", Toast.LENGTH_SHORT).show();
        }
        gestureView.addOnGesturePerformedListener(new OnGesturePerformedListener() {
			@Override
			public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
				// TODO Auto-generated method stub
				ArrayList<Prediction> prediction = gestureLibrary.recognize(gesture);
				ArrayList<String> list = new ArrayList<String>();
				for(Prediction p: prediction){
					String showMsg = "������[" + p.name + "]���ƶ�Ϊ��" + p.score;
					list.add(showMsg);
				}
				if(list.size() > 0){
					ArrayAdapter aa = new ArrayAdapter(GestureRecogniseSampleActivity.this, android.R.layout.simple_dropdown_item_1line, list.toArray());
					new AlertDialog.Builder(GestureRecogniseSampleActivity.this).setAdapter(aa, null).setPositiveButton("ȷ��", null).show();
				}else{
					Toast.makeText(GestureRecogniseSampleActivity.this, "û���ҵ�ƥ�������", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
}