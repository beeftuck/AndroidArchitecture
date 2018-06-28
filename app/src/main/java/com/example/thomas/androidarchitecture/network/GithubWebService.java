package com.example.thomas.androidarchitecture.network;


import com.example.thomas.androidarchitecture.data.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubWebService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String username);

}
