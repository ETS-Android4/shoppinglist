package com.example.databasesd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;


public class databaseexample extends SQLiteOpenHelper {

    // The Android's default system path of your application database.

    private String DB_PATH;
    private String DB_NAME;
    private SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param
     */
    public databaseexample(Context p, String dbname) {
        super(p, dbname + ".db", null, 1);
        DB_NAME = dbname + ".db";
    }

    public String getNow(){
        return sdf.format(new java.util.Date());
    }

    public Cursor doQuery(String sql, String[] params) {
        //getting data from DB using SQL + Parameters
        try {
            Cursor mCur = getReadableDatabase().rawQuery(sql, params);
            return mCur;
        } catch (SQLException mSQLException) {
            System.err.println("-- doQuery --\n"+sql);
            mSQLException.printStackTrace(System.err);
            return null;
        }
    }

    public void doUpdate(String sql, String[] params) {
        //inserting data into DB via SQL + parameters
        try {
            getWritableDatabase().execSQL(sql, params);
        } catch (SQLException mSQLException) {
            System.err.println("-- doUpdate --\n"+sql);
            mSQLException.printStackTrace(System.err);
        }
    }


    public Cursor doQuery(String sql) {
        //Getting data from DB using SQL string
        try {
            Cursor mCur = getReadableDatabase().rawQuery(sql,null);
            return mCur;
        } catch (SQLException mSQLException) {
            System.err.println("-- doQuery --\n"+sql);
            mSQLException.printStackTrace();
            return null;
        }
    }

    public void doUpdate(String sql) {
        //adding data to DB via SQL string
        try {
            this.getWritableDatabase().execSQL(sql);
        } catch (SQLException mSQLException) {
            System.err.println("-- doUpdate --\n"+sql);
            mSQLException.printStackTrace(System.err);
        }
    }

    public long getSize()
    {
        /* Open the database object in "read" mode. */
        final SQLiteDatabase db = getReadableDatabase();

        /* Get length of database file. */
        final String dbPath       = db.getPath();
        final File   dbFile       = new File(dbPath);
        final long   dbFileLength = dbFile.length();

        return (dbFileLength);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //DB details via SQL
        db.execSQL("Create table items" +
                "(item_id int PRIMARY KEY , " +
                "name text not null, " +
                "quantity int not null, " +
                "list_id_items_table int not null, " +
                "FOREIGN KEY(list_id_items_table)REFERENCES shoppingList(List_id))");
        db.execSQL("Create table shoppingList" +
                "(list_id PRIMARY KEY , " +
                "list_name text not null," +
                "d_o_s date not null," +
                "item_id int not null," +
                "FOREIGN KEY(item_id)REFERENCES items(item_id))");

    }

    public SQLiteDatabase getDB(){
        return getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }


}
