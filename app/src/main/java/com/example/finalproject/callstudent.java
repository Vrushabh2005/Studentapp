package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class callstudent extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private ListView studentListView;
    private ArrayAdapter<String> studentAdapter;
    private ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callstudent);

        databaseHelper = new DatabaseHelper(this);
        studentListView = findViewById(R.id.studentListView);
        studentList = new ArrayList<>();
        studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        studentListView.setAdapter(studentAdapter);

        displayAllStudents();

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedStudent = studentList.get(position);
                String[] parts = selectedStudent.split("\n");
                String mobile = parts[1].replace("Mobile: ", "").trim();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + mobile));
                startActivity(intent);
            }
        });
    }

    private void displayAllStudents() {
        Cursor cursor = databaseHelper.getAllStudents();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int mobileIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_MOBILE);

                if (nameIndex != -1 && mobileIndex != -1) {
                    String name = cursor.getString(nameIndex);
                    String mobile = cursor.getString(mobileIndex);
                    studentList.add("Name: " + name + "\nMobile: " + mobile);
                }
            } while (cursor.moveToNext());

            cursor.close();
            studentAdapter.notifyDataSetChanged();
        } else {
            Log.e("CallStudentActivity", "No students found in database");
        }
    }
}
