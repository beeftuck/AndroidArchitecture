package com.example.thomas.androidarchitecture.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.thomas.androidarchitecture.data.User;
import com.example.thomas.androidarchitecture.network.Webservice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryImplementation implements UserRepository {

    private Webservice webservice;

    @Override
    public LiveData<User> getUser(String userId) {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();

        User user = new User("Thomas", "Searle");
        data.setValue(user);

        //TODO: Implement Retrofit
//        webservice.getUser(userId).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                data.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                //TODO:
//            }
//        });

        return data;
    }

}
