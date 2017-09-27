package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_refresh_swipe;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.ArrayList;

public class RefreshSwipActivity extends AppCompatActivity {

    private EasyRefreshLayout mEasyLayout;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private RefreshAdapter mRefreshAdapter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_swip);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mEasyLayout = (EasyRefreshLayout) findViewById(R.id.easylayout);
        mEasyLayout.setRefreshHeadView(new CustomRefreshHeadView(this));
        //mEasyLayout.setLoadMoreModel(LoadModel.ADVANCE_MODEL,3);
        mDatas = new ArrayList<>();
        mRefreshAdapter = new RefreshAdapter(R.layout.item_layout, mDatas);
        mRefreshAdapter.setEmptyView(getEmptyView());
        mRecyclerView.setAdapter(mRefreshAdapter);
        mEasyLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEasyLayout.loadMoreComplete(new EasyRefreshLayout.Event() {
                            @Override
                            public void complete() {
                                mRefreshAdapter.getData().add("哈哈");
                                mRefreshAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                },1000);
            }

            @Override
            public void onRefreshing() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDatas.clear();
                        for (int i = 0; i < 10; i++) {
                            mDatas.add("I love android"+i);
                        }
                        mRefreshAdapter.notifyDataSetChanged();
                        mEasyLayout.refreshComplete();
                    }
                },2000);

            }
        });
    }



    private View getEmptyView() {
        View emptyView = LayoutInflater.from(this).inflate(R.layout.empty_view,null);
        (emptyView.findViewById(R.id.txt_empty)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    mDatas.add("我爱Android"+i);
                }
                mRefreshAdapter.notifyDataSetChanged();
            }
        });
        return emptyView;
    }
}
