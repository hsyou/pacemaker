package com.example.hs.pacemaker.search;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2016-02-03.
 */
public class HistoryDBHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME="HistoryManager";
    private static final String TABLE_HISTORY="History";
    private static final String KEY_HISTORY = "history";
    Context mContext=null;
    private static HistoryDBHandler handler=null;

    public static HistoryDBHandler getInstance(Context context){
        if(handler==null){
            handler=new HistoryDBHandler(context,DB_NAME,null,DATABASE_VERSION);
        }
        return handler;
    }

    public HistoryDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HISTORY + "("+KEY_HISTORY+" TEXT);";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(String str) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        List<String> list=getAllContacts();
        if(list.contains(str.toString())){
            db.delete(TABLE_HISTORY, KEY_HISTORY + "=?",
                    new String[]{str});
        }
        values.put(KEY_HISTORY, str); // Contact Name

        // Inserting Row
        db.insert(TABLE_HISTORY, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Contacts
    public List<String> getAllContacts() {
        List<String> list = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HISTORY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
               // Adding contact to list
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // return contact list
        return list;
    }


    // Deleting single contact
    public void deleteContact(String str) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HISTORY, KEY_HISTORY + "=?",
                new String[]{str});
        db.close();
    }

}
