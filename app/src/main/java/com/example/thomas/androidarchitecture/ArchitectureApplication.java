package com.example.thomas.androidarchitecture;

import android.app.Application;

import com.example.thomas.androidarchitecture.dagger.ApplicationComponent;
import com.example.thomas.androidarchitecture.dagger.ApplicationModule;
import com.example.thomas.androidarchitecture.dagger.DaggerApplicationComponent;
import com.facebook.stetho.Stetho;

public class ArchitectureApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
