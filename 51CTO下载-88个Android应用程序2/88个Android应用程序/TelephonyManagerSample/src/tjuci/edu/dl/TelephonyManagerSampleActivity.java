package tjuci.edu.dl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class TelephonyManagerSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TelephonyManager tManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        Log.d("设备号", " " + tManager.getDeviceId());
        Log.d("软件版本", " " + tManager.getDeviceSoftwareVersion());
        Log.d("网络运营商代号", " " + tManager.getNetworkOperator());
        Log.d("网络运营商名称", " " + tManager.getNetworkOperatorName());
        Log.d("手机网络类型", " " + tManager.getPhoneType());
//        Log.d("设备所在位置", "" + tManager.getCellLocation().toString());
        Log.d("Sim卡状态", "" + tManager.getSimState());
        Log.d("Sim卡序列号","" +  tManager.getSimSerialNumber());
    }
}