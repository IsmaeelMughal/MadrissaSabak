package com.example.madrissasabak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {
    Button backBtn, addStudent;
    EditText stdName, stdRoll, stdDate;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        backBtn = findViewById(R.id.backBtnStudent);
        addStudent = findViewById(R.id.addStudentAdmissionBtn);
        stdName = findViewById(R.id.studentName);
        stdRoll = findViewById(R.id.studentRollNumber);
        stdDate = findViewById(R.id.studentAdmissionDate);


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stdName = findViewById(R.id.studentName);
                stdRoll = findViewById(R.id.studentRollNumber);
                stdDate = findViewById(R.id.studentAdmissionDate);

                Student std = new Student(stdName.getText().toString(),
                        Integer.parseInt(stdRoll.getText().toString()), stdDate.getText().toString());
                System.out.println("!!!!!!!!!!!!!!!!!"+ std.toString());
                db.insertStudent(std);
                System.out.println("=========================");
                Toast.makeText(getApplicationContext(), "Student Added Successfully!!", Toast.LENGTH_LONG).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}