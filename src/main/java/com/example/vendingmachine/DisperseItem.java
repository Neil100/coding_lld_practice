package com.example.vendingmachine;

public class DisperseItem implements State {
    @Override
    public void clickedTakeCoinsButton(VendingMachine vendingMachine) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void pressedSelectItemButton(VendingMachine vendingMachine) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void disperseItem(VendingMachine vendingMachine, String code) {
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().deleteItem(code);
        System.out.println("Item " + "is getting dispersed.");
        vendingMachine.resetState();
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void getChange(int returnMoney) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }
}
