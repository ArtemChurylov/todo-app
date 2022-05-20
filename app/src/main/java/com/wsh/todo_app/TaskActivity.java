package com.wsh.todo_app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wsh.todo_app.Adapters.ToDoAdapter;
import com.wsh.todo_app.Model.ToDoModel;
import com.wsh.todo_app.Utils.DatabaseHandler;


import java.util.List;
import java.util.Objects;

public class TaskActivity extends AppCompatActivity implements DialogCloseListener{

    private final DatabaseHandler db = new DatabaseHandler();

    private ToDoAdapter tasksAdapter;

    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        RecyclerView tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db, TaskActivity.this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        FloatingActionButton fab = findViewById(R.id.fab);

        taskList = db.getAllTasks();

        tasksAdapter.setTasks(taskList);

        fab.setOnClickListener((v) -> AddNewTask.newInstance().show(getSupportFragmentManager(), AddNewTask.TAG));

        AppCompatButton logoutbtn = (AppCompatButton) findViewById(R.id.logoutbtn);

        logoutbtn.setOnClickListener(v -> {
            DatabaseHandler.currentUser = null;
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList = db.getAllTasks();
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }
}