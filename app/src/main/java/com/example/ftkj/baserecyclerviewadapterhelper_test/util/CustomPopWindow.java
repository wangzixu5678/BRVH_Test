package com.example.ftkj.baserecyclerviewadapterhelper_test.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by FTKJ on 2017/9/26.
 */

public class CustomPopWindow extends PopupWindow {
    private View mImageview;
    private EditText mEditText;
   private Context mContext;
    public CustomPopWindow(Context context) {
        mContext = context;
        setContentView(getContentView(context));
        setAnimationStyle(R.style.contextMenuAnim);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        setTouchable(true);
        setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //必须设置不设置点击事件没反应
        setFocusable(true);
        setOutsideTouchable(true);
    }

    private View getContentView(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.popuplayout, null);
        mImageview = view.findViewById(R.id.ac_pop_image);
        mEditText = (EditText) view.findViewById(R.id.ac_pop_edittext);
        mImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToast("你好朋友");
            }
        });
        return view;

    }

    public void show(View parentView) {
        KeyBoardUtils.openKeybordWithoutEditTex(mContext);
        showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
    }
}
