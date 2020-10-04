package com.ahmednabil.androidarchitecturecomponentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ahmednabil.androidarchitecturecomponentsdemo.database.Task;
import com.ahmednabil.androidarchitecturecomponentsdemo.database.TaskDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskRecyclerViewAdapter.OnTaskClickListener{
    private RecyclerView recyclerView;
    TaskRecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new TaskRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                adapter.setTasks(tasks);
            }
        });
    }

    @Override
    public void onTaskClick(int position) {
//        startActivity(new Intent(MainActivity.this, AddNewTaskActivity.class));
    }
}