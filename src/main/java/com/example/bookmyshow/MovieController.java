package com.example.bookmyshow;

import java.util.*;

public class MovieController {
    HashMap<String, Set<Movie>> cityMovieMap;
    Set<Movie> allMovies;

    MovieController() {
        cityMovieMap = new HashMap<>();
        allMovies = new HashSet<>();
    }

    void addMovieToCity(String city, Movie movie) {
        Set<Movie> movieList = cityMovieMap.getOrDefault(city, new HashSet<>());
        movieList.add(movie);
        cityMovieMap.put(city, movieList);

        if(!allMovies.contains(movie)) {
            allMovies.add(movie);
        }
    }

    List<Movie> getMoviesInCity(String city) {
        List<Movie> movies = new ArrayList<>(cityMovieMap.get(city));
        return movies;
    }

    List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>(allMovies);
        return movies;
    }
}
