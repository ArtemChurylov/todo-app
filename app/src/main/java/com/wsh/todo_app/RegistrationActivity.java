package com.wsh.todo_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.wsh.todo_app.Model.User;
import com.wsh.todo_app.Utils.DatabaseHandler;
import com.wsh.todo_app.Utils.UsersData;

import java.util.HashMap;

public class RegistrationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        AppCompatButton registrbtn = (AppCompatButton) findViewById(R.id.registrbtn);

        registrbtn.setOnClickListener(v -> {
            boolean isUsernameTaken = UsersData.users.stream()
                    .anyMatch(user -> user.getUsername().equals(username.getText().toString()));
            if (isUsernameTaken) {
                Toast.makeText(RegistrationActivity.this, "This username is already taken", Toast.LENGTH_SHORT).show();
            } else {
                DatabaseHandler.currentUser = UsersData.createNewUser(username.getText().toString(), password.getText().toString());
                Toast.makeText(RegistrationActivity.this, "Registration SUCCESSFUL", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
