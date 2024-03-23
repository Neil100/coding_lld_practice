package com.example.atm.states;

import com.example.atm.AtmMachine;
import com.example.atm.actions.ActionType;

public class DisplayBalance extends State {

//    @Override
//    public void insertCard(AtmMachine atm, String cardNumber) {
//        System.out.println("Insert Card action called.");
//        String msg = "Insert Card action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }
//
//    @Override
//    public void enterPin(AtmMachine atm, String pin) {
//        System.out.println("Enter Pin action called.");
//        String msg = "Enter Pin action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

//    @Override
//    public void selectAction(AtmMachine atm, ActionType action) {
//        System.out.println("Insert Card action called.");
//        String msg = "Insert Card action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }
//
//    @Override
//    public void withdrawCash(AtmMachine atm, int amount) {
//        System.out.println("Withdraw Cash action called.");
//        String msg = "Withdraw Cash action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

//    @Override
//    public void getAccountBalance(AtmMachine atm) {
//        System.out.println("Get Account Balance action called.");
//        String msg = "Get Account Balance action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

//    @Override
//    public void disperseCash(AtmMachine atm) {
//        System.out.println("Disperse Cash action called.");
//        String msg = "Disperse Cash action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

    @Override
    public void displayBalance(AtmMachine atm) {
        System.out.println("Display Balance action called.");
        int balance = atm.getUserBalance();

        System.out.println("Your balance is " + balance);
        cancelTransaction(atm);

    }

    @Override
    public void cancelTransaction(AtmMachine atm) {
        System.out.println("Cancel Transaction action called.");
        atm.setCurrentState(new IdleState());
    }
}
