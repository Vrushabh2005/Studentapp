package com.example.finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class viewstudent extends AppCompatActivity {

    private TextView studentListTextView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstudent);

        studentListTextView = findViewById(R.id.studentListTextView);
        databaseHelper = new DatabaseHelper(this);

        displayStudents();
    }

    private void displayStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        Cursor cursor = databaseHelper.getAllStudents();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex("id");
                int nameIndex = cursor.getColumnIndex("name");
                int mobileIndex = cursor.getColumnIndex("mobile");

                if (idIndex >= 0 && nameIndex >= 0 && mobileIndex >= 0) {
                    int id = cursor.getInt(idIndex);
                    String name = cursor.getString(nameIndex);
                    String mobile = cursor.getString(mobileIndex);

                    stringBuilder.append("ID: ").append(id).append("\n");
                    stringBuilder.append("Name: ").append(name).append("\n");
                    stringBuilder.append("Mobile: ").append(mobile).append("\n\n");
                }
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }

       studentListTextView.setText(stringBuilder.toString());
    }
}
