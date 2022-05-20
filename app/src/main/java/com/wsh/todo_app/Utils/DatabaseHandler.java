package com.wsh.todo_app.Utils;


import com.wsh.todo_app.Model.ToDoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseHandler {

    private static final Map<Integer, ToDoModel> tasks = new HashMap<>();

    static {
        tasks.put(1, new ToDoModel(1, 0, "Sleep whole day"));
        tasks.put(2, new ToDoModel(2, 1, "Test task"));
    }
    private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(2);

    public void insertTask(ToDoModel task){
        int taskId = ID_SEQUENCE.incrementAndGet();
        task.setId(taskId);
        tasks.put(taskId, task);
    }

    public List<ToDoModel> getAllTasks(){
        return new ArrayList<>(tasks.values());
    }

    public void updateStatus(int id, int status){
        ToDoModel toDoModel = tasks.get(id);
        toDoModel.setStatus(status);
        tasks.put(id, toDoModel);
    }

    public void updateTask(int id, String task) {
        ToDoModel toDoModel = tasks.get(id);
        toDoModel.setTask(task);
        tasks.put(id, toDoModel);
    }

    public void deleteTask(int id){
        tasks.remove(id);
    }
}
