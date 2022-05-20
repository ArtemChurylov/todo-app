package com.wsh.todo_app.Model;

import java.util.Map;

public class User {

    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String role;
    private Map<Integer, ToDoModel> tasks;

    public User(int id, String name, String surname, String username, String password, String role, Map<Integer, ToDoModel> tasks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Map<Integer, ToDoModel> getTasks() {
        return tasks;
    }
}
