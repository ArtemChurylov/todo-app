package com.wsh.todo_app.Utils;


import com.wsh.todo_app.Model.User;

import java.util.Arrays;
import java.util.List;

public class UsersData {

    public static List<User> users;

    static {
       users = Arrays.asList(
               new User("Test", "1", "test1", "test1", "user"),
               new User("Test", "2", "test2", "test2", "manager")
       );
    }
}
