package edu.utsa.cs3443.a3dseek;

import com.google.gson.annotations.SerializedName;

public class TotalPostCountResponse {

    @SerializedName("total_count")
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
