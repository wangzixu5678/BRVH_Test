package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/27.
 */

public class MyQuickAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public MyQuickAdapter(int layoutResId,List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        helper.setText(android.R.id.text1,item);
        helper.getView(android.R.id.text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToast(helper.getLayoutPosition() +"---"+helper.getAdapterPosition()+"---"+helper.getOldPosition());
            }
        });

    }
}
