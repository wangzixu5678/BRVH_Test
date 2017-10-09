package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section;

import android.view.View;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/30.
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.ac_sec_head_tv,item.header);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MySection item) {
        MyBean myBean = item.t;
        helper.setText(R.id.ac_sec_entity_tv,myBean.getName()+myBean.getAddress());
        helper.addOnClickListener(R.id.ac_sec_entity_ll);
    }
}
