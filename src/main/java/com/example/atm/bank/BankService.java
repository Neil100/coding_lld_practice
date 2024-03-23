package com.example.atm.bank;

import com.example.atm.User;

public interface BankService {
    public User getUser(String cardNumber);
    public void disperseMoney(String carNumber, String pin, int amount);
}
