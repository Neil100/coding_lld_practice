package com.example.atm;

import com.example.atm.bank.Bank;
import com.example.atm.bank.BankInventoryService;
import com.example.atm.bank.BankService;
import com.example.atm.cashdispenser.CashDispenseInterface;
import com.example.atm.states.State;
import lombok.RequiredArgsConstructor;

public class AtmMachine {
    private State currentState;
    private BankInventoryService bankInventory;
    private int currentCash;
    private CashDispenseInterface cashDispenser;
    BankService bankService;
    User user;

    public AtmMachine(State state, BankInventoryService inventoryService, CashDispenseInterface cashDispenser, int currentCash) {
        this.currentState = state;
        this.bankInventory = inventoryService;
        this.cashDispenser = cashDispenser;
        this.currentCash = currentCash;
    }
   public void setCurrentState(State state) {
       currentState = state;
   }

   public void setBankService(BankService service) {
       bankService = service;
   }

   public void setUser(User user) {
       this.user = user;
   }

   public void insertCard(String cardNumber, Bank bank) {
       bankService = bankInventory.getBankService(bank);
       this.user = bankService.getUser(cardNumber);
   }

    public int getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(int currentCash) {
        this.currentCash = currentCash;
    }

//    public int getThousandNotes() {
//        return thousandNotes;
//    }
//
//    public void setThousandNotes(int thousandNotes) {
//        this.thousandNotes = thousandNotes;
//    }
//
//    public int getFiveHunderedNotes() {
//        return fiveHunderedNotes;
//    }
//
//    public void setFiveHunderedNotes(int fiveHunderedNotes) {
//        this.fiveHunderedNotes = fiveHunderedNotes;
//    }
//
//    public int getHunderedNotes() {
//        return hunderedNotes;
//    }
//
//    public void setHunderedNotes(int hunderedNotes) {
//        this.hunderedNotes = hunderedNotes;
//    }

    public boolean isPinCorrect(String pin) {
        return user.getPin().equals(pin);
    }

    public boolean hasSufficientBalance(int amount) {
       return this.user.getBankBalance()>=amount;
    }

    public void disperseCash(int disperseAmount) {
       bankService.disperseMoney(user.getCard().getNumber(), user.getPin(), disperseAmount);
       cashDispenser.dispenseCash(disperseAmount, this);
       currentCash = currentCash - disperseAmount;
    }

    public int getUserBalance() {
        return this.user.getBankBalance();
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
