package com.example.madrissasabak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class StudentRecyclerViewActivity extends AppCompatActivity {
    List<Record> recordsList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_view);
        db = new DbHandler(this);

        recordsList = db.selectAllRecords();

        recyclerView = findViewById(R.id.studentSabakRecyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(StudentRecyclerViewActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(recordsList) ;
        recyclerView.setAdapter(adapter);
    }
}