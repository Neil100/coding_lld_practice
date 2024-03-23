package com.example.atm.states;

import com.example.atm.AtmMachine;
import com.example.atm.actions.ActionType;
import com.example.atm.bank.Bank;

public interface StateInterface {
    public void insertCard(AtmMachine atm, String cardNumber, Bank bank);
    public void enterPin(AtmMachine atm, String pin);
    public void selectAction(AtmMachine atm, ActionType action);
    public void withdrawCash(AtmMachine atm, int amount);
    public void getAccountBalance(AtmMachine atm);
    public void disperseCash(AtmMachine atm);
    public void displayBalance(AtmMachine atm);
    public void cancelTransaction(AtmMachine atm);
}
