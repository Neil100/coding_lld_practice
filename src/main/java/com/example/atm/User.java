package com.example.atm;

import com.example.atm.bank.Bank;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

public class User {
    private String name;
    private Card card;
    private Bank bank;
    private String pin;
    private int bankBalance;

    public User(String name, Card card, Bank bank, String pin, int bankBalance) {
        this.name = name;
        this.card = card;
        this.bank = bank;
        this.pin = pin;
        this.bankBalance = bankBalance;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    public Bank getBank() {
        return bank;
    }

    public String getPin() {
        return pin;
    }

    public int getBankBalance() {
        return bankBalance;
    }
}
