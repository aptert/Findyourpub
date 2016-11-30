package com.example.tomapter.findyourpub;

import android.content.Intent;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUserName;
    private EditText etAge;
    private EditText etPassword;
    private EditText etName;
    private Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etAge = (EditText) findViewById(R.id.etAge);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etName = (EditText) findViewById(R.id.etName);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    public void save(){
        DatabaseHandler db = new DatabaseHandler(this);
        //if(!db.containsUserName(etUserName.getText().toString())){
            String aUserName = etUserName.getText().toString();
            String aName = etName.getText().toString();
            String aPassword = etPassword.getText().toString();
            String anAge = etAge.getText().toString();
            db.addUser(new User(aUserName,aName,aPassword));
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
        /*}
        else {
            Toast.makeText(this,"Username already used", Toast.LENGTH_LONG).show();
        }*/

    }

}
