package com.example.todayactivity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database( entities ={ TaskTable.class },version = 1)
public  abstract class TaskDatabase extends RoomDatabase {
    public  abstract TaskDao getTaskDAO();
}
