package tjuci.edu.dl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IOStreamSampleActivity extends Activity {
	Button readBtn,writeBtn;
	EditText readEdit,writeEdit;
	FileInputStream fis;
	FileOutputStream fos;
	final String FILE_NAME = "myfile";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        readBtn = (Button)findViewById(R.id.read);
        writeBtn = (Button)findViewById(R.id.write);
        readEdit = (EditText)findViewById(R.id.editRead);
        writeEdit = (EditText)findViewById(R.id.editWrite);
        //Ð´Èë
        writeBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			try {
				fos = openFileOutput(FILE_NAME, MODE_APPEND);
				PrintStream ps = new PrintStream(fos);
				ps.println(writeEdit.getText());
				ps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			}
		});
        readBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					fis = openFileInput(FILE_NAME);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					StringBuffer sb = new StringBuffer("");
					while((hasRead = fis.read(buff))>0){
						sb.append(new String(buff, 0, hasRead));
					}
					readEdit.setText(sb.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}