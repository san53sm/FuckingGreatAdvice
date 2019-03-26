package com.example.fuckinggreatadvice.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fuckinggreatadvice.pojo.Advice;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface AdviceDao {
    @Query("SELECT * FROM advice")
    LiveData<List<Advice>> getAll();

    @Insert
    void insert(Advice advice);

    @Delete
    void delete(Advice advice);
}
