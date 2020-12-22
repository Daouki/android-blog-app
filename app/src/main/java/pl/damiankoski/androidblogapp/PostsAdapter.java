package pl.damiankoski.androidblogapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    public static class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.post_title);
            author = itemView.findViewById(R.id.post_author);
        }
    }

    private final Context context;
    private final ArrayList<Post> posts;

    public PostsAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.title.setText(posts.get(position).getTitle());
        holder.author.setText(posts.get(position).getAuthor());
        View.OnClickListener onClickListener = new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy hh:mm");
                Intent intent = new Intent(context, ReadPostActivity.class);
                intent.putExtra("title",posts.get(position).getTitle());
                intent.putExtra("author",posts.get(position).getAuthor());
                intent.putExtra("content",posts.get(position).getPostContent());
                intent.putExtra("date",dateFormat.format(posts.get(position).getDateOfPost()));
                context.startActivity(intent);
            }
        };
        holder.title.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
