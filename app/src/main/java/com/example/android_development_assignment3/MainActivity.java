package com.example.android_development_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLogin();
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_pass);
        login = findViewById(R.id.button_login);
        signup = findViewById(R.id.button_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(sign);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("xyz", Context.MODE_PRIVATE);
                String username = sp.getString("username", "aakash");
                String upassword = sp.getString("password", "aakash");
                String Uusername = email.getText().toString();
                String Upassword = password.getText().toString();
                if (username.equals(Uusername) && upassword.equals(Upassword)) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences a = getSharedPreferences("state", MODE_PRIVATE);
                    SharedPreferences.Editor ed = a.edit();
                    ed.putBoolean("loginstate", true);
                    ed.apply();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkLogin() {
        SharedPreferences sp = getSharedPreferences("state", MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate", false);
        if (state) {
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }

}