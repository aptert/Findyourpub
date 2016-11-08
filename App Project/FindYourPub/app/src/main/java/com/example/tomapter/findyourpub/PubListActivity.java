package com.example.tomapter.findyourpub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PubListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] pubNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_list);

    }
}
