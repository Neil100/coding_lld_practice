package com.example.atm.states;

import com.example.atm.AtmMachine;
import com.example.atm.actions.ActionType;

public class DisperseCash extends State {

    private int disperseAmount;

    public DisperseCash(int amount) {
        this.disperseAmount = amount;
    }
//    @Override
//    public void insertCard(AtmMachine atm, String cardNumber) {
//        System.out.println("Insert Card action called.");
//        String msg = "Insert Card action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

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

    @Override
    public void disperseCash(AtmMachine atm) {
        System.out.println("Disperse Cash action called.");
        atm.disperseCash(this.disperseAmount);
        atm.setCurrentState(new IdleState());
        atm.setUser(null);
        atm.setBankService(null);
    }

//    @Override
//    public void displayBalance(AtmMachine atm) {
//        System.out.println("Display Balance action called.");
//        String msg = "Display Balance action can not be performed right now. Try any other action.";
//        System.out.println(msg);
//    }

    @Override
    public void cancelTransaction(AtmMachine atm) {
        System.out.println("Cancel Transaction action called.");
        atm.setCurrentState(new IdleState());
    }
}
