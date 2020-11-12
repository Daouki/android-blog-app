package pl.damiankoski.androidblogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class AddPost extends AppCompatActivity {

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        SQLiteDatabase db = this.openOrCreateDatabase("blogApp.db", MODE_PRIVATE, null);
        database = new Database(db);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.Close();
    }

    public void onBack(View v) {
        finish();
    }

    public void onClean(View v) {
        ((TextView)findViewById(R.id.postTitle)).setText("");
        ((TextView)findViewById(R.id.postAuthor)).setText("");
        ((CalendarView)findViewById(R.id.postDate)).setDate(new Date().getTime());
        ((EditText)findViewById(R.id.postContent)).setText("");
    }

    public void onCreatePost(View v) {
        TextView title = findViewById(R.id.postTitle);
        TextView author = findViewById(R.id.postAuthor);
        CalendarView date = findViewById(R.id.postDate);
        EditText content = findViewById(R.id.postContent);
        try {
            database.InsertPost(title.getText().toString(), author.getText().toString(), new Date(date.getDate()), content.getText().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        finish();
    }
}