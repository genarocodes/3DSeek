package edu.utsa.cs3443.a3dseek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<SearchResponse.Post> posts;
    private Context context;

    public PostAdapter(List<SearchResponse.Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchResponse.Post post = posts.get(position);
        holder.title.setText(post.getName());

        // Using Glide to load the thumbnail and setting a placeholder
        Glide.with(context)
                .load(post.getThumbnail()) // URL or file path
                .apply(new RequestOptions().placeholder(R.drawable.placeholder_background)) // Reference to the vector background
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Method to update the posts
    public void updatePosts(List<SearchResponse.Post> newPosts) {
        this.posts = newPosts;
        notifyDataSetChanged();  // Notify the adapter that the data has changed
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
