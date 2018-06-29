package com.example.thomas.androidarchitecture.dagger;

import com.example.thomas.androidarchitecture.fragments.UserProfileFragment;
import com.example.thomas.androidarchitecture.repository.UserRepositoryImplementation;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, RepositoriesModule.class, RoomModule.class, ViewModelModule.class})
public interface ApplicationComponent  {

    void inject(UserProfileFragment userProfileFragment);

    void inject(UserRepositoryImplementation userRepositoryImplementation);
}
