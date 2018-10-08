package com.example.admin.userdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class UserDetailsActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Map<String,String>> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent=getIntent();
        String username=intent.getStringExtra(UserListActivity.MSG_KEY);


        Database d = new Database(this);
        arrayList = new ArrayList<>();
        arrayList = d.getUserData(username);

        CustomAdapter2 customAdapter = new

                CustomAdapter2(this, arrayList);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(customAdapter);


    }
}


