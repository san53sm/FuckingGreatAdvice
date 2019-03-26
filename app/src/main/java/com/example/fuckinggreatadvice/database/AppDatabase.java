package com.example.fuckinggreatadvice.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.fuckinggreatadvice.database.dao.AdviceDao;
import com.example.fuckinggreatadvice.pojo.Advice;

@Database(entities = {Advice.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AdviceDao adviceDao();
}
