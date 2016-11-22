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
        final TextView tvUserName = (TextView) findViewById(R.id.tvUserName);
    }
}
