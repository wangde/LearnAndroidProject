package com.hlju.wangde.day03_xmlpullparser.domain;

/**
 * Created by XiaoDe on 2017/6/2.
 */

public class City {
    private String name;
    private String temp;
    private String pm25;

//    public City(String name, String temp, String pm25) {
//        this.name = name;
//        this.temp = temp;
//        this.pm25 = pm25;
//    }

    public String getName() {
        return name;
    }

    public String getTemp() {
        return temp;
    }

    public String getPm25() {
        return pm25;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }
}
