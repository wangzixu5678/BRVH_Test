package com.example.ftkj.baserecyclerviewadapterhelper_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_anim.AnimActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_drag.DragActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable.ExpandableActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple.MultipleActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple.MultipleActivity2;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_refresh_swipe.RefreshSwipActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section.SectionActicity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping.ShoppingActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.IntentUtil;

public class WelcomActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        findViewById(R.id.wel_anim).setOnClickListener(this);
        findViewById(R.id.wel_section).setOnClickListener(this);
        findViewById(R.id.wel_shopping).setOnClickListener(this);
        findViewById(R.id.wel_mul).setOnClickListener(this);
        findViewById(R.id.wel_mul2).setOnClickListener(this);
        findViewById(R.id.wel_drag).setOnClickListener(this);
        findViewById(R.id.wel_expandable).setOnClickListener(this);
        findViewById(R.id.wel_refresh).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wel_anim:
                IntentUtil.go(this, AnimActivity.class);
                break;
            case R.id.wel_drag:
                IntentUtil.go(this, DragActivity.class);
                break;
            case R.id.wel_expandable:
                IntentUtil.go(this, ExpandableActivity.class);
                break;
            case R.id.wel_mul:
                IntentUtil.go(this, MultipleActivity.class);
                break;
            case R.id.wel_mul2:
                IntentUtil.go(this, MultipleActivity2.class);
                break;
            case R.id.wel_refresh:
                IntentUtil.go(this, RefreshSwipActivity.class);
                break;
            case R.id.wel_section:
                IntentUtil.go(this, SectionActicity.class);
                break;
            case R.id.wel_shopping:
                IntentUtil.go(this, ShoppingActivity.class);
                break;

        }
    }
}
