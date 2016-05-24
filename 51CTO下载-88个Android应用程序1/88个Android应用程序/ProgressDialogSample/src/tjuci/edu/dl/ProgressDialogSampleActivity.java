package tjuci.edu.dl;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class ProgressDialogSampleActivity extends Activity {
    
	/** Called when the activity is first created. */
	//任务大小
	private int[] data = new int[100];
	//已经完成数据
	private int hasdata = 0;
	//完成程度 
	private int status = 0;
	//设置标记
	final int SIGN = 0x11;
	Handler h;
	//定义一个ProgressDialog
	ProgressDialog pd ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(SIGN);
			}
		});
        h = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 0x1111:
					pd.setProgress(status);
					break;
				default:
					break;
				}
				pd.setProgress(status);
			}
        	
        };
        
    }
    //调用onPrepareDialog()方法之后
    @Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
    	pd = new ProgressDialog(this);
    	pd.setMax(100);
    	pd.setMessage("任务百分比");
    	pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    	pd.setCancelable(false);
    	return pd;
	}
    //调用showDialog()之后和调用onCreateDialog之前
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		switch (id) {
		case SIGN:
			pd.incrementProgressBy(-pd.getProgress());
			new Thread(){
				@Override
				public void run() {
					while(status < 100){
						status = dowork();
						Message msg = new Message();
						msg.what = 0x1111;
						h.sendMessage(msg);
					}
					if(status >= 100){
						pd.dismiss();
					}
				}	
			}.start();
			break;
		}
	}
	public int dowork(){
		data[hasdata ++] = (int)(Math.random()*100);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hasdata;
	}
    
}