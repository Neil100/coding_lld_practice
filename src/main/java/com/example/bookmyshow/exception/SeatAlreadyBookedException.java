package com.example.bookmyshow.exception;

public class SeatAlreadyBookedException extends RuntimeException {
    String message;
    String cause = "SEAT_ALREADY_BOOKED_EXCEPTION";
    public SeatAlreadyBookedException(String message) {
        this.message = message;
    }

    public String toString() {
        return "Cause" + cause + " :" + message;
    }
}
