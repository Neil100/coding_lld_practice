package com.example.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seats;
    List<MovieShow> movieShows;
    Screen(int id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
        movieShows = new ArrayList<>();
    }

    void addMovieShows(List<MovieShow> shows) {
        this.movieShows.addAll(shows);
    }

    List<MovieShow> getMovieShows() {
        return movieShows;
    }

    List<Seat> getSeats() {
        return seats;
    }
}
