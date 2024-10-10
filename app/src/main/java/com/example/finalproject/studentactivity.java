package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class studentactivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private Button btnAddstudent, btnViewstudent, btnCallstudent, btnMessagestudent, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentactivity);

        databaseHelper = new DatabaseHelper(this);

        btnAddstudent = findViewById(R.id.btnAddStudent);
        btnViewstudent = findViewById(R.id.btnViewStudent);
        btnCallstudent = findViewById(R.id.btnCallStudent);
        btnMessagestudent = findViewById(R.id.btnMessageStudent);
        btnLogout = findViewById(R.id.btnLogout);

        btnAddstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(studentactivity.this, addstudent.class);
                startActivity(intent);
            }
        });

        btnViewstudent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(studentactivity.this, viewstudent.class);
                startActivity(intent);
            }
        });

        btnCallstudent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(studentactivity.this, callstudent.class);
                startActivity(intent);
            }
        });

        btnMessagestudent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(studentactivity.this, messagestudent.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(studentactivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}

