package com.example.thomas.androidarchitecture.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.thomas.androidarchitecture.data.ArchitectureDatabase;
import com.example.thomas.androidarchitecture.data.dao.UserDao;
import com.example.thomas.androidarchitecture.data.migrations.Migrations;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class RoomModule {

    @Provides
    @Singleton
    static ArchitectureDatabase provideArchitectureDatabase(Application application) {
        return Room
                .databaseBuilder(application.getApplicationContext(), ArchitectureDatabase.class, "Architecture-Database")
                .addMigrations(Migrations.MIGRATION_1_TO_2)
                .build();
    }

    @Provides
    @Singleton
    static UserDao provideUserDao(ArchitectureDatabase architectureDatabase) {
        return architectureDatabase.userDao();
    }
}
