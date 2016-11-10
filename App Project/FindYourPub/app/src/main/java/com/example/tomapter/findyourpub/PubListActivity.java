package com.example.tomapter.findyourpub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PubListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] pubNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_list);

        pubNames = getResources().getStringArray(R.array.pub_name_coventry);

        listView = (ListView) findViewById(R.id.pub_name_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pubNames);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(), pubNames[position] + " is a good pub!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }


}
