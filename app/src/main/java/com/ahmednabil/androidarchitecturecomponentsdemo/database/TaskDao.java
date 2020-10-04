package com.ahmednabil.androidarchitecturecomponentsdemo.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task ORDER BY priority DESC")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM task WHERE id = :id")
    Task getTaskById(int id);

    @Insert
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("DELETE FROM task")
    void deleteAllTasks();

    @Query("DELETE FROM task WHERE id = :id")
    void deleteTaskById(int id);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Task task);

}
