package com.example.madrissasabak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class AddSabakActivity extends AppCompatActivity {
    Spinner studentSpinnerSabak;
    ArrayAdapter<Student> spinnerAdapter;
    DbHandler dbHandler;
    Button backBtn, addSabak;
    EditText sabakDate, sabakSabak, sabakSabki, manzilSabak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sabak);

        studentSpinnerSabak = findViewById(R.id.studentSpinnerSabak);
        backBtn = findViewById(R.id.backBtnSabak);
        sabakDate = findViewById(R.id.sabakDate);
        sabakSabak = findViewById(R.id.sabakSabak);
        sabakSabki = findViewById(R.id.sabakSabki);
        manzilSabak = findViewById(R.id.manzilSabak);
        addSabak = findViewById(R.id.addSabak);

        dbHandler=new DbHandler(this);
        List<Student> students = dbHandler.selectAllStudents();
        spinnerAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_spinner_item, students);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studentSpinnerSabak.setAdapter(spinnerAdapter);

        addSabak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record record = new Record(Integer.parseInt(studentSpinnerSabak.getSelectedItem().toString().split(":")[0]),
                        studentSpinnerSabak.getSelectedItem().toString().split(":")[1],
                        sabakDate.getText().toString(), Integer.parseInt(sabakSabak.getText().toString()),
                        Integer.parseInt(sabakSabki.getText().toString()), Integer.parseInt(manzilSabak.getText().toString()));
                try {
                    dbHandler.insertRecord(record);
                    Toast.makeText(getApplicationContext(), "Record Added Successfully!!", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Failed to Add Record!!!", Toast.LENGTH_LONG).show();
                }
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