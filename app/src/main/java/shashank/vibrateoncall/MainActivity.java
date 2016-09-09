package shashank.vibrateoncall;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private static final String TAG ="phoneStateTest" ;
    private Button button;
    private TextView textView;
    private boolean detecting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener phoneStateListener = new PhoneStateListener() {

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                // TODO Auto-generated method stub
                // super.onCallStateChanged(state, incomingNumber);
                String number = incomingNumber;

                if (state == TelephonyManager.CALL_STATE_RINGING) {
                  /*  Toast.makeText(getApplicationContext(), "Phone is Riging",
                            Toast.LENGTH_SHORT).show();
*/
                    Log.d(TAG,"phone is ringing");
                }

                if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                   /* Toast.makeText(getApplicationContext(), "Phone is Currenty in A call",
                            Toast.LENGTH_SHORT).show();*/
                    Log.d(TAG,"phone is currently on a call");
                }

                if (state == TelephonyManager.CALL_STATE_IDLE) {
                    /*Toast.makeText(getApplicationContext(), "Phone is neither Riging nor in a Call",
                            Toast.LENGTH_SHORT).show();
*/
                    Log.d(TAG,"Phone is neither Riging nor in a Call");
                }
            }

        };
        telephonyManager.listen
                (phoneStateListener,
                        PhoneStateListener.LISTEN_CALL_STATE);

    }
}
