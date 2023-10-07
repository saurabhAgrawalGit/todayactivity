package com.example.todayactivity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    public  void add_task(TaskTable taskTable);

    @Delete
    public  void del_task(TaskTable taskTable);

    @Update
    public  void update_task(TaskTable taskTable);

    @Query("select* from task")
    public List<TaskTable> getContacts();

    @Query("select* from task where id==:id")
    public TaskTable getContact(int id);


}