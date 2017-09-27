package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.lang.ref.WeakReference;
import java.util.List;


/**
 * Created by FTKJ on 2017/9/26.
 */

public class MultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    public MultipleAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TYPE1, R.layout.type1_layout);
        addItemType(MultipleItem.TYPE2, R.layout.type2_layout);
        addItemType(MultipleItem.TYPE3, R.layout.type3_layout);
        addItemType(MultipleItem.TYPE4, R.layout.type4_layout);
        addItemType(MultipleItem.TYPE5, R.layout.type5_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TYPE1:
                Banner banner = helper.getView(R.id.banner);
                WeakReference<Banner> weakReference = new WeakReference<>(banner);

                weakReference.get().setImages(item.getDatas()).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setImageResource(((Integer) path));
                    }
                }).start();
                weakReference.get().setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        ToastUtils.showShortToast(String.valueOf(position));
                    }
                });

                break;
            case MultipleItem.TYPE2:
                Log.d("AAAA", "convert1: " + item.getDatas().toString());
                break;
            case MultipleItem.TYPE3:
                if (helper.getLayoutPosition() == 2) {
                    helper.addOnClickListener(R.id.type3_image);
                } else if (helper.getLayoutPosition() == 3) {
                    Log.d("AAAA", "convert3: " + item.getDatas().toString());
                }
                break;
            case MultipleItem.TYPE4:
                Log.d("AAAA", "convert4: " + item.getDatas().toString());
                break;
            case MultipleItem.TYPE5:
//                MyListView listView = helper.getView(R.id.type5_listview);
//                listView.setAdapter(new ArrayAdapter<String>(mContext,android.R.layout.simple_list_item_1,android.R.id.text1,item.getDatas()));
                MyRecyclerView recyclerView = helper.getView(R.id.type5_listview);

                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                recyclerView.setAdapter(new MyQuickAdapter(android.R.layout.simple_list_item_1, item.getDatas()));

                break;
        }
    }

}
