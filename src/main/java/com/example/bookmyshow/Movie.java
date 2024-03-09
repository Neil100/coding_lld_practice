package com.example.bookmyshow;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Movie {
    int id;
    String name;
    int duration;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

}
