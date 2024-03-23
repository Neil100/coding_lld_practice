package com.example.atm;

import com.example.atm.actions.ActionType;
import com.example.atm.bank.*;
import com.example.atm.cashdispenser.CashDispenseInterface;
import com.example.atm.cashdispenser.FiftyRuppeeDispenser;
import com.example.atm.cashdispenser.FiveHunderedRuppeeDispenser;
import com.example.atm.cashdispenser.TwoThousandRuppeeDispenser;
import com.example.atm.states.IdleState;
import com.example.atm.states.State;
import com.example.atm.states.StateInterface;

import java.util.Date;
import java.util.HashMap;

public class AtmMachineMain {
    public static void main(String[] args) {

        HashMap<Bank, BankService> mapBankToService = new HashMap<>();
        HashMap<String, User> carToUser = new HashMap<>();

        Card card = new Card("12345678", 123, "12345678", new Date());
        carToUser.put("12345678", new User("Kshitij", card, Bank.HDFC, "2525", 50000));

        card = new Card("23456789", 234, "23456789", new Date());
        carToUser.put("23456789", new User("Anshul", card, Bank.HDFC, "1313", 1500000));

        mapBankToService.put(Bank.HDFC, new HdfcBankService(carToUser));

        BankInventoryService inventoryService = new BankInvetoryServiceImplementation(mapBankToService);

        CashDispenseInterface cashDispenser = new TwoThousandRuppeeDispenser(new FiveHunderedRuppeeDispenser(new FiftyRuppeeDispenser(null, 100), 10), 5);
        AtmMachine atm = new AtmMachine(new IdleState(), inventoryService, cashDispenser, 20000);

        State state = atm.getCurrentState();

        state.insertCard(atm, "12345678", Bank.HDFC);

        state = atm.getCurrentState();
        state.enterPin(atm, "2525");

        state = atm.getCurrentState();
        state.selectAction(atm, ActionType.WITHDRAW_CASH);

        state = atm.getCurrentState();
        state.withdrawCash(atm, 10000);

        state = atm.getCurrentState();
        state.disperseCash(atm);

        state = atm.getCurrentState();


        System.out.println(atm.getCurrentCash());

        state.insertCard(atm, "23456789", Bank.HDFC);
        state = atm.getCurrentState();

        state.cancelTransaction(atm);
    }
}
