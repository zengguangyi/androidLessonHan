package tjuci.edu.dl;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TextToSpeechSampleActivity extends Activity {
	TextToSpeech tts;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button readBtn = (Button)findViewById(R.id.readbtn);
        Button recordBtn = (Button)findViewById(R.id.recordbtn);
        final EditText readEdit = (EditText)findViewById(R.id.readedit);
        tts = new TextToSpeech(this, new OnInitListener() {
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status == TextToSpeech.SUCCESS){
					tts.setLanguage(Locale.US);
				}
			}
		});
        readBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.speak(readEdit.getText().toString(), TextToSpeech.QUEUE_ADD, null);
			}
		});
        recordBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.synthesizeToFile(readEdit.getText().toString(),null, "/mnt/sdcard/sound1.wav");
			}
		});
    }
    @Override
    protected void onDestroy() {
    	if(tts != null){
    		tts.shutdown();
    	}
    }
}