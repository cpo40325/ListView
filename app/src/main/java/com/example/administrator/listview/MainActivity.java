package com.example.administrator.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private MyAdapter adapter;
    private int[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        data = new int[]{1,2,22,3,41,55,3,21,67,88,98,62,61,72,73,432,211,111,6,8,7,0,23,888,555,12};
        listView = findViewById(R.id.lv);
        adapter = new MyAdapter(this,data);
        listView.setAdapter(adapter);
    }
}
