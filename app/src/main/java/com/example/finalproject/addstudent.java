package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class addstudent extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText nameEditText, mobileEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);

        databaseHelper = new DatabaseHelper(this);

        nameEditText = findViewById(R.id.nameEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();
                if (!name.isEmpty() && !mobile.isEmpty()) {
                    databaseHelper.addStudent(name, mobile);
                    Toast.makeText(addstudent.this, "Student added successfully", Toast.LENGTH_SHORT).show();
                    nameEditText.setText("");
                    mobileEditText.setText("");
                } else {
                    Toast.makeText(addstudent.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

