package com.realmdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ShowUserDetail extends BaseActivity {

    private RecyclerView rcyUserDetail;
    private UserDetailAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_detail);

        rcyUserDetail = findViewById(R.id.rcyUserDetail);
        rcyUserDetail.setHasFixedSize(true);
        rcyUserDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Get User Data from DataBase
        getUserData();
    }

    public void getUserData() {
        adapter = new UserDetailAdapter(ShowUserDetail.this, getUserDetail());
        rcyUserDetail.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
