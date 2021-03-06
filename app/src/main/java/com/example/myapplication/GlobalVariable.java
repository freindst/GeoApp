package com.example.myapplication;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class GlobalVariable extends Application {
    private Boolean initiated = false;

    private ArrayList<ToDo> todoList;

    public ArrayList<ToDo> getTodoList() {
        if (!initiated) {
            todoList = ToDo.GenerateTestData();
            initiated = true;
        }
        return todoList;
    }

    public void updateTodoList(int position, ToDo item) {
        if (todoList.size() > position){
            todoList.set(position, item);
        } else {
            todoList.add(item);
        }
    }

    public int getTodoSize()
    {
        if (!initiated){
            return 0;
        }
        return todoList.size();
    }
}
