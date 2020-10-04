package com.ahmednabil.androidarchitecturecomponentsdemo.database;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String content;
    private int priority;


    public Task(int id, String title, String content, int priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.priority = priority;
    }

    @Ignore
    public Task(String title, String content, int priority) {
        this.title = title;
        this.content = content;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }
}
