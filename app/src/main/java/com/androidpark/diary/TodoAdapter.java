package com.androidpark.diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private ArrayList<TodoItem> data;
    public TodoAdapter(ArrayList<TodoItem> data){
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            protected ImageButton deleteBtn;
            protected CheckBox checkBox;
            protected LinearLayout layoutTodo;
            Button btnAdd;
            EditText todoContent;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);


                this.checkBox = itemView.findViewById(R.id.checkBox);
                this.deleteBtn = itemView.findViewById(R.id.deleteButton);

                layoutTodo = (LinearLayout) itemView.findViewById(R.id.layoutTodo);
                todoContent  = (EditText) itemView.findViewById(R.id.todo);
                btnAdd = (Button) itemView.findViewById(R.id.btnAdd);

                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getAdapterPosition();
                        if(position !=RecyclerView.NO_POSITION){
                            data.remove(position);
                            notifyDataSetChanged();
                        }

                    }
                });


            }

        public void setItem(TodoItem data){
            checkBox.setText(data.getTodo());
        }
        public void setLayout() {
            layoutTodo.setVisibility(View.VISIBLE);
        }
    }
    public void setItem (ArrayList<TodoItem> data){
        this.data = data;
    }
    TodoAdapter(ArrayList<TodoItem> list, Context context){

        data = list;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_todo,parent,false);
        TodoAdapter.ViewHolder viewHolder = new TodoAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem item = data.get(position);
        holder.setItem(item);
        holder.setLayout();

        }


    @Override
    public int getItemCount() {

        return data.size();
    }
}