package com.example.thomas.androidarchitecture.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;
import android.widget.TextView;

import com.example.thomas.androidarchitecture.data.User;
import com.example.thomas.androidarchitecture.repository.UserRepository;

import javax.inject.Inject;

public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;
    private UserRepository userRepository;

    @Inject
    public UserProfileViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void init(String userId) {
//        if (this.user != null) {
//            // ViewModel is created per Fragment so
//            // we know the userId won't change
//            return;
//        }

        user = userRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }

    public String getName() {

        if (user.getValue() == null) {
            return "Pending";
        }

        return user.getValue().getLogin();
    }

    public String getLastUpdated() {
        if (user.getValue() == null) {
            return "Unknown";
        }

        return user.getValue().getLastUpdated().toString();
    }

    public void onGetUserDetailsClicked() {
        init(user.getValue().getLogin());
    }

}
