package tjuci.edu.dl;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
   
public class LockScreenActivity extends DeviceAdminReceiver {   
    static final int RESULT_ENABLE = 1;   
   
    public static class Controller extends Activity {   
   
        DevicePolicyManager mDPM;   
        ComponentName mDeviceAdminSample;   
   
        @Override   
        protected void onCreate(Bundle savedInstanceState) {   
            super.onCreate(savedInstanceState);   
               
            //��������Ҫ���android�豸�������   
            mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);   
               
            //LockScreen �̳��� DeviceAdminReceiver   
            mDeviceAdminSample = new ComponentName(Controller.this,   
                    LockScreen.class);   
            //�õ���ǰ�豸��������û�м���   
            boolean active = mDPM.isAdminActive(mDeviceAdminSample);   
            if (!active) {    
                //���û�м���Ļ�����ȥ��ʾ�û������һ�����г���ʱ��   
                getAdmin();   
            }else{   
                //����Ѿ�����Ļ�����ִ����������   
                mDPM.lockNow();   
            }   
               
        //  killMyself ������֮�������kill�����ǵ�Activity��������Դ���˷�;   
            android.os.Process.killProcess(android.os.Process.myPid());    
        }   
   
        public void getAdmin() {   
            // Launch the activity to have the user enable our admin.   
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);   
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,   
                    mDeviceAdminSample);   
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,   
   startActivityForResult(intent, RESULT_ENABLE);   
        }   
           
    }  
 
}
