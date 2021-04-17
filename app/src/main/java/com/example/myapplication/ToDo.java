package com.example.myapplication;


import java.io.Serializable;
import java.util.ArrayList;

public class ToDo implements Serializable {
    public String Name;
    public float Latitude;
    public float Longitude;
    public float accuracy;
    public float Range;
    public String Object;
    public String Note;
    public Boolean IsDone;
    public Boolean IsActive;

    public ToDo(String Name,
                float Latitude,
                float Longitude,
                float accuracy,
                float Range,
                String Object,
                String Note,
                Boolean IsActive,
                Boolean IsDone)
    {
        this.Name = Name;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.accuracy = accuracy;
        this.Range = Range;
        this.Object = Object;
        this.Note = Note;
        this.IsActive = IsActive;
        this.IsDone = IsDone;
    }

    public static ArrayList<ToDo> GenerateTestData()
    {
        ArrayList<ToDo> demo = new ArrayList<ToDo>();
        demo.add(new ToDo("No 1",123, 123, 30, 30,"", "", true, false));
        demo.add(new ToDo("No 2",123, 123, 30, 30, "", "", true, false));
        demo.add(new ToDo("No 3",123, 123, 30, 30, "", "", false, false));
        demo.add(new ToDo("No 4",123, 123, 30, 30, "", "", true, false));
        demo.add(new ToDo("No 5",123, 123, 30, 30, "", "", false, false));
        return demo;
    }
}