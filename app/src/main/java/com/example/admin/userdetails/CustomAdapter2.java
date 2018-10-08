package com.example.admin.userdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class CustomAdapter2 extends BaseAdapter {

    Context context;
    ArrayList<Map<String,String>> arrayList;

    public CustomAdapter2(Context context, ArrayList<Map<String,String>> arr){
        this.context=context;
        this.arrayList=arr;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View  myView;

        view= LayoutInflater.from(context).inflate(R.layout.my_list_xml2,viewGroup,false);

        TextView t1=view.findViewById(R.id.t1);
        TextView t2=view.findViewById(R.id.t2);
        TextView t3=view.findViewById(R.id.t3);
        TextView t4=view.findViewById(R.id.t4);


        t1.setText(arrayList.get(i).get(Database.USER_NAME));
        t2.setText(arrayList.get(i).get(Database.PASSWORD));
        t3.setText(arrayList.get(i).get(Database.EMAIL_ID));
        t4.setText(arrayList.get(i).get(Database.PHONE_NO));

        myView=view;
        return myView;
    }
}


