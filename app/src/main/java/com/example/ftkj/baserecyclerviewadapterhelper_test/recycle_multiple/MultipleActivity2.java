package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

/**
 * 多布局的第二种用法 
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.ArrayList;
import java.util.List;

public class MultipleActivity2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MyEntity> mDatas;
    private MultiDelegateAdapter mMultiDelegateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple2);
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_mul2_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        mDatas = new ArrayList<>();
        mMultiDelegateAdapter = new MultiDelegateAdapter(mDatas);


        mMultiDelegateAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return mDatas.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(mMultiDelegateAdapter);
        initData();
    }

    private void initData() {
        /**----------------------------第一个布局数据填充------------------*/
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("I love android"+i);
        }
        mMultiDelegateAdapter.addData(new MyEntity<String>(list,4,MyEntity.TYPE1));
        /**----------------------------第二个布局数据填充------------------*/

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        mMultiDelegateAdapter.addData(new MyEntity<Integer>(list2,4,MyEntity.TYPE2));
        mMultiDelegateAdapter.notifyDataSetChanged();
    }
}
