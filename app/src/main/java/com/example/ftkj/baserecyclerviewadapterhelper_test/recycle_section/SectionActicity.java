package com.example.ftkj.baserecyclerviewadapterhelper_test.recycle_section;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.ftkj.baserecyclerviewadapterhelper_test.R;
public class SectionActicity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_acticity);
        mRecyclerView = (RecyclerView) findViewById(R.id.ac_sec_recycler);


    }


}
