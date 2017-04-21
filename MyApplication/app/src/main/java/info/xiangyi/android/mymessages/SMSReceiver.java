package info.xiangyi.android.mymessages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Xiangyi Meng on 4/15/2017.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (null != bundle) {
                {
                    // PDU -- Protocol data unit
                    final Object[] pdusObj = (Object[]) bundle.get("pdus");
                    for (Object obj : pdusObj) {
                        SmsMessage msg = SmsMessage.createFromPdu((byte[]) obj);
                        MainActivity inst = MainActivity.instance();
                        inst.addMsg(msg.getMessageBody());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

