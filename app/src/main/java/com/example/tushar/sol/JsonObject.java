package com.example.tushar.sol;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Tushar on 15-12-2016.
 */
public class JsonObject {

    @SerializedName("Status")
    int status;

    @SerializedName("Data")
    ArrayList<SOL> data;

    public ArrayList<SOL> getData() {
        return data;
    }

    public void setData(ArrayList<SOL> data) {
        this.data = data;
    }
}
