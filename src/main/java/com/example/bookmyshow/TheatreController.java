package com.example.bookmyshow;

import java.util.*;
import java.util.stream.Collectors;

public class TheatreController {

    HashMap<String, Set<Theatre>> cityToTheatres;
    HashMap<Movie, Set<Theatre>> movieToTheatres;

    TheatreController() {
        cityToTheatres = new HashMap<>();
        movieToTheatres = new HashMap<>();
    }

    void addTheatresToCity(String city, List<Theatre> theatres) {
        Set<Theatre> theatreSet = cityToTheatres.getOrDefault(city, new HashSet<>());
        theatreSet.addAll(theatres);

        cityToTheatres.put(city, theatreSet);
    }

    List<Theatre> getTheatresFromCity(String city) {
        if(cityToTheatres.containsKey(city)) {
            return new ArrayList<>(cityToTheatres.get(city));
        }
        return new ArrayList<>();
    }

    List<Theatre> getTheatresForCityAndMovie(String city, Movie movie) {
        if(cityToTheatres.containsKey(city)) {
            List<Theatre> theatreList = new ArrayList<>(cityToTheatres.get(city));

            List<Theatre> theatreList1 = new ArrayList<>(movieToTheatres.get(movie));


            return theatreList.stream().filter(theatre -> theatreList1.contains(theatre)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    void addTheatreToMovie(Theatre theatre, Movie movie) {
        Set<Theatre> theatreSet = movieToTheatres.getOrDefault(movie, new HashSet<>());
        theatreSet.add(theatre);
        movieToTheatres.put(movie, theatreSet);
    }
}
