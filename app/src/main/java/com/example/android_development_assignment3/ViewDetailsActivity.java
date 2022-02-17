package com.example.android_development_assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        readStudentData();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(this, studentsDatalist));
    }

    private List<StudentsData> studentsDatalist = new ArrayList<>();

    private void readStudentData() {
        InputStream inputStream = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
//read the data
                StudentsData students = new StudentsData();
                students.setName(tokens[0]);
                students.setAddress(tokens[1]);
                students.setFaculty(tokens[2]);
                students.setSemester(tokens[3]);
                studentsDatalist.add(students);

                Log.d("MyActivity", "just created:" + students);

            }

        } catch (IOException e) {
            Log.wtf("MyActivity", "error reading data file" + line, e);
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            SharedPreferences sp = getSharedPreferences("state", MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putBoolean("loginstate", false);
            ed.apply();
            Intent i = new Intent(ViewDetailsActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}