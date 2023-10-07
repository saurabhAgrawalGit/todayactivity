package com.example.todayactivity;

public class MySingleton {
    private static MySingleton instance;
    private TaskTable  taskTable;
    private  MainActivity mainActivity;

    private MySingleton() {}

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    public TaskTable getMyObject() {
        return taskTable;
    }
    public MainActivity getMyObjectm() {
        return mainActivity;
    }

    public void setMyObject(MainActivity mainActivity,TaskTable taskTable) {
        this.taskTable = taskTable;
        this.mainActivity=mainActivity;
    }
    public void setMyObjectMain(MainActivity mainActivity) {

        this.mainActivity=mainActivity;
    }
}