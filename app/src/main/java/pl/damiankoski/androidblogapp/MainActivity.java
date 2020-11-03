package pl.damiankoski.androidblogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String titles[];
    String authors[];

    RecyclerView postsList;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.post_titles);
        titles = getResources().getStringArray(R.array.post_authors);

        postsList = findViewById(R.id.posts_list);

        PostsAdapter postsAdapter = new PostsAdapter(this, titles, authors);
     }
}