package pl.damiankoski.androidblogapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.IDN;
import java.text.SimpleDateFormat;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.DoubleBinaryOperator;

public  class Database   {
    private SQLiteDatabase db;
    
    public Database(SQLiteDatabase db) {
        this.db = db;
        onCreate();
    }

    
    private void onCreate() {
        String query = "CREATE TABLE IF NOT EXISTS posts (\n" +
                "    post_id       INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    title         TEXT NOT NULL,\n" +
                "    author        TEXT NOT NULL,\n" +
                "    creation_date DATE NOT NULL DEFAULT (datetime('now','localtime')),\n" +
                "    content       TEXT NOT NULL\n" +
                ");";
        db.execSQL(query);
    }
    

    public Post QueryPosts(int id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String query = "SELECT * FROM Post WHERE post_id = " + id;
        
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        try {
            return new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), simpleDateFormat.parse(cursor.getString(4)));
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Post> QueryPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String query = "SELECT * FROM Posts";
        Cursor cursor = null;
        cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            try {
                posts.add(new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), simpleDateFormat.parse(cursor.getString(4))));
            } catch (Exception e) {
                
            }
            //cursor.moveToNext();
        }
         return posts;
    }


}
