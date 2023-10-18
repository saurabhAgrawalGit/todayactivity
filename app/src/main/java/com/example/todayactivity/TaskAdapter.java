package com.example.todayactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {



    public ArrayList<TaskTable> arrayList;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Taskname;
        public TextView cat;
        public TextView start;
        public TextView end;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //this.Taskname= itemView.findViewById(R.id.taskname);
            this.cat= itemView.findViewById(R.id.textView2);
            this.start= itemView.findViewById(R.id.start_time);
            this.end= itemView.findViewById(R.id.end_Time);
          //  this.imageView= itemView.findViewById(R.id.img);

        }
    }
    public TaskAdapter(ArrayList<TaskTable> arrayList, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.itrm_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyViewHolder holder, int position) {
        TaskTable taskTable = arrayList.get(position);
//        holder.Taskname.setText(taskTable.getTaskName());
        holder.cat.setText(taskTable.getCategories());
        holder.start.setText(taskTable.getsTime());
        holder.end.setText(taskTable.geteTime());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
