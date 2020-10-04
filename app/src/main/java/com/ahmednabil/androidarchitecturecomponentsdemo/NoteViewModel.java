package com.ahmednabil.androidarchitecturecomponentsdemo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahmednabil.androidarchitecturecomponentsdemo.database.Task;
import com.ahmednabil.androidarchitecturecomponentsdemo.database.TaskRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel { // why AndroidViewModel NOT ViewModel? because it has Application passed to it, which we will use in the db object.
    private TaskRepository repository;
    private LiveData<List<Task>> allTasks;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        Log.d("ViewModel", "Data was sent by viewmodel");
        return allTasks;
    }

    public void insertTask(Task task) {
        repository.insert(task);
    }

    public void updateTask(Task task) {
        repository.update(task);
    }

    public void deleteTask(Task task) {
        repository.deleteTask(task);
    }

    public void deleteAllTasks() {
        repository.deleteAllTasks();
    }
}
