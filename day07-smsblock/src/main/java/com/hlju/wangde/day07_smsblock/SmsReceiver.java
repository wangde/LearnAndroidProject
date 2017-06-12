package com.hlju.wangde.day07_smsblock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Bundle bundle = intent.getExtras();
        Object[] objects = (Object[]) bundle.get("pdus");

        for (Object object : objects) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) object);
            String address = smsMessage.getOriginatingAddress();
            String body = smsMessage.getMessageBody();
            System.out.println(address + ":" + body + "0000000000000000000000000000000000000000000000000000000000000000");
            if ("".equals(address)) {
                //拦截短信
                abortBroadcast();
            }
        }
    }
}
