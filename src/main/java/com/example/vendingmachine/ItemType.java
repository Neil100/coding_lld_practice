package com.example.vendingmachine;

public enum ItemType {
    COKE("Coke"),
    PEPSI("Pepsi"),
    KITKAT("Kit Kat Chocolate"),
    DIGESTIVE_BISCUITS("Macveties Digestive Biscuites"),
    DAIRYMILK("DairyMilk Chocolate"),
    MILKSHAKE("Cavin's Milkshake");

    String name;

    ItemType(String name) {
        this.name = name;
    }
}
