package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_anim;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/21.
 */

public class AnimAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public AnimAdapter(int layoutResId,List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        ((TextView) helper.getView(R.id.item_text)).setText(item);
        helper.setText(R.id.item_text,item)
                .addOnClickListener(R.id.item_text);
    }
}
