package com.androidpark.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TodoFragment extends Fragment {

    private ArrayList<TodoItem> todoItemArrayList =  new ArrayList<>();
    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private LinearLayoutManager linearLayoutManager;
    Button btnAdd;
    EditText edit;
    ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_todo,container,false);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView = viewGroup.findViewById(R.id.rv);

        linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        todoAdapter = new TodoAdapter(todoItemArrayList);
        recyclerView.setAdapter(todoAdapter);

        btnAdd = viewGroup.findViewById(R.id.btnAdd);
        edit = viewGroup.findViewById(R.id.todo);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodoItem todoItem = new TodoItem(1,"ㅎㅇ");
                todoItemArrayList.add(todoItem);
                todoAdapter.notifyDataSetChanged();
            }
        });

        return viewGroup;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item();
    }

    private void item() {
    }
}