package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by FTKJ on 2017/9/30.
 */

public class Person implements MultiItemEntity{

    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public int getItemType() {
        return ExpandableAdapter.PERSONITEM;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
