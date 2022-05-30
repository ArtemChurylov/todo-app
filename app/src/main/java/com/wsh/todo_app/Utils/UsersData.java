package com.wsh.todo_app.Utils;


import com.wsh.todo_app.Model.ToDoModel;
import com.wsh.todo_app.Model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersData {

    private static final AtomicInteger ID_SEQUENCE = new AtomicInteger(2);

    public static List<User> users = new ArrayList<>();

    static {
        Map<Integer, ToDoModel> tasks = new HashMap<>();
        tasks.put(1, new ToDoModel(1, 0, "Sleep whole day"));
        tasks.put(2, new ToDoModel(2, 1, "Test task"));
        users.add(new User(1, "test1", "test1", tasks));
        users.add(new User(2, "test2", "test2", new HashMap<>()));
    }


    public static User createNewUser(String username, String password) {
        User user = new User(ID_SEQUENCE.incrementAndGet(), username, password, new HashMap<>());
        users.add(user);
        return user;
    }
}
