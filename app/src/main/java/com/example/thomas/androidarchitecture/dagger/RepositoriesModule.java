package com.example.thomas.androidarchitecture.dagger;


import com.example.thomas.androidarchitecture.repository.UserRepository;
import com.example.thomas.androidarchitecture.repository.UserRepositoryImplementation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class RepositoriesModule {

    @Provides
    @Singleton
    static UserRepository provideUserRepository() {
        return new UserRepositoryImplementation();
    }
}
