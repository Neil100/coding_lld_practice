package com.example.vendingmachine;

public enum Coin {

    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDERED(100);

    int value;
    Coin(int value) {
        this.value = value;
    }
}
