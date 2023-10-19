package com.example.todayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class add_task extends AppCompatActivity {

    EditText taskIn, categories, start_time,end_time,decs;
    Button add;
    TaskDatabase taskDatabase;

    MainActivity mainActivity=new MainActivity();
    TaskTable taskTable = new TaskTable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskIn = findViewById(R.id.taskname_et);
        categories = findViewById(R.id.cat);
        start_time = findViewById(R.id.start_in);
        end_time = findViewById(R.id.endtime_in);
        decs = findViewById(R.id.info);
        add = findViewById(R.id.add_btn);


        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog dialog = new TimePickerDialog(add_task.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }


                },19 ,00,true);
               dialog.show();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =taskIn.getText().toString();
                String cate =categories.getText().toString();
                String time1 =start_time.getText().toString();
                String time2 =end_time.getText().toString();
                String dec =decs.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


                String currentDateAndTime = sdf.format(new Date());
                taskTable.setTaskName(name);
                taskTable.setDate(currentDateAndTime);
                taskTable.setCategories(cate);
                taskTable.setsTime(time1);
                taskTable.seteTime(time2);
                taskTable.setNote(dec);

                mainActivity=MySingleton.getInstance().getMyObjectm();
                mainActivity.Createamount(taskTable);

            }
        });
    }
    private  void  openDialog()
    {
        TimePickerDialog dialog = new TimePickerDialog(add_task.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        },19 ,00,true);
        dialog.show();
    }



}