package com.example.tushar.sol;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tushar on 15-12-2016.
 */
public class SOL implements Serializable {

    @SerializedName("SOL_ROLL_NO")
     String roll;

    @SerializedName("TEL_NO")
    String tele;

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}
