package com.hlju.wangde.day07_ipdial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CallReceiver extends BroadcastReceiver {

    //收到广播时调用
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        System.out.println("收到电话广播");
//        throw new UnsupportedOperationException("Not yet implemented");
        //取出广播中号码
        String number = getResultData();
        String newNubmer = "17951" + number;
        setResultData(newNubmer);

    }
}
