package pl.damiankoski.androidblogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String titles[];
    String authors[];
    Database database;
    RecyclerView postsList;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         SQLiteDatabase db = this.openOrCreateDatabase("blogApp.db",MODE_PRIVATE,null);
         database = new Database(db);
        setContentView(R.layout.activity_main);
         
        try {
            ArrayList<Post> arrayList = database.QueryPosts();
            arrayList.size();
        }catch (Exception e) {
            System.out.println(e);
        }
        
        
        titles = getResources().getStringArray(R.array.post_titles);
        titles = getResources().getStringArray(R.array.post_authors);

        postsList = findViewById(R.id.posts_list);

        PostsAdapter postsAdapter = new PostsAdapter(this, titles, authors);
     }
}