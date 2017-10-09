package com.example.ftkj.baserecyclerviewadapterhelper_test.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by FTKJ on 2017/10/9.
 */

public class IntentUtil {
    public static void go(Context start,Class end){
        Intent intent = new Intent(start,end);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        start.startActivity(intent);
    }
}
