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
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    public TaskAdapter taskAdapter;
    TaskDatabase taskDatabase;

    TextView balance, income, expense;
    public ArrayList<TaskTable> TaskArrayList  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView = findViewById(R.id.recycler);
         button= findViewById(R.id.btn);
        taskDatabase= Room.databaseBuilder(
                        getApplicationContext(),
                        TaskDatabase.class,
                        "ContactDB")
                .allowMainThreadQueries()
                .build();

        TaskArrayList.addAll(taskDatabase.getTaskDAO().getContacts());
        taskAdapter = new TaskAdapter( TaskArrayList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(taskAdapter);

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
}