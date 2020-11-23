package pl.damiankoski.androidblogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Database database;
    RecyclerView postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(openOrCreateDatabase("blogApp.db", MODE_PRIVATE, null));
        ArrayList<Post> posts = database.queryPosts();

        postsList = findViewById(R.id.posts_list);
        PostsAdapter postsAdapter = new PostsAdapter(this, posts);
        postsList.setAdapter(postsAdapter);
        postsList.setLayoutManager(new LinearLayoutManager(this));
     }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Post> posts = database.queryPosts();
        PostsAdapter postsAdapter = new PostsAdapter(this, posts);
        postsList.setAdapter(postsAdapter);
    }

    public void OnCrateButtonClick(View v){
         Intent intent = new Intent(this,AddPost.class);
         startActivity(intent);
     }
}