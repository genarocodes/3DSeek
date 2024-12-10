package edu.utsa.cs3443.a3dseek;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("hits")
    private List<Post> hits;

    public List<Post> getHits() {
        return hits;
    }

    public static class Post {
        @SerializedName("name")
        private String name;

        @SerializedName("thumbnail")
        private String thumbnail;

        public String getName() {
            return name;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "name='" + name + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    '}';
        }
    }
}
