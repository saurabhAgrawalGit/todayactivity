package com.example.todayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class add_task extends AppCompatActivity {
    EditText taskIn, categories, start_time,end_time,decs;
    Button add;
    TaskDatabase taskDatabase;
    int i =18%30;
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
        add=findViewById(R.id.add_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =taskIn.getText().toString();
                String cate =categories.getText().toString();
                String time1 =start_time.getText().toString();
                String time2 =end_time.getText().toString();
                String dec =decs.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                // on below line we are creating a variable
                // for current date and time and calling a simple date format in it.


                String currentDateAndTime = sdf.format(new Date());
                taskTable.setTaskName(name);
                taskTable.setDate(currentDateAndTime);
                taskTable.setCategories(cate);
                taskTable.setsTime(time1);
                taskTable.seteTime(time2);
                taskTable.setNote(dec);
//                taskDatabase= Room.databaseBuilder(
//                                getApplicationContext(),
//                                TaskDatabase.class,
//                                "ContactDB")
//                        .allowMainThreadQueries().fallbackToDestructiveMigration()
//                        .build();
//                taskDatabase.getTaskDAO().add_task(taskTable);


                mainActivity=MySingleton.getInstance().getMyObjectm();
                mainActivity.Createamount(taskTable);





            }
        });
    }
}