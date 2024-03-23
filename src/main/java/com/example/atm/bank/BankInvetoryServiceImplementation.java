package com.example.atm.bank;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;

public class BankInvetoryServiceImplementation implements BankInventoryService {
    private HashMap<Bank, BankService> inventory;

    public BankInvetoryServiceImplementation(HashMap<Bank, BankService> inventory) {
        this.inventory = inventory;
    }

    @Override
    public BankService getBankService(Bank bank) {
        if(inventory.containsKey(bank)) {
            return inventory.get(bank);
        }
        System.out.println("Banking service for the required bank is not present.");
        // throw exception
        return null;
    }
}
