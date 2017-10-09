package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_anim;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.base.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Locale;


public class AnimActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList;
    private AnimAdapter mAnimAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAnimAdapter);

    }
    private void initAdapter() {
        mArrayList = new ArrayList<>();
        mAnimAdapter = new AnimAdapter(R.layout.anim_item, mArrayList);
        mAnimAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mAnimAdapter.isFirstOnly(false);
        mAnimAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position==0){
                    mAnimAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                }
            }
        });

        mAnimAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(AnimActivity.this, ""+view.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        mAnimAdapter.setEnableLoadMore(true);

        mAnimAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Toast.makeText(AnimActivity.this, "开始loadmore", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               mAnimAdapter.addData(mArrayList);
                               mAnimAdapter.loadMoreComplete();
                               Toast.makeText(AnimActivity.this, "loadmore Complete", Toast.LENGTH_SHORT).show();
                           }
                       });
                    }
                }).start();
            }
        });

        mAnimAdapter.setUpFetchEnable(true);
        mAnimAdapter.setUpFetching(true);
        mAnimAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                Toast.makeText(AnimActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
            }
        });
        mAnimAdapter.addHeaderView(getHeadView());


    }

    public View getHeadView(){
        View view = LayoutInflater.from(this).inflate(R.layout.head_item,null);
        Banner banner = (Banner) view.findViewById(R.id.banner);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(AnimActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.qq);
        list.add(R.drawable.rcount);
        list.add(R.drawable.sina);
        list.add(R.drawable.wechat);
        banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(((Integer) path));
            }
        }).start();

        return view;
    }
    private void initData() {

        for (int i = 0; i < 10; i++) {
            mArrayList.add(String.format(Locale.CHINA,"我爱Android%d",i));
        }
        mAnimAdapter.notifyDataSetChanged();
    }




}
