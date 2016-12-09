package com.example.tomapter.findyourpub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        final TextView tvAge = (TextView) findViewById(R.id.tvAge);

        tvWelcome.setText(" ");
        tvWelcome.append("Welcome " + getIntent().getStringExtra("name"));
        tvAge.setText(" ");
        tvAge.append("You are " + getIntent().getStringExtra("age") + " so you are allowed to go to any pub you like");
    }
}
