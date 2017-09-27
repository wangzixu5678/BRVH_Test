package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_shopping;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.ArrayList;
import java.util.Locale;

public class ShoppingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Product> mProducts;
    private ShoppingCar mShoppingCar;
    private ShoppingAdapter mShoppintAdapter;
    private static final String TAG = "AAA";
    private Context mContext = this;
    private TextView mtotlePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping2);
        mtotlePrice = (TextView) findViewById(R.id.totle_price);
        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.shopping_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        mProducts = new ArrayList<>();
        mProducts.add(new Product("旺旺0泡泡果奶", 3, 4f, R.drawable.a));
        mProducts.add(new Product("旺仔小小酥", 2, 6f, R.drawable.b));
        mProducts.add(new Product("旺旺牛奶", 1, 68, R.drawable.c));
        mProducts.add(new Product("旺旺摇滚动", 10, 3, R.drawable.e));
        mProducts.add(new Product("旺旺黑白配", 5, 5, R.drawable.f));
        mProducts.add(new Product("旺旺小馒头", 5, 7, R.drawable.g));
        mProducts.add(new Product("旺旺0泡泡果奶", 3, 4f, R.drawable.a));
        mProducts.add(new Product("旺仔小小酥", 2, 6f, R.drawable.b));
        mProducts.add(new Product("旺旺牛奶", 1, 68, R.drawable.c));
        mProducts.add(new Product("旺旺摇滚动", 10, 3, R.drawable.e));
        mProducts.add(new Product("旺旺黑白配", 5, 5, R.drawable.f));
        mProducts.add(new Product("旺旺小馒头", 5, 7, R.drawable.g));
        mShoppingCar = new ShoppingCar(mProducts, false);
        notifiTotlePrice();
    }

    private void notifiTotlePrice() {
        mtotlePrice.setText(String.format(Locale.CHINA, "总价格%.2f元", mShoppingCar.getTotlePrice()));
        Log.d(TAG, "notifiTotlePrice: " + mShoppingCar.toString());
    }

    private void initAdapter() {
        mShoppintAdapter = new ShoppingAdapter(R.layout.shopping_item, mShoppingCar.getProducts());
        mShoppintAdapter.setIsEdit(mShoppingCar.isEdit());
        mShoppintAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                final int pos = position;
                TextView numText = (TextView) adapter.getViewByPosition(mRecyclerView, position, R.id.product_num);
                CheckBox checkBox = (CheckBox) adapter.getViewByPosition(mRecyclerView, position, R.id.product_checkbox);
                String sNum = numText.getText().toString().trim();
                int product_num = Integer.parseInt(sNum);
                switch (view.getId()) {
                    case R.id.product_add:
                        product_num = product_num + 1;
                        mProducts.get(position).setProductNumber(product_num);
                        numText.setText(String.valueOf(product_num));
                        break;
                    case R.id.product_dec:
                        if (product_num <= 1) {
                            new AlertDialog.Builder(mContext)
                                    .setMessage("你是想要删除商品？？")
                                    .setPositiveButton("是的呢", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            mProducts.remove(pos);
                                            mShoppintAdapter.notifyDataSetChanged();
                                            Log.d("AAA", "onClick: " + mShoppingCar.toString());
                                        }
                                    })
                                    .setNegativeButton("点错了", null)
                                    .show();
                        } else {
                            product_num = product_num - 1;
                            mProducts.get(position).setProductNumber(product_num);
                            numText.setText(String.valueOf(product_num));
                        }
                        break;
                    case R.id.product_checkbox:
                        boolean isChecked = checkBox.isChecked();
                        ToastUtils.showShortToast("点击了checkbox" + isChecked + pos);
                        mProducts.get(pos).setChecked(isChecked);
                        break;
                }
                notifiTotlePrice();
            }
        });
        mRecyclerView.setAdapter(mShoppintAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopingmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_shoping:
                mShoppingCar.setEdit(!mShoppingCar.isEdit());
                mShoppintAdapter.setIsEdit(mShoppingCar.isEdit());
                mShoppintAdapter.notifyDataSetChanged();
                notifiTotlePrice();
                break;
        }
        return true;
    }
}
