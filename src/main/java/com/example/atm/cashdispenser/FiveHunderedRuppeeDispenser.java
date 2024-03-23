package com.example.atm.cashdispenser;

import com.example.atm.AtmMachine;
import com.example.atm.cashdispenser.CashDispenseInterface;
import com.example.atm.cashdispenser.CashDispenser;

public class FiveHunderedRuppeeDispenser extends CashDispenser {

    int notes;
    public FiveHunderedRuppeeDispenser(CashDispenseInterface nextDispenser, int notes) {
        super(nextDispenser);
        this.notes = notes;
    }

    @Override
    public void dispenseCash(int amount, AtmMachine atm) {
        int notesRequired = amount/500;
        if(notesRequired<=notes) {
            notes = notes - notesRequired;
            super.dispenseCash(amount-(amount/500), atm);
        }
    }
}
