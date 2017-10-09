package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_drag;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/30.
 */

public class DragAdapter extends BaseItemDraggableAdapter<String,BaseViewHolder> {
    public DragAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.ac_drag_tv,item);
    }
}
