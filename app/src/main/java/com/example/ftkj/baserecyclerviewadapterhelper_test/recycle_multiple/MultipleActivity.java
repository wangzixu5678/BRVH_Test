package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_multiple;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.base.BaseActivity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MultipleActivity extends BaseActivity {


    private RecyclerView mRecyclerView;
    private List<MultipleItem> mDatas;
    private MultipleAdapter mMultipleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        new MyAsynTask().execute();
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_mul_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setHasFixedSize(true);
        mDatas = new ArrayList<>();
        mMultipleAdapter = new MultipleAdapter(mDatas);
        mMultipleAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return mDatas.get(position).getSpanSize();
            }
        });
        mMultipleAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.type3_image:
                        ToastUtils.showShortToast("Type3 Imgae");
                        break;

                }
            }
        });
        mRecyclerView.setAdapter(mMultipleAdapter);
    }



    class MyAsynTask extends  AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Integer> myDatas = new ArrayList<>();
            myDatas.add(R.drawable.a);
            myDatas.add(R.drawable.b);
            myDatas.add(R.drawable.c);
            myDatas.add(R.drawable.e);
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE1,4,myDatas));

            ArrayList<MyData> myDatas2 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                myDatas2.add(new MyData("第二模块"+ i, 18, "全羊"));
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE2, 4, myDatas2));

            ArrayList<MyData> myDatas3 = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                myDatas3.add(new MyData("第三模块1" + i, 18, "全羊"));
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE3, 2, myDatas3));




            ArrayList<MyData> myDatas4 = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                myDatas4.add(new MyData("第三模块2" + i, 18, "全羊"));
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE3, 2, myDatas4));

            ArrayList<MyData> myDatas5 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                myDatas5.add(new MyData("第四模块" + i, 18, "全羊"));
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE4, 4, myDatas5));


            /**----------------------------Type5 Test-------------------------*/
           ArrayList<String> myDatas6 = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                myDatas6.add("I love android"+i);
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE5,4,myDatas6));
            /**----------------------------Type6 Test ------------------------*/

            ArrayList<String> mDatas7 = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                mDatas7.add("我是第"+i+"条新闻");
            }
            mDatas.add(new MultipleItem<>(MultipleItem.TYPE6,4,mDatas7));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mMultipleAdapter.notifyDataSetChanged();
        }
    }

}
