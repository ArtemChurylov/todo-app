package com.wsh.todo_app.Utils;


import com.wsh.todo_app.Model.ToDoModel;
import com.wsh.todo_app.Model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersData {

    public static List<User> users;

    static {
        Map<Integer, ToDoModel> tasks = new HashMap<>();
        tasks.put(1, new ToDoModel(1, 0, "Sleep whole day"));
        tasks.put(2, new ToDoModel(2, 1, "Test task"));
        users = Arrays.asList(
                new User(1,"Test", "1", "test1", "test1", "user", tasks),
                new User(2,"Test", "2", "test2", "test2", "manager", new HashMap<>())
        );
    }
}
