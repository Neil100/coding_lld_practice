package com.example.vendingmachine;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Item {
    private final ItemType type;
    private final int price;

    public ItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
