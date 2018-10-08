package com.example.admin.userdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database extends SQLiteOpenHelper {
    public static final String DB_NAME = "MYDATABASE";
    public static final String TABLE_NAME = "USER";

    public static final String USER_NAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String EMAIL_ID = "EMAIL_ID";
    public static final String PHONE_NO = "PHONE_NO";


    ArrayList<String> arrayList = new ArrayList<>();

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "("
                + USER_NAME + " TEXT, "
                + PASSWORD + " TEXT, "
                + EMAIL_ID + " TEXT PRIMARY KEY, "
                + PHONE_NO + " TEXT "
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public String saveData(String username, String password, String emailId, String phoneno) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, username);
        values.put(PASSWORD, password);
        values.put(EMAIL_ID, emailId);
        values.put(PHONE_NO, phoneno);

        sqLiteDatabase.insert(TABLE_NAME, null, values);

        return "Data has been saved in SQLite DB";

    }

    public ArrayList<String> getData() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT USERNAME FROM USER", null);

        if (cursor != null && cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                arrayList.add(cursor.getString(0));
                cursor.moveToNext();
            }
        }
        return arrayList;
    }


    public ArrayList<Map<String, String>> getUserData(String username) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();

                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE USERNAME = ? ", new String[]{username});


        if (cursor != null && cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                Map<String, String> map = new HashMap();
                map.put(USER_NAME, cursor.getString(0));
                map.put(PASSWORD, cursor.getString(1));
                map.put(EMAIL_ID, cursor.getString(2));
                map.put(PHONE_NO, cursor.getString(3));

                arrayList.add(map);

                cursor.moveToNext();
            }
        }
        return arrayList;
    }

    public boolean authenticateUser(String emailId, String password) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor=null;
        int count=0;
        cursor=sqLiteDatabase.rawQuery("select * from USER where EMAIL_ID ='"+emailId+"' and PASSWORD ='"+password+"'",null);
        cursor.moveToFirst();
        Log.d("IN ************", String.valueOf(cursor.getCount()));
        if (cursor!=null){
            count=cursor.getCount();
        }
        if(count==1)
            return true;
        else
            return false;
    }
}




