package com.example.atm.cashdispenser;

import com.example.atm.AtmMachine;
import com.example.atm.cashdispenser.CashDispenseInterface;
import com.example.atm.cashdispenser.CashDispenser;

public class TwoThousandRuppeeDispenser extends CashDispenser {

    private int notes;

    public TwoThousandRuppeeDispenser(CashDispenseInterface nextCashDispenser, int notes) {
        super(nextCashDispenser);
        this.notes = notes;
    }

    @Override
    public void dispenseCash(int amount, AtmMachine atm) {
        int notesRequired = amount/2000;
        if(notesRequired<=notes) {
            notes = notes - notesRequired;
            super.dispenseCash(amount-(amount/2000), atm);
        }
    }
}
