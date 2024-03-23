package com.example.atm.states;

import com.example.atm.AtmMachine;
import com.example.atm.bank.Bank;

public class IdleState extends State {

    public void insertCard(AtmMachine atm, String cardNumber, Bank bank) {
        System.out.println("Insert Card action called.");
        atm.insertCard(cardNumber, bank);
        atm.setCurrentState(new CardInserted());
    }

    @Override
    public void cancelTransaction(AtmMachine atm) {
        System.out.println("Cancel Transaction action called.");
    }
}
