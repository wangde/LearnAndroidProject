package com.hlju.wangde.day03_showdata.domain;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by XiaoDe on 2017/6/4 10:27.
 *
 * @author XiaoDe.
 *         Project Name is LearnAndroidProject.
 */

public class Person {
    private String name;
    private String phone;
    private int salary;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", phone='" + phone +
                ", salary='" + salary;
    }

    public Person(String name, String phone, int salary) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }
}
