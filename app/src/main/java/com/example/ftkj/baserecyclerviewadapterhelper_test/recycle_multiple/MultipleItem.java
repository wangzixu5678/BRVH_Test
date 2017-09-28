package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/26.
 */

public class MultipleItem<T> implements MultiItemEntity {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;
    public static final int TYPE6 = 6;
    private int itemType;
    private int spanSize;
    private List<T> t;

    public MultipleItem(int itemType, int spanSize, List<T> t) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.t = t;

    }
    public MultipleItem(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }
    public List<T> getDatas() {
        return t;
    }

    public void setDatas(List<T> t) {
        this.t = t;
    }



    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
