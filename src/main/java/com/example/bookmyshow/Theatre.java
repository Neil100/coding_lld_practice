package com.example.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int id;
    String name;
    List<Screen> screens;
    List<Movie> movies;
    TheatreController theatreController;

    Theatre(int id, String name, List<Screen> screens, TheatreController theatreController) {
        this.id = id;
        this.name = name;
        this.screens = screens;
        this.theatreController = theatreController;
        this.movies = new ArrayList<>();
    }

    void addMovies(List<Movie> movies) {
        this.movies.addAll(movies);

        for(Movie movie: movies) {
            this.theatreController.addTheatreToMovie(this, movie);
        }
    }

    List<Screen> getScreens() {
        return screens;
    }
}
