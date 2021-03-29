package com.lordghostx.extras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void accountCanBeCreatedTest() {
        Account account = new Account();
    }

    @Test
    void accountCanBeDepositedToTest() {
        Account account = new Account();
        account.depositMoney(3000);
        assertEquals(3000, account.getAccountBalance());
        account.depositMoney(2000);
        assertEquals(5000, account.getAccountBalance());
    }

    @Test
    void accountCannotBeDepositedNegativeAmountTest() {
        Account account = new Account();
        account.depositMoney(5000);
        account.depositMoney(-3000);
        assertEquals(5000, account.getAccountBalance());
    }

    @Test
    void accountCanBeWithdrawnFromWithValidPinTest() {
        Account account = new Account();
        account.setPin(1234);
        account.depositMoney(5000);
        account.withdrawMoney(3000, 12345);
        assertEquals(5000, account.getAccountBalance());
        account.withdrawMoney(3000, 1234);
        assertEquals(2000, account.getAccountBalance());
    }

    @Test
    void accountCannotBeWithdrawnFromIfBalanceIsNotEnough() {
        Account account = new Account();
        account.setPin(1234);
        account.depositMoney(5000);
        account.withdrawMoney(10000, 1234);
        assertEquals(5000, account.getAccountBalance());
        account.withdrawMoney(5000, 1234);
        assertEquals(0, account.getAccountBalance());
    }

    @Test
    void accountWithoutPinCannotBeWithdrawnFromTest() {
        Account account = new Account();
        account.depositMoney(5000);
        assertEquals(5000, account.getAccountBalance());
        account.withdrawMoney(5000, 0);
        assertEquals(5000, account.getAccountBalance());
    }
}
