package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping;

import android.app.Application;

import com.example.ftkj.baserecyclerviewadapterhelper_test.util.Utils;

/**
 * Created by FTKJ on 2017/9/22.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
