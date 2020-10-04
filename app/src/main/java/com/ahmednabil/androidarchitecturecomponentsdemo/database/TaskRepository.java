package com.ahmednabil.androidarchitecturecomponentsdemo.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDatabase taskDb;
    private LiveData<List<Task>> allTasks;

    public TaskRepository(Context context) {
        taskDb = TaskDatabase.getInstance(context);
        allTasks = taskDb.taskDao().getAllTasks();
    }

// TODO
//    public Task getTaskById(int id) {
//
//    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        new InsertTaskAsyncTask(taskDb).execute(task);
    }

    public void update(Task task) {
        new UpdateTaskAsyncTask(taskDb).execute(task);
    }

    public void deleteTask(Task task) {
        new DeleteTaskAsyncTask(taskDb).execute(task);
    }
//  TODO
//    public void deleteTaskById(int id) {
//
//    }

    public void deleteAllTasks() {
        new DeleteAllTasksAsyncTask(taskDb).execute();
    }

    private static class InsertTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDatabase taskDb;

        private InsertTaskAsyncTask(TaskDatabase taskDb) {
            this.taskDb = taskDb;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDb.taskDao().insertTask(tasks[0]);
            return null;
        }
    }

    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDatabase taskDb;

        private UpdateTaskAsyncTask(TaskDatabase taskDb) {
            this.taskDb = taskDb;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDb.taskDao().updateTask(tasks[0]);
            return null;
        }
    }

    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDatabase taskDb;

        private DeleteTaskAsyncTask(TaskDatabase taskDb) {
            this.taskDb = taskDb;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDb.taskDao().deleteTask(tasks[0]);
            return null;
        }
    }

    private static class GetTaskByIdAsyncTask extends AsyncTask<Integer, Void, Task> { // TODO 1
        private TaskDatabase taskDb;
        private GetTaskByIdAsyncTask(TaskDatabase taskDb) {
            this.taskDb = taskDb;
        }

        @Override
        protected Task doInBackground(Integer... integers) {
            taskDb.taskDao().getTaskById(integers[0]);
            return null;
        }
    }

    private static class DeleteAllTasksAsyncTask extends AsyncTask<Void, Void, Void> {
        private TaskDatabase taskDb;
        private DeleteAllTasksAsyncTask(TaskDatabase taskDb) {
            this.taskDb = taskDb;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            taskDb.taskDao().deleteAllTasks();
            return null;
        }
    }
}
