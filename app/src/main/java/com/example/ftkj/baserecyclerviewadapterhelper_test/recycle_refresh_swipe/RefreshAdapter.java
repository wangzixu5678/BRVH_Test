package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_refresh_swipe;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/25.
 */

public class RefreshAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RefreshAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.content_txt,item);
    }
}
