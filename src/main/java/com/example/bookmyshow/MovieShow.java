package com.example.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class MovieShow {
    int id;
    Movie movie;
    int time;
    List<Seat> bookedSeats;

    MovieShow(int id, Movie movie, int time) {
        this.id = id;
        this.movie = movie;
        this.time = time;
        bookedSeats = new ArrayList<>();
    }

    public void addBookedSeat(Seat seat) {
        if(!bookedSeats.contains(seat)) {
            bookedSeats.add(seat);
        } else {
            // thow Exception
        }
    }
}
