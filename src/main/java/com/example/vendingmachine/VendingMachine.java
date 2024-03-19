package com.example.vendingmachine;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State currentState;
    private List<Coin> coins;
    private final Inventory inventory;
    private String itemCode;

    VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        currentState = new Idle();
        coins = new ArrayList<>();
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void resetState() {
        coins = new ArrayList<>();
        currentState = new Idle();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public boolean isCoinAdded() {
        return coins.size()!=0 ? true : false;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
