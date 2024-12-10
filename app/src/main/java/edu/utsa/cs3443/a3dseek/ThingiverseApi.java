package edu.utsa.cs3443.a3dseek;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ThingiverseApi {
    @GET("search")
    Call<SearchResponse> searchPosts(
            @Query("term") String query,
            @Query("per_page") int resultsPerPage,
            @Query("page") int page
    );

    // Method to get the total count of posts
    @GET("search")
    Call<TotalPostCountResponse> getTotalPostCount(
            @Query("term") String query
    );
}
