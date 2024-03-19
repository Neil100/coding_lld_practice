package com.example.vendingmachine;

public interface State {
    public void clickedTakeCoinsButton(VendingMachine vendingMachine);
    public void insertCoin(VendingMachine vendingMachine, Coin coin);
    public void pressedSelectItemButton(VendingMachine vendingMachine);
    public void selectItem(VendingMachine vendingMachine, String code);
    public void disperseItem(VendingMachine vendingMachine, String code);
    public void refundFullMoney(VendingMachine vendingMachine);
    public void getChange(int returnMoney);
    public void cancelTransaction(VendingMachine vendingMachine);
}
