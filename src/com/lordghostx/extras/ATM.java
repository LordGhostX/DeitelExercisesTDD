package com.lordghostx.extras;

public class ATM {
    private String accountPin;
    private double accountBalance;

    public void setInitialPin(String accountPin) {
        boolean isPinNull = accountPin == null;
        if (isPinNull) {
            return;
        }
        boolean isValidPin = accountPin.length() >= 4;
        if (isValidPin) {
            this.accountPin = accountPin;
        }
    }

    public boolean isPinValid(String accountPin) {
        boolean isPinNull = this.accountPin == null;
        if (isPinNull) {
            return false;
        } else {
            return this.accountPin.equals(accountPin);
        }
    }

    public void changePin(String oldAccountPin, String newAccountPin) {
        boolean isPinNull = newAccountPin == null;
        if (isPinNull) {
            return;
        }
        boolean isPinValid = this.accountPin.equals(oldAccountPin) && newAccountPin.length() >= 4;
        if (isPinValid) {
            this.accountPin = newAccountPin;
        }
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void depositMoney(double amount) {
        boolean isAmountValid = amount > 0;
        if (isAmountValid) {
            accountBalance += amount;
        }
    }

    public void performTransaction(double amount, String transactionType) {
        boolean isAmountValid = amount > 0 && amount <= accountBalance;
        boolean isTransactionValid = transactionType.equals("withdraw") || transactionType.equals("transfer") || transactionType.equals("recharge");
        if (isAmountValid && isTransactionValid) {
            accountBalance -= amount;
        }
    }

    public boolean hasInitialPin() {
        boolean isPinNotNull = accountPin != null;
        return isPinNotNull;
    }
}
