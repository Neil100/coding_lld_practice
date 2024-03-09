package com.example.bookmyshow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;
    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }
    public static void main(String[] agrs) {
        BookMyShow bMS = new BookMyShow();
        bMS.initializeMoviesAndMovieController();

        bMS.initializeTheatreAndTheatreController();

        List<Movie> movies = bMS.movieController.getMoviesInCity("Chandigarh");
        List<Theatre> theatres = bMS.theatreController.getTheatresForCityAndMovie("Chandigarh", movies.get(0));
        List<Screen> screens = theatres.get(0).getScreens();
        List<MovieShow> movieShows = screens.get(0).getMovieShows();
        List<Seat> seats = screens.get(0).getSeats();
//        for(int i=0; i<seats.size(); i++) {
            if(!seats.get(0).isBooked()) {

                Booking booking = new Booking(1, seats.get(0), movieShows.get(0));
                booking.confirmBooking();
//                break;
            }

        if(!seats.get(0).isBooked()) {

            Booking booking = new Booking(1, seats.get(0), movieShows.get(0));
            booking.confirmBooking();
//                break;
        } else {
            System.out.println("Seat is already booked");
        }
//        }
    }

    private void initializeTheatreAndTheatreController() {
        List<Theatre> theatres = new ArrayList<>();

        // Chandigarh
        List<Screen> screens = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();
        seats.add(new GoldSeat(1));
        seats.add(new PlatinumSeat(2));
        seats.add(new SilverSeat(3));

        screens.add(new Screen(1, seats));
        MovieShow movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 0);
        MovieShow movieShow2 = new MovieShow(2, movieController.getAllMovies().get(1), 1200);
        List<MovieShow> movieShows = new ArrayList<>();
        movieShows.add(movieShow1);
        movieShows.add(movieShow2);

        screens.get(0).addMovieShows(movieShows);
        List<Seat> seats2 = new ArrayList<>();
        seats2.add(new GoldSeat(1));
        seats2.add(new PlatinumSeat(2));
        seats2.add(new SilverSeat(3));

        screens.add(new Screen(2, seats2));

        movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 1300);
        movieShow2 = new MovieShow(2, movieController.getAllMovies().get(1), 1900);
        List<MovieShow> movieShows1 = new ArrayList<>();
        movieShows1.add(movieShow1);
        movieShows1.add(movieShow2);
        screens.get(1).addMovieShows(movieShows1);

        Theatre theatre1 = new Theatre(1, "Chandigarh_1", screens, theatreController);
        theatreController.addTheatresToCity("Chandigarh", Collections.singletonList(theatre1));
        theatre1.addMovies(movieController.getAllMovies().subList(0,2));

        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        screens = new ArrayList<>();
         seats = new ArrayList<>();
        seats.add(new GoldSeat(1));
        seats.add(new PlatinumSeat(2));
        seats.add(new SilverSeat(3));

        screens.add(new Screen(1, seats));
        movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 1100);
        movieShow2 = new MovieShow(2, movieController.getAllMovies().get(1), 2000);
        movieShows = new ArrayList<>();
        movieShows.add(movieShow1);
        movieShows.add(movieShow2);

        screens.get(0).addMovieShows(movieShows);
        seats2 = new ArrayList<>();
        seats2.add(new GoldSeat(1));
        seats2.add(new PlatinumSeat(2));
        seats2.add(new SilverSeat(3));

        screens.add(new Screen(2, seats2));

        movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 1300);
        movieShow2 = new MovieShow(2, movieController.getAllMovies().get(1), 1900);
        movieShows1 = new ArrayList<>();
        movieShows1.add(movieShow1);
        movieShows1.add(movieShow2);
        screens.get(1).addMovieShows(movieShows1);

        theatre1 = new Theatre(2, "Chandigarh_2", screens, theatreController);
        theatreController.addTheatresToCity("Chandigarh", Collections.singletonList(theatre1));
        theatre1.addMovies(movieController.getAllMovies().subList(0,2));

        // Bangalore
        screens = new ArrayList<>();
        seats = new ArrayList<>();
        seats.add(new GoldSeat(1));
        seats.add(new PlatinumSeat(2));
        seats.add(new SilverSeat(3));

        screens.add(new Screen(1, seats));
        movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 0);
        movieShow2 = new MovieShow(2, movieController.getAllMovies().get(2), 1200);
        movieShows = new ArrayList<>();
        movieShows.add(movieShow1);
        movieShows.add(movieShow2);

        screens.get(0).addMovieShows(movieShows);
        seats2 = new ArrayList<>();
        seats2.add(new GoldSeat(1));
        seats2.add(new PlatinumSeat(2));
        seats2.add(new SilverSeat(3));

        screens.add(new Screen(2, seats2));

        movieShow1 = new MovieShow(1, movieController.getAllMovies().get(0), 1300);
        movieShow2 = new MovieShow(2, movieController.getAllMovies().get(2), 1900);
        movieShows1 = new ArrayList<>();
        movieShows1.add(movieShow1);
        movieShows1.add(movieShow2);
        screens.get(1).addMovieShows(movieShows1);

        theatre1 = new Theatre(1, "Bangalore_1", screens, theatreController);
        List<Movie> movies = new ArrayList<>();
        movies.add(movieController.getAllMovies().get(0));
        movies.add(movieController.getAllMovies().get(2));
        theatreController.addTheatresToCity("Bangalore", Collections.singletonList(theatre1));
        theatre1.addMovies(movies);
    }

    private void initializeMoviesAndMovieController() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "My Name is Khan", 140));
        movies.add(new Movie(2, "Chak De India", 120));
        movies.add(new Movie(3, "Munna Bhai MBBS", 150));

        movieController.addMovieToCity("Chandigarh", movies.get(0));
        movieController.addMovieToCity("Chandigarh", movies.get(1));

        movieController.addMovieToCity("Bangalore", movies.get(0));
        movieController.addMovieToCity("Bangalore", movies.get(2));

        movieController.addMovieToCity("Mumbai", movies.get(0));
        movieController.addMovieToCity("Mumbai", movies.get(1));
        movieController.addMovieToCity("Mumbai", movies.get(2));
    }
}
