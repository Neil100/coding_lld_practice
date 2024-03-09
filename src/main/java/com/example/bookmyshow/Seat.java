package com.example.bookmyshow;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RequiredArgsConstructor
public class Seat {
    int id;
    boolean isBooked = false;
    int price = 150;

    Seat(int id) {
        this.id = id;
    }
    ReadWriteLock lock = new ReentrantReadWriteLock();

    boolean bookSeat() {
        lock.writeLock();
        if(!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    boolean isBooked() {
        lock.readLock();
        return isBooked;
    }
}
