package com.lordghostx.extras;

public class Account {
    private double balance;
    private int pinCode;

    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getAccountBalance() {
        return balance;
    }

    public void setPin(int pinCode) {
        this.pinCode = pinCode;
    }

    public void withdrawMoney(int amount, int pinCode) {
        if (this.pinCode == pinCode && balance >= amount && this.pinCode != 0) {
            balance -= amount;
        }
    }
}
