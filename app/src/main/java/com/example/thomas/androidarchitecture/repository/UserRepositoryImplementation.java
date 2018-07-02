package com.example.thomas.androidarchitecture.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.thomas.androidarchitecture.ArchitectureApplication;
import com.example.thomas.androidarchitecture.data.User;
import com.example.thomas.androidarchitecture.data.dao.UserDao;
import com.example.thomas.androidarchitecture.network.GithubWebService;

import java.util.Date;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryImplementation implements UserRepository {

    @Inject
    public GithubWebService githubWebService;

    @Inject
    public UserDao userDao;

    public UserRepositoryImplementation() {
        ArchitectureApplication.getApplicationComponent().inject(this);
    }

    @Override
    public LiveData<User> getUser(final String userId) {
        // This is not an optimal implementation, we'll fix it below
        final LiveData<User> user = userDao.getByLogin(userId, 5);

        //TODO: Implement timeout
        //TODO: Test that changes to user are published by LiveData
        if (user == null || user.getValue() == null) {
            githubWebService.getUser(userId).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, final Response<User> response) {
                    //TODO: Would it be better to use an async task here?
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            response.body().setLastUpdated(new Date());
                            userDao.save(response.body());
                        }
                    }).start();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("ERROR", t.getMessage());
                    //TODO:
                }
            });
        }

        return user;
    }

}
