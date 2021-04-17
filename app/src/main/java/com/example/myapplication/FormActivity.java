package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {
    GlobalVariable gb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        gb = (GlobalVariable)this.getApplication();
        ArrayList<ToDo> todos = gb.getTodoList();
        int position = getIntent().getIntExtra("position", 0);
        ToDo item = todos.get( position );

        if (item != null){
            this.populateForm(item);
        }

        Button saveBtn = (Button)findViewById(R.id.button_submitToDo);
        saveBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gb.updateTodoList(position, saveForm());
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button locationBtn = (Button)findViewById(R.id.button_location);
        locationBtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MapsMarkerActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    private void populateForm(ToDo item){
        final EditText name = (EditText)findViewById(R.id.editTextName);
        name.setText(item.Name);

        final EditText lat = (EditText)findViewById(R.id.editTextLat);
        lat.setText(Float.toString(item.Latitude));

        final EditText lng = (EditText)findViewById(R.id.editTextLng);
        lng.setText(Float.toString(item.Longitude));

        final EditText range = (EditText)findViewById(R.id.editTextRange);
        range.setText(Float.toString(item.Range));

        final EditText object = (EditText)findViewById(R.id.editTextObject);
        object.setText(item.Object);

        final EditText notes = (EditText)findViewById(R.id.editTextNotes);
        notes.setText(item.Note);

        final RadioGroup radioActive = (RadioGroup)findViewById(R.id.radioIsActive);
        if (item.IsActive){
            radioActive.check(R.id.radioButtonActive);
        } else {
            radioActive.check(R.id.radioButtonNotActive);
        }

        final RadioGroup radioDone = (RadioGroup)findViewById(R.id.radioIsDone);
        if (item.IsDone){
            radioDone.check(R.id.radioButtonDone);
        } else {
            radioDone.check(R.id.radioButtonNotDone);
        }
    }

    private ToDo saveForm() {
        String name = ((EditText)findViewById(R.id.editTextName)).getText().toString();
        String lat = ((EditText)findViewById(R.id.editTextLat)).getText().toString();
        String lng = ((EditText)findViewById(R.id.editTextLng)).getText().toString();
        String range = ((EditText)findViewById(R.id.editTextRange)).getText().toString();
        String object = ((EditText)findViewById(R.id.editTextObject)).getText().toString();
        String note = ((EditText)findViewById(R.id.editTextNotes)).getText().toString();
        Boolean isActive = ((RadioButton)findViewById(R.id.radioButtonActive)).isChecked();
        Boolean isDone = ((RadioButton)findViewById(R.id.radioButtonDone)).isChecked();
        return new ToDo(name,
                Float.parseFloat(lat),
                Float.parseFloat(lng),
                30,
                Float.parseFloat(range),
                object,
                note,
                isActive,
                isDone);
    }
}