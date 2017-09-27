package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_refresh_swipe;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ajguan.library.IRefreshHeader;
import com.ajguan.library.State;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;

/**
 * Created by FTKJ on 2017/9/25.
 */

public class CustomRefreshHeadView extends FrameLayout implements IRefreshHeader {

    private AnimationDrawable mAnimList;
    private ImageView mImageView;
    private View mLoadTxt;
    private View mLoadCompelete;

    public CustomRefreshHeadView(Context context) {
        this(context, null);
    }

    public CustomRefreshHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.refresh_headview, this);
        mImageView = (ImageView) this.findViewById(R.id.head_image);
        mLoadTxt = this.findViewById(R.id.head_loading);
        mLoadCompelete = this.findViewById(R.id.head_compelete);
        mAnimList = (AnimationDrawable) mImageView.getBackground();
    }


    @Override
    public void reset() {
        mLoadTxt.setVisibility(VISIBLE);
        mLoadCompelete.setVisibility(GONE);
    }

    @Override
    public void pull() {
        Log.d("AAA", "pull: ");
    }

    @Override
    public void refreshing() {
        Log.d("AAA", "refreshing: ");
        mLoadCompelete.setVisibility(INVISIBLE);
        mImageView.setVisibility(VISIBLE);
        mLoadTxt.setVisibility(VISIBLE);
        mAnimList.start();
    }

    @Override
    public void onPositionChange(float currentPos, float lastPos, float refreshPos, boolean isTouch, State state) {
        // 往上拉

        if (currentPos < refreshPos && lastPos >= refreshPos) {
            Log.i("", ">>>>up");

            if (isTouch && state == State.PULL) {

            }
        } else if (currentPos > refreshPos && lastPos <= refreshPos) {
            Log.i("", ">>>>down");
            if (isTouch && state == State.PULL) {

            }

        }
    }

    @Override
    public void complete() {
        Log.d("AAA", "complete: ");
        mAnimList.stop();
        mLoadTxt.setVisibility(GONE);
        mLoadCompelete.setVisibility(VISIBLE);
    }
}
