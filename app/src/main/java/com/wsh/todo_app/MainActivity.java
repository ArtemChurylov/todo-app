package com.wsh.todo_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.wsh.todo_app.Utils.UsersData;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        AppCompatButton loginbtn = (AppCompatButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(view ->
                UsersData.users.stream()
                        .filter(user -> user.getUsername().equals(username.getText().toString()))
                        .findFirst()
                        .map(user -> {
                            if (user.getPassword().equals(password.getText().toString())) {
                                Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, TaskActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                            }
                            return user;
                        })
                        .orElseGet(() -> {
                            Toast.makeText(MainActivity.this, "Username doesn't exist", Toast.LENGTH_SHORT).show();
                            return null;
                        })
        );
    }
}