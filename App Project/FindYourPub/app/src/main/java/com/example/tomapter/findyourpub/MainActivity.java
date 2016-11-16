package com.example.tomapter.findyourpub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.find_me:
                startActivity(new Intent(this, FindPubActivity.class));
                break;
            case R.id.go:
                startActivity(new Intent(this, PubListActivity.class));
                break;
        }
    }
}
