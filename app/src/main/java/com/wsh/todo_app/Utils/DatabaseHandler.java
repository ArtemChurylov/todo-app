package com.wsh.todo_app.Utils;

import com.wsh.todo_app.Model.ToDoModel;
import com.wsh.todo_app.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseHandler {

    public static User currentUser;

    private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(2);

    public void insertTask(ToDoModel task){
        int taskId = ID_SEQUENCE.incrementAndGet();
        task.setId(taskId);
        currentUser.getTasks().put(taskId, task);
    }

    public List<ToDoModel> getAllTasks(){
        return new ArrayList<>(currentUser.getTasks().values());
    }

    public void updateStatus(int id, int status){
        ToDoModel toDoModel = currentUser.getTasks().get(id);
        toDoModel.setStatus(status);
        currentUser.getTasks().put(id, toDoModel);
    }

    public void updateTask(int id, String task) {
        ToDoModel toDoModel = currentUser.getTasks().get(id);
        toDoModel.setTask(task);
        currentUser.getTasks().put(id, toDoModel);
    }

    public void deleteTask(int id){
        currentUser.getTasks().remove(id);
    }
}
