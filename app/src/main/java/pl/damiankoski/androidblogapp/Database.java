package pl.damiankoski.androidblogapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Database {
    private final SQLiteDatabase db;

    public Database(SQLiteDatabase db) {
        this.db = db;
        onCreate();
    }

    private void onCreate() {
//        db.execSQL("DROP TABLE posts;");

        String query = "CREATE TABLE IF NOT EXISTS posts (\n" +
                "    post_id       INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    title         TEXT NOT NULL,\n" +
                "    author        TEXT NOT NULL,\n" +
                "    creation_date INTEGER NOT NULL,\n" +
                "    content       TEXT NOT NULL\n" +
                ");";
        db.execSQL(query);
    }

//    public Post queryPost(int id) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//        String query = "SELECT * FROM Post WHERE post_id = " + id;
//
//        Cursor cursor = null;
//        cursor = db.rawQuery(query, null);
//        try {
//            return new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), simpleDateFormat.parse(cursor.getString(4)));
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public ArrayList<Post> queryPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM Posts ORDER BY creation_date DESC";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            posts.add(new Post(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    new Date(cursor.getLong(3)),
                    cursor.getString(4)));
        }
        return posts;
    }

    public void insertPost(String title, String author, Date date, String content) {
        StringBuilder query = new StringBuilder();
        query
                .append("INSERT INTO posts (title, author, creation_date, content) VALUES ('")
                .append(title)
                .append("','")
                .append(author)
                .append("',")
                .append(date.getTime())
                .append(",'")
                .append(content)
                .append("')");
        db.execSQL(query.toString());
    }

//    public void removePost(Post post) {
//        String query = "DELETE FROM posts WHERE id = " + post.getId();
//        db.execSQL(query);
//    }

    public void Close() {
        db.close();
    }
}
