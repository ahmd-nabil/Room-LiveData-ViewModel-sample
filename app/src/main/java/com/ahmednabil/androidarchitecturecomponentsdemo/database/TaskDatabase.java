package com.ahmednabil.androidarchitecturecomponentsdemo.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    private static TaskDatabase taskDbInstance;
    private static final String DB_NAME = "tasks_list";

    public static TaskDatabase getInstance(Context context) {
        if (taskDbInstance == null)
            synchronized (RoomDatabase.class) {
                taskDbInstance = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, DB_NAME).build();
            }
        return taskDbInstance;
    }

    public abstract TaskDao taskDao();
}
