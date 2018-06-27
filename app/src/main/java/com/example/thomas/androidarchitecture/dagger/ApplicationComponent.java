package com.example.thomas.androidarchitecture.dagger;

import com.example.thomas.androidarchitecture.fragments.UserProfileFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RepositoriesModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    void inject(UserProfileFragment userProfileFragment);
}
