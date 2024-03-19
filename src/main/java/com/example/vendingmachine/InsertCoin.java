package com.example.vendingmachine;

public class InsertCoin implements State {
    @Override
    public void clickedTakeCoinsButton(VendingMachine vendingMachine) {
        System.out.println("Please Insert Coin to the machine.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Coin was Inserted to the machine. Value " + coin.value);
        vendingMachine.addCoin(coin);
    }

    @Override
    public void pressedSelectItemButton(VendingMachine vendingMachine) {
        System.out.println("Select Item Button was pressed, when machine is Accepting Coin.");
        if(vendingMachine.isCoinAdded()) {
            State newState = new SelectProduct();
            vendingMachine.setCurrentState(newState);
        } else {
            System.out.println("Please Insert Coin to the machine to proceed.");
        }
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Item can not be selected, when machine is Accepting Coin.");
    }

    @Override
    public void disperseItem(VendingMachine vendingMachine, String code) {
        System.out.println("Item can not be dispersed, when machine is Accepting Coin.");
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Full money refunded." + vendingMachine.getCoins().stream().mapToInt(coin -> coin.value).sum());
    }

    @Override
    public void getChange(int returnMoney) {
        System.out.println("Can not return change when Vending Machine is accepting coins.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        refundFullMoney(vendingMachine);
        vendingMachine.resetState();
    }
}
