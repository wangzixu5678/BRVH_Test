package com.example.ftkj.baserecyclerviewadapterhelper_test.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

/**
 * Created by FTKJ on 2017/9/26.
 */

public class CustomPopWindow extends PopupWindow {
    private View mImageview;

    public CustomPopWindow(Context context) {
        setContentView(getContentView(context));
        setAnimationStyle(R.style.contextMenuAnim);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        setTouchable(true);
        setOutsideTouchable(true);
    }

    private View getContentView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.popuplayout, null);
        mImageview = view.findViewById(R.id.ac_pop_image);
        mImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToast("你好朋友");
            }
        });
        return view;

    }

    public void show(View parentView) {
        showAtLocation(parentView, Gravity.CENTER, 0, 0);
    }
}
