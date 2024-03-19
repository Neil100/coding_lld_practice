package com.example.vendingmachine;

public class Idle implements State {
    @Override
    public void clickedTakeCoinsButton(VendingMachine vendingMachine) {
        System.out.println("Insert Coins Button Clicked, while vending machine is IDLE.");
        State newState = new InsertCoin();
        vendingMachine.setCurrentState(newState);
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Insert Coin operation is not allowed when vending machine is Idle. Press Take Coins Button to proceed.");
        // thow exception
    }

    @Override
    public void pressedSelectItemButton(VendingMachine vendingMachine) {
        System.out.println("Can not initiate item selection when vending machine is Idle. Press Take Coins Button to proceed.");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Can not select item when vending machine is Idle. Press Take Coins Button to proceed.");
    }

    @Override
    public void disperseItem(VendingMachine vendingMachine, String code) {
        System.out.println("Can not disperse item when vending machine is Idle. Press Take Coins Button to proceed.");
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Can not refund money when vending machine is Idle. Press Take Coins Button to proceed.");
    }

    @Override
    public void getChange(int returnMoney) {
        System.out.println("Can not return change when vending machine is Idle. Press Take Coins Button to proceed.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Transaction was canceled, while vending machine is IDLE.");
    }
}
