package com.ahmednabil.androidarchitecturecomponentsdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmednabil.androidarchitecturecomponentsdemo.database.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder> {

    private List<Task> allTasks;
    private OnTaskClickListener onTaskClickListener;

    public TaskRecyclerViewAdapter(OnTaskClickListener onTaskClickListener) {
        this.onTaskClickListener = onTaskClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);
        return new TaskViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.mTitle.setText(allTasks.get(position).getTitle());
        holder.mContent.setText(allTasks.get(position).getContent());
        holder.mPriority.setText(String.valueOf(allTasks.get(position).getPriority()));
    }

    @Override
    public int getItemCount() {
        if(allTasks == null)
            return 0;
        return allTasks.size();
    }

    public void setTasks(List<Task> allTasks) {
        this.allTasks = allTasks;
        notifyDataSetChanged();
    }

    interface OnTaskClickListener {
        void onTaskClick(int position);
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitle;
        public TextView mContent;
        public TextView mPriority;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTitle = itemView.findViewById(R.id.title);
            this.mContent = itemView.findViewById(R.id.content);
            this.mPriority = itemView.findViewById(R.id.priority);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            onTaskClickListener.onTaskClick(position);
        }
    }
}
