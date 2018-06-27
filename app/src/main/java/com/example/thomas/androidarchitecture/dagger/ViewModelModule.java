package com.example.thomas.androidarchitecture.dagger;

import android.arch.lifecycle.ViewModel;

import com.example.thomas.androidarchitecture.annotations.ViewModelKey;
import com.example.thomas.androidarchitecture.repository.UserRepository;
import com.example.thomas.androidarchitecture.viewmodel.UserProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Provides
    public static UserProfileViewModel provideUserProfileViewModel(UserRepository userRepository) {
        return new UserProfileViewModel(userRepository);
    }

}
