package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by FTKJ on 2017/9/30.
 */

public class LevelSecondItem extends AbstractExpandableItem<Person> implements MultiItemEntity {
    private String secondTitle;

    public LevelSecondItem(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getItemType() {
        return ExpandableAdapter.SECONDITEM;
    }

    public String getSecondTitle() {
        return secondTitle;
    }
}
