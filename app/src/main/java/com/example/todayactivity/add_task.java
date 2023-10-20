package com.example.todayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class add_task extends AppCompatActivity {

    EditText taskIn, categories, start_time,end_time,decs,date;
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
        date = findViewById(R.id.editTextDate);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        String currentDateAndTime = sdf.format(new Date());
        date.setText(currentDateAndTime);
        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog dialog = new TimePickerDialog(add_task.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        int a = hourOfDay<=12? (hourOfDay==0 ? 12:hourOfDay):hourOfDay-12;
                        start_time.setText((a<10? "0"+a:a)+ " : "+(minute<10? "0"+minute:minute)+" "+ (hourOfDay<=12? " AM":" PM"));

                    }

                },19 ,00,false);
                dialog.show();
            }
        });


        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog dialog = new TimePickerDialog(add_task.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        int a = hourOfDay<=12? (hourOfDay==0 ? 12:hourOfDay):hourOfDay-12;
                        end_time.setText((a<10? "0"+a:a)+ " : "+(minute<10? "0"+minute:minute)+" "+ (hourOfDay<=12? " AM":" PM"));

                    }


                },19 ,00,false);
               dialog.show();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("UTC"));


                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                 Date today = calendar.getTime();
                DatePickerDialog datePicker = new DatePickerDialog(add_task.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                },yy,mm,dd);
                datePicker.show();
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


                String currentDateAndTime = date.getText().toString();
                taskTable.setTaskName(name);
                taskTable.setDate(currentDateAndTime);
                taskTable.setCategories(cate);
                taskTable.setsTime(time1);
                taskTable.seteTime(time2);
                taskTable.setNote(dec);

                mainActivity=MySingleton.getInstance().getMyObjectm();
                mainActivity.Createamount(taskTable);
                Toast.makeText(getApplicationContext(),"Successful Added Your Task",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        String currentDateAndTime = sdf.format(new Date());
        date.setText(currentDateAndTime);
    }
}