package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section;

/**
 * Created by FTKJ on 2017/9/28.
 */

public class MyBean {
    private String name;
    private int age;
    private String address;

    public MyBean(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
