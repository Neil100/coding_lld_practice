package com.example.vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachineMain {

    public static void main(String[] args) {

        HashMap<String, ItemRack> map = getItemRackMap();
        Inventory inventory = new Inventory(map);

        VendingMachine vendingMachine = new VendingMachine(inventory);

        State currentState = vendingMachine.getCurrentState();
        currentState.clickedTakeCoinsButton(vendingMachine);

        currentState = vendingMachine.getCurrentState();
        currentState.insertCoin(vendingMachine, Coin.HUNDERED);
        currentState.pressedSelectItemButton(vendingMachine);

        currentState = vendingMachine.getCurrentState();
        currentState.selectItem(vendingMachine, "101");

        currentState = vendingMachine.getCurrentState();
        currentState.disperseItem(vendingMachine, "101");

    }

    private static HashMap<String, ItemRack> getItemRackMap() {
        HashMap<String, ItemRack> map = new HashMap<>();
        List<Item> items = new ArrayList<>();
        for(int i=0; i<8; i++) {
            items.add(new Item(ItemType.COKE, 50));
        }
        ItemRack itemRackOne = new ItemRack();
        itemRackOne.addItems(items);

        items = new ArrayList<>();
        for(int i=0; i<10; i++) {
            items.add(new Item(ItemType.DAIRYMILK, 20));
        }
        ItemRack itemRackTwo = new ItemRack();
        itemRackTwo.addItems(items);

        map.put("101", itemRackOne);
        map.put("102", itemRackTwo);
        return map;
    }
}
