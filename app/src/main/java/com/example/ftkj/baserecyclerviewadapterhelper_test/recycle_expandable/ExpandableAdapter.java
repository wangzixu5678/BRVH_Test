package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_expandable;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
import com.example.ftkj.baserecyclerviewadapterhelper_test.util.ToastUtils;

import java.util.List;

/**
 * Created by FTKJ on 2017/9/30.
 */

public class ExpandableAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int FIRSTITEM = 1;
    public static final int SECONDITEM = 2;
    public static final int PERSONITEM = 3;

    public ExpandableAdapter(List data) {
        super(data);
        addItemType(FIRSTITEM, R.layout.first_item);
        addItemType(SECONDITEM, R.layout.second_item);
        addItemType(PERSONITEM, R.layout.person_item);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (item.getItemType()) {
            case FIRSTITEM:
                final LevelFirstItem firstItem = (LevelFirstItem) item;
                helper.setText(R.id.first_title, firstItem.getFirstTitle());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (firstItem.isExpanded()) {
                            collapse(position);
                        } else {
                            expand(position);
                        }
                    }
                });
                break;
            case SECONDITEM:
                final LevelSecondItem secondItem = (LevelSecondItem) item;
                helper.setText(R.id.second_title, secondItem.getSecondTitle());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = helper.getAdapterPosition();
                        if (secondItem.isExpanded()) {
                            collapse(position);
                        } else {
                            expand(position);
                        }
                    }
                });
                break;
            case PERSONITEM:
                final Person person = (Person) item;
                helper.setText(R.id.person_name, person.getName())
                        .setText(R.id.person_age, String.valueOf(person.getAge()))
                        .setText(R.id.person_address, person.getAddress());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int parentPosition = getParentPosition(person);
                        if (parentPosition != -1) {
                            ((LevelSecondItem) getData().get(parentPosition)).removeSubItem(person);
                            getData().remove(helper.getLayoutPosition());
                            notifyItemRemoved(helper.getLayoutPosition());
                        }
                    }
                });
                break;
        }

    }
}
