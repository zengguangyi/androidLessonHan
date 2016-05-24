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
        Log.d("�豸��", " " + tManager.getDeviceId());
        Log.d("����汾", " " + tManager.getDeviceSoftwareVersion());
        Log.d("������Ӫ�̴���", " " + tManager.getNetworkOperator());
        Log.d("������Ӫ������", " " + tManager.getNetworkOperatorName());
        Log.d("�ֻ���������", " " + tManager.getPhoneType());
//        Log.d("�豸����λ��", "" + tManager.getCellLocation().toString());
        Log.d("Sim��״̬", "" + tManager.getSimState());
        Log.d("Sim�����к�","" +  tManager.getSimSerialNumber());
    }
}