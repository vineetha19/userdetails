package com.example.admin.userdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arrayList;

    public CustomAdapter(Context context, ArrayList<String> arr){
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
        view= LayoutInflater.from(context).inflate(R.layout.my_list_xml,viewGroup,false);
        TextView textView=view.findViewById(R.id.t1);

        textView.setText(arrayList.get(i));

        myView=view;
        return myView;
    }
}





