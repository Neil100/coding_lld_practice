package com.example.atm;

import lombok.RequiredArgsConstructor;

import java.util.Date;

public class Card {
    private String number;
    private int cvv;
    private String accountNumber;
    private Date expiryDate;

    public Card(String number, int cvv, String accountNumber, Date expiryDate) {
        this.number = number;
        this.cvv = cvv;
        this.accountNumber = accountNumber;
        this.expiryDate = expiryDate;
    }
    public String getNumber() {
        return number;
    }

    public int getCvv() {
        return cvv;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
