package com.example.todayactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class add_task extends AppCompatActivity {
    EditText taskIn, categories, start_time,end_time,decs;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskIn = findViewById(R.id.taskname_et);
        categories = findViewById(R.id.cat);
        start_time = findViewById(R.id.start_in);
        end_time = findViewById(R.id.endtime_in);
        decs = findViewById(R.id.info);
        add=findViewById(R.id.add_btn);
    }
}