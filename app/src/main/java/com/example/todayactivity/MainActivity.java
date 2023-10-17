package com.example.todayactivity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    ImageButton pre , next;
    TextView date_cur;
    String currentDateAndTime;
    public TaskAdapter taskAdapter;
    TaskDatabase taskDatabase;

    TextView balance, income, expense;
    public ArrayList<TaskTable> TaskArrayList  = new ArrayList<>();
    public ArrayList<TaskTable> ListByDate  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_cur=findViewById(R.id.textView);
        pre=findViewById(R.id.datepre);
        next=findViewById(R.id.datenex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // on below line we are creating a variable
        // for current date and time and calling a simple date format in it.

         currentDateAndTime = sdf.format(new Date());

        date_cur.setText(currentDateAndTime);
        recyclerView = findViewById(R.id.recycler);
         button= findViewById(R.id.btn);
        taskDatabase= Room.databaseBuilder(
                        getApplicationContext(),
                        TaskDatabase.class,
                        "ContactDB")
                .allowMainThreadQueries().fallbackToDestructiveMigration()
                .build();

        TaskArrayList.addAll(taskDatabase.getTaskDAO().getContacts());
        taskAdapter = new TaskAdapter( TaskArrayList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(taskAdapter);

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Date date = sdf.parse(currentDateAndTime);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);


                    c.add(Calendar.DATE, -1);
                    currentDateAndTime = sdf.format(c.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                date_cur.setText(currentDateAndTime);
                setRecyclerViewByDate();
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Date date = sdf.parse(currentDateAndTime);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);


                    c.add(Calendar.DATE, 1);
                    currentDateAndTime = sdf.format(c.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                date_cur.setText(currentDateAndTime);
                setRecyclerViewByDate();
            }
        });

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent = new Intent(getApplicationContext(),add_task.class);
                 startActivity(intent);
                 MySingleton.getInstance().setMyObjectMain(MainActivity.this);

             }
         });
    }
    public void DeleteContact( TaskTable taskTable,int position) {
        TaskArrayList.remove(position);
        taskDatabase.getTaskDAO().del_task(taskTable);

        taskAdapter.notifyDataSetChanged();


    }
    public void Createamount( TaskTable taskTable) {
       taskDatabase.getTaskDAO().add_task(taskTable);
       TaskArrayList.add(taskTable);
       taskAdapter.notifyDataSetChanged();
    }

    public void updateAmount(TaskTable taskTable, int position) {
//        expenseDatabase.getExpenseDAO().updateContact(expenseTablee);
//        ExpenseArrayList.set(position,expenseTablee);
//        balance_amount();
//        expenseAdapter.notifyDataSetChanged();
    }
    public  void setRecyclerViewByDate()
    {

        ListByDate.removeAll(ListByDate);
        for(int i =0 ; i<TaskArrayList.size();i++)
        {
            if(currentDateAndTime.equals(TaskArrayList.get(i).getDate()))
            {
                ListByDate.add(TaskArrayList.get(i));
            }
        }
        taskAdapter = new TaskAdapter( ListByDate,MainActivity.this);
        recyclerView.setAdapter(taskAdapter);
        taskAdapter.notifyDataSetChanged();


    }
}