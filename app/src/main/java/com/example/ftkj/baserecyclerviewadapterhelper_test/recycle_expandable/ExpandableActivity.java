package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.base.BaseActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple.MultipleItem;

import java.util.ArrayList;
import java.util.List;

public class ExpandableActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<MultiItemEntity> mDatas;
    private ExpandableAdapter mExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_expand_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mDatas = new ArrayList<>();
        mExpandableAdapter = new ExpandableAdapter(mDatas);
        mExpandableAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return 4;
            }
        });
        mRecyclerView.setAdapter(mExpandableAdapter);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            LevelFirstItem firstItem = new LevelFirstItem("第一级菜单" + i);
            for (int j = 0; j < 5; j++) {
                LevelSecondItem levelSecondItem = new LevelSecondItem("第二级菜单" + j);
                for (int k = 0; k < 6; k++) {
                    Person person = new Person("王梓旭"+k, 22, "泉阳");
                    levelSecondItem.addSubItem(person);
                }
                firstItem.addSubItem(levelSecondItem);
            }
            mDatas.add(firstItem);
        }
        mExpandableAdapter.notifyDataSetChanged();
    }
}
