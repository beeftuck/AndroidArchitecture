package com.example.thomas.androidarchitecture.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.thomas.androidarchitecture.data.converters.Converters;
import com.example.thomas.androidarchitecture.data.dao.UserDao;

@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ArchitectureDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
