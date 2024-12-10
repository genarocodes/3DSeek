package edu.utsa.cs3443.a3dseek;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request originalRequest = chain.request();

                            // Using BuildConfig for accessing the API token
                            Request request = originalRequest.newBuilder()
                                    .header("Authorization", "Bearer " + BuildConfig.THINGIVERSE_APP_TOKEN)
                                    .build();

                            return chain.proceed(request);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.thingiverse.com/") // Base URL for the API
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ThingiverseApi getThingiverseApi() {
        return getClient().create(ThingiverseApi.class);
    }
}
