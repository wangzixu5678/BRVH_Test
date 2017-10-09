package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_drag;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.base.BaseActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DragActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private DragAdapter mDragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_drag_recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatas = new ArrayList<>();
        mDragAdapter = new DragAdapter(R.layout.drag_item,mDatas);
        mRecyclerView.setAdapter(mDragAdapter);
        ItemDragAndSwipeCallback swipeCallback = new ItemDragAndSwipeCallback(mDragAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeCallback);
        touchHelper.attachToRecyclerView(mRecyclerView);

        // 开启拖拽
        mDragAdapter.enableDragItem(touchHelper,R.id.ac_drag_ll, true);
        mDragAdapter.setOnItemDragListener(onItemDragListener);
        // 开启滑动删除
        mDragAdapter.enableSwipeItem();
        mDragAdapter.setOnItemSwipeListener(onItemSwipeListener);

        initData();
    }

    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            ToastUtils.showShortToast("开始拖拽"+pos);
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            ToastUtils.showShortToast("拖拽结束"+pos);
        }
    };
    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

        }
    };


    private void initData() {
        for (int i = 0; i < 20; i++) {
            mDragAdapter.addData("I love android" + i);
        }
        mDragAdapter.notifyDataSetChanged();
    }
}
