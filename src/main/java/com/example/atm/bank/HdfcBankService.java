package com.example.atm.bank;

import com.example.atm.User;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

public class HdfcBankService implements BankService {
    private HashMap<String, User> carNumberToUserMap;

    public HdfcBankService(HashMap<String, User> carNumberToUserMap) {
        this.carNumberToUserMap = carNumberToUserMap;
    }

    @Override
    public User getUser(String cardNumber) {
        if(carNumberToUserMap.containsKey(cardNumber)) {
            return carNumberToUserMap.get(cardNumber);
        }
        System.out.println("No user for card number " + cardNumber + " found, please check with your HDFC Bank.");
        // throw Exception
        return null;
    }

    @Override
    public void disperseMoney(String carNumber, String pin, int amount) {
        if(carNumberToUserMap.containsKey(carNumber)) {
            User user = carNumberToUserMap.get(carNumber);
            authenticatePin(user.getPin(), pin);
            balanceSufficient(amount, user.getBankBalance());
        } else {
            System.out.println("No user for card number " + carNumber + " found, please check with your HDFC Bank.");
        }
        // throw Exception
    }

    private void balanceSufficient(int amount, int bankBalance) {
        if(!(bankBalance>=amount)) {
            System.out.println("Insufficient balance in user account.");
            // raise exception
        }
    }

    private void authenticatePin(String pin, String pin1) {
        if(!pin.equals(pin1)) {
            System.out.println("Wrong pin given.");
            // throw exception
        }
    }
}
