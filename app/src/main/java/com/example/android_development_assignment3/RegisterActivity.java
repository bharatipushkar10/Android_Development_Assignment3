package com.example.android_development_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText name, pass;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.edit_email);
        pass = findViewById(R.id.edit_pass);
        signup = findViewById(R.id.button_signin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usern = name.getText().toString();
                String passw = pass.getText().toString();
                SharedPreferences sp = getSharedPreferences("xyz", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("username", usern);
                ed.putString("password", passw);
                ed.apply();
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}