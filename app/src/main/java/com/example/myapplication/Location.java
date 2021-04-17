package com.example.myapplication;

public class Location {
    public float Latitude;
    public float Longitude;
    public float accuracy;

    public Location(float lat, float lng, float accuracy)
    {
        this.Latitude = lat;
        this.Longitude = lng;
        this.accuracy = accuracy;
    }

    public Location(float lat, float lng)
    {
        this.Latitude = lat;
        this.Longitude = lng;
        this.accuracy = 30;
    }
}
