package com.hlju.wangde.sms;

/**
 * Created by XiaoDe on 2017/6/1.
 */

public class Sms {
    private String body;
    private long date;
    private int type;
    private String address;

    public Sms(String body, long date, int type, String address) {
        this.body = body;
        this.date = date;
        this.type = type;
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public long getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }
}
