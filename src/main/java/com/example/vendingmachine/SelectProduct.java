package com.example.vendingmachine;

public class SelectProduct implements State {
    @Override
    public void clickedTakeCoinsButton(VendingMachine vendingMachine) {
        System.out.println("Take Coins Button pressed, when machine accepting product code.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Insert Coin action performed, when machine accepting product code.");
    }

    @Override
    public void pressedSelectItemButton(VendingMachine vendingMachine) {
        System.out.println("Select Item Button pressed, when machine is accepting product code.");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        Inventory inventory = vendingMachine.getInventory();
        Item item = inventory.getItem(code);
        int balance = vendingMachine.getCoins().stream().mapToInt(coin -> coin.value).sum() - item.getPrice();
        if(balance<0) {
            System.out.println("Funds for the selected Item is insufficient.");
            cancelTransaction(vendingMachine);
            return ;
        }
        getChange(balance);

        vendingMachine.setCurrentState(new DisperseItem());
    }

    @Override
    public void disperseItem(VendingMachine vendingMachine, String code) {
        System.out.println("Item can not be dispersed, when machine is accepting product code.");
    }

    @Override
    public void refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Full money refunded." + vendingMachine.getCoins().stream().mapToInt(coin -> coin.value).sum());
    }

    @Override
    public void getChange(int returnMoney) {
        System.out.println("Amount: "+returnMoney+" is returned to the user.");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        refundFullMoney(vendingMachine);
        vendingMachine.resetState();
    }
}
