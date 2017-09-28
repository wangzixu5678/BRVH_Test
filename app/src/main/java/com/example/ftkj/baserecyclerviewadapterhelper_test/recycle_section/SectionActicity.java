package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.CustomPopWindow;
public class SectionActicity extends AppCompatActivity {

    private CustomPopWindow mCustomPopWindow;
    private LinearLayout mLl;
    private EditText mEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_acticity);
        mLl = (LinearLayout) findViewById(R.id.ll_parent);
        mEt = (EditText) findViewById(R.id.main_et);
        mCustomPopWindow = new CustomPopWindow(this);
    }

    public void btn_Show(View view) {

        mCustomPopWindow.show(mLl);
    }

    public void btn_Bord(View view) {


    }
}
