package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/22.
 */

public class ShoppingAdapter extends BaseQuickAdapter<Product, BaseViewHolder> {
    private boolean mIsEdit;

    public ShoppingAdapter(int layoutResId, List<Product> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Product item) {
        helper.setText(R.id.product_price, String.valueOf(item.getProductPrice()))
                .setText(R.id.product_name, item.getProductName())
                .setText(R.id.product_num, String.valueOf(item.getProductNumber()))
                .setChecked(R.id.product_checkbox, item.isChecked())
                .addOnClickListener(R.id.product_add)
                .addOnClickListener(R.id.product_dec)
                .addOnClickListener(R.id.product_checkbox);
        CheckBox checkBox = helper.getView(R.id.product_checkbox);
        if (!mIsEdit) {
            checkBox.setVisibility(View.GONE);
        } else {
            checkBox.setVisibility(View.VISIBLE);
        }
        Glide.with(mContext).load(item.getImageSrc()).into((ImageView) helper.getView(R.id.product_imageview));
    }

    public void setIsEdit(boolean isEdit) {
        mIsEdit = isEdit;
    }
}
