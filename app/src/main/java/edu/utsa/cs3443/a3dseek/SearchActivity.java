package edu.utsa.cs3443.a3dseek;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private ProgressBar progressBar;

    private static final long DEBOUNCE_DELAY = 500; // 500ms debounce delay
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchInput = findViewById(R.id.search_input);
        searchButton = findViewById(R.id.search_button);
        recyclerView = findViewById(R.id.results_recycler_view);
        progressBar = findViewById(R.id.progress_bar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter with an empty list for now
        adapter = new PostAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // TextWatcher for dynamic search
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String query = charSequence.toString().trim();
                if (!query.isEmpty()) {
                    performSearch(query);  // Trigger search every time the text changes
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void performSearch(String query) {
        if (searchRunnable != null) {
            handler.removeCallbacks(searchRunnable); // Remove previous search request
        }

        searchRunnable = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE); // Show progress bar when performing the search
                ThingiverseApi api = ApiClient.getClient().create(ThingiverseApi.class);
                api.searchPosts(query, 200, 1).enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                        progressBar.setVisibility(View.GONE);  // Hide progress bar when response is received

                        if (response.isSuccessful() && response.body() != null) {
                            List<SearchResponse.Post> posts = response.body().getHits();
                            if (posts.isEmpty()) {
                                Toast.makeText(SearchActivity.this, "No posts found", Toast.LENGTH_SHORT).show();
                            }
                            adapter.updatePosts(posts);
                        } else {
                            Toast.makeText(SearchActivity.this, "Failed to fetch results", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SearchActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        handler.postDelayed(searchRunnable, DEBOUNCE_DELAY); // Perform search after the delay
    }
}
