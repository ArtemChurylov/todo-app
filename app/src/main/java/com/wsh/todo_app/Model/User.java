package com.wsh.todo_app.Model;

import java.util.Map;

public class User {

    private int id;
    private String username;
    private String password;
    private Map<Integer, ToDoModel> tasks;

    public User(int id, String username, String password, Map<Integer, ToDoModel> tasks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<Integer, ToDoModel> getTasks() {
        return tasks;
    }
}
