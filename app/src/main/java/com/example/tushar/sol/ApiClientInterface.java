package com.example.tushar.sol;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tushar on 15-12-2016.
 */
public interface ApiClientInterface {

    @GET("GetMobileRegisterData?tel_no=9871")
    Call<JsonObject> getContacts();

}
