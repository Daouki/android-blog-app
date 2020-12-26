package pl.damiankoski.androidblogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReadPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);
        Intent intent = getIntent();
        ((TextView)findViewById(R.id.Title)).setText(intent.getStringExtra("title"));
        ((TextView)findViewById(R.id.Author)).setText(intent.getStringExtra("author"));
        ((TextView)findViewById(R.id.date)).setText(intent.getStringExtra("date"));
        ((TextView)findViewById(R.id.content)).setText(intent.getStringExtra("content"));
    }
}