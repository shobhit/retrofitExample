package com.mygola.retrofitexample;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by shobhit on 3/25/15.
 */
public interface JsonPlaceHolder {
    @GET("/users")

    public void getUsers(Callback<List<Users>> response);

}
