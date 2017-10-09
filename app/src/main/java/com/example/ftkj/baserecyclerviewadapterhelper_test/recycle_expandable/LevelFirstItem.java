package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple.MultipleItem;

/**
 * Created by FTKJ on 2017/9/30.
 */

/**
 * 泛型里写下一层级的内容
 */
public class LevelFirstItem extends AbstractExpandableItem<LevelSecondItem> implements MultiItemEntity {
    private String firstTitle;

    public LevelFirstItem(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ExpandableAdapter.FIRSTITEM;
    }

    public String getFirstTitle() {
        return firstTitle;
    }
}
