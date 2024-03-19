package com.example.vendingmachine;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@RequiredArgsConstructor
public class Inventory {
    private final HashMap<String, ItemRack> codeToItemRackMap;

    public Item getItem(String code) {
        if(codeToItemRackMap.containsKey(code)) {
            return codeToItemRackMap.get(code).getItem();
        } else {
            // throw Exception
        }
        return null;
    }

    public void deleteItem(String code) {
        if(codeToItemRackMap.containsKey(code)) {
            codeToItemRackMap.get(code).disperseItem();
        } else {
            // throw Exception
        }
    }
}
