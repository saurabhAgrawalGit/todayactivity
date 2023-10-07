package com.example.todayactivity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class TaskTable {
    @PrimaryKey(autoGenerate = true)
    int id ;
    String taskName;
    String categories;
    String note;
    String sTime;
    String eTime;
    int status;
    int iconID;

    public  TaskTable()
    {

    }

    public TaskTable(int id, String taskName, String categories, String note, String sTime, String eTime, int status, int iconID) {
        this.id = id;
        this.taskName = taskName;
        this.categories = categories;
        this.note = note;
        this.sTime = sTime;
        this.eTime = eTime;
        this.status = status;
        this.iconID = iconID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
