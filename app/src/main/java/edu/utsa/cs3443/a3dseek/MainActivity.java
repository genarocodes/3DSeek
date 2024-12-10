package edu.utsa.cs3443.a3dseek;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView totalPostsCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPostsCountTextView = findViewById(R.id.total_posts_count);

        // Fetch and update the total post count
        fetchTotalPostCount();

        // Button to navigate to SearchActivity
        Button searchButton = findViewById(R.id.button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fetchTotalPostCount() {
        ThingiverseApi api = ApiClient.getClient().create(ThingiverseApi.class);

        // Define the search term
        String searchTerm = "3D models";  // Example query

        // Fetch the total post count based on the search term
        api.getTotalPostCount(searchTerm).enqueue(new Callback<TotalPostCountResponse>() {
            @Override
            public void onResponse(Call<TotalPostCountResponse> call, Response<TotalPostCountResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    int totalCount = response.body().getTotalCount();
                    totalPostsCountTextView.setText("Total Posts: " + totalCount);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch total posts count", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TotalPostCountResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
