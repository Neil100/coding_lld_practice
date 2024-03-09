package com.example.bookmyshow;

import com.example.bookmyshow.exception.SeatAlreadyBookedException;

public class Booking {
    int id;
    Seat seat;
    MovieShow movieShow;

    Booking(int id, Seat seat, MovieShow movieShow) {
        this.id = id;
        this.seat = seat;
        this.movieShow = movieShow;
    }

    void confirmBooking() {
        if(!seat.bookSeat()) {
            throw new SeatAlreadyBookedException("Seat no: "+ seat.id + " has already been booked.");
        }
        movieShow.addBookedSeat(seat);
        System.out.println("Seat Cost: " + seat.price);
        Payment paymentService = new Payment();
        try {
            if (paymentService.makePayment(true)) {

            } else {
                // reverse the booking
            }
        } catch (Exception ex) {

        }
    }
}
