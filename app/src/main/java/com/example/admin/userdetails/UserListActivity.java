package com.example.admin.userdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    ListView listView;
    TextView t1;
    ArrayList<String> arrayList;
    public  static  final  String MSG_KEY="MSGKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        arrayList = new ArrayList<>();
        final Database Database = new Database(this);

        arrayList = Database.getData();

        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(customAdapter);
        listView.setDivider(null);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                t1=view.findViewById(R.id.t1);

                String username=t1.getText().toString();

                startActivity(new Intent(UserListActivity.this,UserDetailsActivity.class).putExtra(MSG_KEY,username));




            }
        });



    }
}

