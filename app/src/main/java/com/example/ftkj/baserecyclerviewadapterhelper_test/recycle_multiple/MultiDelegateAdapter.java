package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FTKJ on 2017/9/28.
 */

public class MultiDelegateAdapter extends BaseQuickAdapter<MyEntity, BaseViewHolder> {
    public MultiDelegateAdapter(List<MyEntity> data) {
        super(data);
        setMultiTypeDelegate(new MultiTypeDelegate<MyEntity>() {
            @Override
            protected int getItemType(MyEntity myEntity) {
                int type= 0;
                if (myEntity.gettData().get(0) instanceof String){
                    type = MyEntity.TYPE1;
                }else if (myEntity.gettData().get(0) instanceof Integer){
                    type =MyEntity.TYPE2;
                }
                return type;
            }
        });

        getMultiTypeDelegate()
                .registerItemType(MyEntity.TYPE1, R.layout.type1_layout)
                .registerItemType(MyEntity.TYPE2, R.layout.type2_layout);

    }

    @Override
    protected void convert(BaseViewHolder helper, final MyEntity item) {
        switch (helper.getItemViewType()) {
            case MyEntity.TYPE1:
                Banner banner = (Banner) helper.getView(R.id.banner);
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        if (item.gettData().get(position) instanceof String){
                            ToastUtils.showShortToast(((String) item.gettData().get(position)));
                        }
                    }
                });
                final List<Integer> images  = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    images.add(R.mipmap.ic_launcher);
                }
                banner.setImages(images).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        imageView.setImageResource(((Integer) path));
                    }
                }).start();
                break;
            case MyEntity.TYPE2:
                break;
        }

    }
}
