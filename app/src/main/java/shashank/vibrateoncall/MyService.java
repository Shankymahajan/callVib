package shashank.vibrateoncall;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyService extends IntentService {
    private static final String TAG = "CallVib";
    Vibrator vibrator;

    public MyService() {
        super("MySerive");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG,"My service is called");
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener phoneStateListener = new PhoneStateListener() {

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                // TODO Auto-generated method stub
                // super.onCallStateChanged(state, incomingNumber);
                String number = incomingNumber;

                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    Toast.makeText(getApplicationContext(), "Phone is Riging",
                            Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"phone is ringing");
                }

                if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                    Toast.makeText(getApplicationContext(), "Phone is Currenty in A call",
                            Toast.LENGTH_SHORT).show();
                    Log.d(TAG,"phone is currently on a call");
                    vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
                    vibrator.vibrate(300);
                }

                if (state == TelephonyManager.CALL_STATE_IDLE) {
                    Toast.makeText(getApplicationContext(), "Phone is neither Riging nor in a Call",
                            Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"Phone is neither Riging nor in a Call");
                }
            }

        };
        telephonyManager.listen
                (phoneStateListener,
                        PhoneStateListener.LISTEN_CALL_STATE);
    }
}


