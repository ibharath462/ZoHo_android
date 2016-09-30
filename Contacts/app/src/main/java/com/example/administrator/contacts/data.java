package com.example.administrator.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 9/30/2016.
 */

public class data extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Contacts";
    private static final int DATABASE_VERSION = 1;

    public data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static final String contacts = "contacts";
    private static final String fname = "fname";
    private static final String lname = "lname";
    private static final String mobile = "mobile";
    private static final String mail = "mail";
    private static final String image = "image";
    private static final String id = "id";
    private static final String home = "home";
    private static final String fav = "fav";

    private static final String CREATE_contacts="CREATE TABLE "+contacts+"("+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+fname+" TEXT, "+lname+" TEXT, "+mobile+" TEXT, "+mail+" TEXT,"+home+" TEXT, "+image+" TEXT, "+fav+" INTEGER)";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_contacts);
        Log.d("DB", "DB created..");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + contacts);
        onCreate(db);
    }

    public void addContact(String fn,String ln,String mo,String ma,String ho,String im){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(fname,fn);
        cv.put(lname,ln);
        cv.put(mobile,mo);
        cv.put(mail,ma);
        cv.put(image,im);
        cv.put(home,ho);
        cv.put(fav,0);

        db.insert(contacts, null, cv);

        Log.d("Inserted:", "DB values inserted..");
        db.close();
    }

    public ArrayList<ArrayList<String>> get(int ch){

        String selectQuery=null;


        if(ch==1){
            selectQuery = "SELECT  * FROM " + contacts+" WHERE id!=1 ORDER BY fname";
        }
        else if(ch==0){

            selectQuery = "SELECT  * FROM " + contacts+" WHERE "+id+"=1";
        }
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        final ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> t=new ArrayList<String>();
                t.add(cursor.getString(1));
                t.add(cursor.getString(2));
                t.add(cursor.getString(3));
                t.add(cursor.getString(4));
                t.add(cursor.getString(5));
                t.add(cursor.getString(6));
                Log.d("DB:",""+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3));
                list.add(t);

            } while (cursor.moveToNext());
        }
        return  list;
    }

    public ArrayList<ArrayList<String>> search(String q){
        String selectQuery = "SELECT  * FROM " + contacts+" WHERE id!=1 AND "+fname+" LIKE '"+q+"%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        final ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> t=new ArrayList<String>();
                t.add(cursor.getString(1));
                t.add(cursor.getString(2));
                t.add(cursor.getString(3));
                t.add(cursor.getString(4));
                t.add(cursor.getString(5));
                t.add(cursor.getString(6));
                Log.d("DB:",""+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3));
                list.add(t);

            } while (cursor.moveToNext());
        }
        return list;
    }

    public Cursor sort(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sort="SELECT * FROM contacts ORDER BY fname";
        Cursor cursor = db.rawQuery(sort, null);
        return cursor;
    }

}
