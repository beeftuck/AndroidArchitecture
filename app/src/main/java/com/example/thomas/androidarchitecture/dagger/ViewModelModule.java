package com.example.thomas.androidarchitecture.dagger;

import com.example.thomas.androidarchitecture.repository.UserRepository;
import com.example.thomas.androidarchitecture.viewmodel.UserProfileViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelModule {

    @Provides
    public static UserProfileViewModel provideUserProfileViewModel(UserRepository userRepository) {
        return new UserProfileViewModel(userRepository);
    }

}
