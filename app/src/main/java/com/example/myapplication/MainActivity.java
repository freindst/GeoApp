package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int size =0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getCoords = findViewById(R.id.getCurrentLocation);
        final RecyclerView recycler = (RecyclerView)findViewById(R.id.recycler_todo);
        ArrayList<ToDo> todos = ((GlobalVariable)this.getApplication()).getTodoList();
        size = todos.size();
        CustomRowAdapter adapter1 = new CustomRowAdapter(todos, this);
        recycler.setAdapter(adapter1);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        getCoords.setOnClickListener(

            new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), current_coordinates.class);
                    startActivity(intent);
                }
            }
        );
        Button newTodo = (Button)findViewById(R.id.button_new_todo);
        newTodo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                       Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                        intent.putExtra("position", size);
                       startActivity(intent);
                    }
                }
        );
    }


}