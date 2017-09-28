package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/28.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public MyPagerAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        if (mList.size() != 0) {
             view = mInflater.inflate(R.layout.vp_item, container, false);
            ((TextView) view.findViewById(R.id.vp_textview)).setText(mList.get(position % mList.size()));
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
