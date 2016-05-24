package tjuci.edu.dl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class First extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �����ض���intent ���ȴ����
				Intent intent = new Intent(First.this, Second.class);
				startActivityForResult(intent, 0);
			}
		});
    }
    /**
     * �ȵ�intent�Ļظ�  Ӧ����дonActivityResult����
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if(resultCode == 0 && requestCode == 0){
    		Bundle extras = data.getExtras();
    		String result = extras.getString("city");
    		((EditText)findViewById(R.id.edit)).setText(result);
    	}
    }
}