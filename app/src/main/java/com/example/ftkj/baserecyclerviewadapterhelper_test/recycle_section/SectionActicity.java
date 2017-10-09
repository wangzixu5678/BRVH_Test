package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SectionActicity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private List<MySection> mDatas;
    private SectionAdapter mSectionAdapter;
    private static class MyHandler extends Handler {
        WeakReference<SectionActicity> weakReference ;

        public MyHandler(SectionActicity activity ){
            weakReference  = new WeakReference<SectionActicity>( activity) ;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ( weakReference.get() != null ){
                // update android ui
            }
        }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_acticity);
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_sec_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mDatas = new ArrayList<>();
        mSectionAdapter = new SectionAdapter(R.layout.activity_sec_entity, R.layout.activity_sec_head, mDatas);
        mSectionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mSectionAdapter.isFirstOnly(false);
        mSectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                MyBean myBean = mSectionAdapter.getData().get(position).t;
                ToastUtils.showShortToast(String.valueOf(position)+myBean.getName());
            }
        });
        mRecyclerView.setAdapter(mSectionAdapter);
        initData();
    }

    private void initData() {
        new MyHandler(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                mSectionAdapter.addData(new MySection(true, "我是Head1"));
                mSectionAdapter.addData(new MySection(new MyBean("马云", 45, "杭州")));
                mSectionAdapter.addData(new MySection(new MyBean("马云", 45, "杭州")));
                mSectionAdapter.addData(new MySection(new MyBean("马云", 45, "杭州")));
                mSectionAdapter.addData(new MySection(new MyBean("马云", 45, "杭州")));
                mSectionAdapter.addData(new MySection(true, "我是Head2"));
                mSectionAdapter.addData(new MySection(new MyBean("姚明", 38, "上海")));
                mSectionAdapter.addData(new MySection(new MyBean("姚明", 38, "上海")));
                mSectionAdapter.addData(new MySection(new MyBean("姚明", 38, "上海")));
                mSectionAdapter.addData(new MySection(true, "我是Head3"));
                mSectionAdapter.addData(new MySection(new MyBean("马化腾", 35, "深圳")));
                mSectionAdapter.addData(new MySection(new MyBean("马化腾", 35, "深圳")));
                mSectionAdapter.addData(new MySection(true, "我是Head4"));
                mSectionAdapter.addData(new MySection(new MyBean("詹姆斯", 35, "美国")));
                mSectionAdapter.notifyDataSetChanged();
            }
        },2000);
    }


}
