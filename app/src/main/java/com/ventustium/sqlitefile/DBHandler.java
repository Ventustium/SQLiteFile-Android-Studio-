package com.ventustium.sqlitefile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MyDB";

    private static final String TB_NAME = "Users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_PASS = "password";

    public DBHandler(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TB_NAME+"("+KEY_ID+
                " INTEGER PRIMARY KEY,"+KEY_NAMA+" TEXT,"+KEY_PASS+" TEXT"+")";
        Log.d("SQLITE", "CREATE DATABASE");
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }


//    public boolean insertUser(String nama, String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("nama", nama);
//        cv.put("password", password);
//        db.insert(TB_NAME,null, cv);
//        db.close();
//        return true;
//    }

    public void insertUser(DataModel user){
        Log.d("SQLITE", "INSERTING USER");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAMA, user.getNama());
        cv.put(KEY_PASS, user.getPassword());
        db.insert(TB_NAME,null, cv);
        db.close();
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM"+TB_NAME+" WHERE id="+id, null);
    }

    public int getDataCount(){
        String query = "SELECT * FROM "+TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c =db.rawQuery(query,null);
        int count = c.getCount();
        c.close();

        return count;
    }

    public List<DataModel> getAll(){
        List<DataModel> userList = new ArrayList<>();
        String query = "SELECT * FROM "+TB_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                DataModel u = new DataModel();
                u.setId(Integer.parseInt(c.getString(0)));
                u.setNama(c.getString(1));
                u.setPassword(c.getString(2));
                userList.add(u);
            } while (c.moveToNext());
        }
        c.close();
        return userList;
    }
}
