package com.example.atm.cashdispenser;

import com.example.atm.AtmMachine;
import com.example.atm.cashdispenser.CashDispenseInterface;

public class CashDispenser implements CashDispenseInterface {

    private CashDispenseInterface nextDispenser;

    CashDispenser(CashDispenseInterface nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    @Override
    public void dispenseCash(int amount, AtmMachine atm) {
        if(nextDispenser!=null) {
            nextDispenser.dispenseCash(amount, atm);
        } else {
            System.out.println("Cash can not be dispensed for amount " + amount);
            // throw exception
        }
    }
}
