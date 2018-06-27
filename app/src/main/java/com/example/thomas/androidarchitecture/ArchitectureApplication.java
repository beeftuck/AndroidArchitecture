package com.example.thomas.androidarchitecture;

import android.app.Application;

import com.example.thomas.androidarchitecture.dagger.ApplicationComponent;
import com.example.thomas.androidarchitecture.dagger.DaggerApplicationComponent;

public class ArchitectureApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
