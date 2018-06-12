package com.example.songhongji.avtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AVMainActivity extends AppCompatActivity {

    private RecyclerView listView;
    private AVListAdapter avListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avmain);

        listView = (RecyclerView) findViewById(R.id.list_view);
        listView.setLayoutManager(new LinearLayoutManager(this));
        avListAdapter = new AVListAdapter();
        listView.setAdapter(avListAdapter);

    }
}
