package com.example.tomapter.findyourpub;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.auth.UserInfo;

public class LoginActivity extends AppCompatActivity {
    private EditText etPassword;
    private EditText etUserName;
    private Button bLogin;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName = (EditText) findViewById(R.id.etUserName);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        final DatabaseHandler db = new DatabaseHandler(this);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUserName.getText().toString().equals(db.getUser(etUserName.getText().toString()).getUserName()) && etPassword.getText().toString().equals(db.getUser(etUserName.getText().toString()).getPassword())){
                    Log.d("test", "click");
                    Intent intent = new Intent(getBaseContext(), UserInfoActivity.class);
                    intent.putExtra("name", db.getUser(etUserName.getText().toString()).getName());
                    intent.putExtra("userName", db.getUser(etUserName.getText().toString()).getUserName());
                    intent.putExtra("password", db.getUser(etUserName.getText().toString()).getPassword());
                    intent.putExtra("age", db.getUser(etUserName.getText().toString()).getAge());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(), "Username or password are incorrect", Toast.LENGTH_LONG).show();
                }



                Log.d("test", "click");
                Log.d("age", db.getUser(etUserName.getText().toString()).getAge());
                Log.d("db response",db.getUser(etUserName.getText().toString()).getPassword());
                Log.d("db response",etPassword.getText().toString());
            }
        });

    }
}
