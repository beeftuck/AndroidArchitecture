package com.example.thomas.androidarchitecture.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.thomas.androidarchitecture.data.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);

    @Query("SELECT * FROM user WHERE login = :login")
    LiveData<User> getByLogin(String login);
}
