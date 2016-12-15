package com.example.tushar.sol;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tushar on 15-12-2016.
 */
public class ApiClient {


    private static ApiClientInterface mService;

    public static ApiClientInterface getInterface() {
        if (mService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.32.2.52/WebService.asmx/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            mService = retrofit.create(ApiClientInterface.class);
        }
        return mService;
    }
}
