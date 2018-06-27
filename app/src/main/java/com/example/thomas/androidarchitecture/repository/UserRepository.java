package com.example.thomas.androidarchitecture.repository;

import android.arch.lifecycle.LiveData;

import com.example.thomas.androidarchitecture.data.User;

public interface UserRepository {

    LiveData<User> getUser(String userId);

}
