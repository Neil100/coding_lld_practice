package com.example.vendingmachine;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ItemRack {
    private final int capacity = 10;
    private List<Item> items;

    public ItemRack() {
        items = new ArrayList<>();
    }
    public void addItems(List<Item> newItems) {
        if(items.size() + newItems.size()>10) {
            // throw exception
        } else {
            items.addAll(newItems);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public Item disperseItem() {
        Item item = items.get(items.size()-1);
        items.remove(items.size()-1);

        return item;
    }

    public Item getItem() {
        if(items.size()==0) {
            // throw Exception
        }
        return items.get(items.size()-1);
    }
}
