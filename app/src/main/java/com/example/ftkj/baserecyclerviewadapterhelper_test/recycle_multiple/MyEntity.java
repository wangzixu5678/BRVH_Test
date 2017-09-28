package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/28.
 */

public class MyEntity<T> {
    public static final int TYPE1 =1;
    public static final int TYPE2 =2;

    /**
     * 这个Data 是网络访问的数据 可以是个数组，当然更可能是个实体类 例如
     * NetData{
     *     private Long id;
     *     private String type
     *     private List<ItemInfo> mData;
     * }
     * 我们可以在适配器中根据 type的类型来设置布局。
     *
     *
     */
    private List<T> tData;

    /**
     * 占用比例  我们在GridLayoutManager中设置的4 在这里设置方便在Activity中setSpanSizeLookup获取。
     */
    private int spanSize;
    private int itemType;

    public MyEntity(List<T> tData, int spanSize, int itemType) {
        this.tData = tData;
        this.spanSize = spanSize;
        this.itemType = itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public int getItemType() {
        return itemType;
    }

    public List<T> gettData() {
        return tData;
    }

    public void settData(List<T> tData) {
        this.tData = tData;
    }
}
