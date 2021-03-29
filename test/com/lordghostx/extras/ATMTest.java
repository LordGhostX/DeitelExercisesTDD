package com.lordghostx.extras;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    ATM atm;

    @BeforeEach
    void startUp() {
        atm = new ATM();
    }

    @AfterEach
    void tearDown(){
        atm = null;
    }

    @Test
    void ATMInitialPinCanBeSetTest() {
        assertFalse(atm.isPinValid("1234"));
        atm.setInitialPin("1234");
        assertTrue(atm.isPinValid("1234"));
    }

    @Test
    void ATMKnowsIfInitialPinHasBeenSetTest() {
        assertFalse(atm.hasInitialPin());
        atm.setInitialPin("1234");
        assertTrue(atm.hasInitialPin());
    }

    @Test
    void ATMInitialPinCannotBeLessThan4DigitsTest() {
        atm.setInitialPin("");
        assertFalse(atm.isPinValid(""));
        atm.setInitialPin("1");
        assertFalse(atm.isPinValid("1"));
        atm.setInitialPin("12");
        assertFalse(atm.isPinValid("12"));
        atm.setInitialPin("123");
        assertFalse(atm.isPinValid("123"));
    }

    @Test
    void ATMInitialPinCannotBeSetToNullTest() {
        atm.setInitialPin(null);
        assertFalse(atm.hasInitialPin());
    }

    @Test
    void ATMPinCanBeSetTest() {
        atm.setInitialPin("1234");
        atm.changePin("1234", "5678");
        assertTrue(atm.isPinValid("5678"));
    }

    @Test
    void ATMPinCannotBeSetToNullTest() {
        atm.setInitialPin("1234");
        atm.changePin("1234", null);
        assertTrue(atm.isPinValid("1234"));
    }

    @Test
    void ATMPinCanBeValidatedTest() {
        atm.setInitialPin("1234");
        assertTrue(atm.isPinValid("1234"));
        atm.changePin("1234", "0000");
        assertTrue(atm.isPinValid("0000"));
        assertFalse(atm.isPinValid("1234"));
    }

    @Test
    void ATMPinCannotBeLessThan4DigitsTest() {
        atm.setInitialPin("1234");
        atm.changePin("1234", "");
        assertFalse(atm.isPinValid(""));
        atm.changePin("1234", "1");
        assertFalse(atm.isPinValid("1"));
        atm.changePin("1234", "12");
        assertFalse(atm.isPinValid("12"));
        atm.changePin("1234", "123");
        assertFalse(atm.isPinValid("123"));
    }

    @Test
    void ATMCanBeDepositedToTest() {
        assertEquals(0, atm.getAccountBalance());
        atm.depositMoney(5000);
        assertEquals(5000, atm.getAccountBalance());
        atm.depositMoney(1000);
        assertEquals(6000, atm.getAccountBalance());
        atm.depositMoney(500);
        assertEquals(6500, atm.getAccountBalance());
    }

    @Test
    void ATMCannotBeDepositedNegativeAmountTest() {
        atm.depositMoney(-1000);
        assertEquals(0, atm.getAccountBalance());
        atm.depositMoney(5000);
        atm.depositMoney(-10000);
        assertEquals(5000, atm.getAccountBalance());
    }

    @Test
    void ATMCanBeWithdrawnFromTest() {
        atm.depositMoney(10000);
        atm.performTransaction(5000, "withdraw");
        assertEquals(5000, atm.getAccountBalance());
        atm.performTransaction(1000, "withdraw");
        assertEquals(4000, atm.getAccountBalance());
    }

    @Test
    void ATMCannotWithdrawNegativeAmountTest() {
        atm.depositMoney(10000);
        atm.performTransaction(-5000, "withdraw");
        assertEquals(10000, atm.getAccountBalance());
        atm.performTransaction(-1000, "withdraw");
        assertEquals(10000, atm.getAccountBalance());
    }

    @Test
    void ATMCanBeTransferredFromTest() {
        atm.depositMoney(10000);
        atm.performTransaction(5000, "transfer");
        assertEquals(5000, atm.getAccountBalance());
        atm.performTransaction(2000, "transfer");
        assertEquals(3000, atm.getAccountBalance());
    }

    @Test
    void ATMCannotTransferNegativeAmountTest() {
        atm.depositMoney(10000);
        atm.performTransaction(-5000, "transfer");
        assertEquals(10000, atm.getAccountBalance());
        atm.performTransaction(-3000, "transfer");
        assertEquals(10000, atm.getAccountBalance());
    }

    @Test
    void ATMCanBeRechargedFromTest() {
        atm.depositMoney(10000);
        atm.performTransaction(5000, "recharge");
        assertEquals(5000, atm.getAccountBalance());
        atm.performTransaction(4000, "recharge");
        assertEquals(1000, atm.getAccountBalance());
        atm.performTransaction(500, "recharge");
        assertEquals(500, atm.getAccountBalance());
    }

    @Test
    void ATMCannotRechargeNegativeAmountTest() {
        atm.depositMoney(10000);
        atm.performTransaction(-5000, "recharge");
        assertEquals(10000, atm.getAccountBalance());
        atm.performTransaction(-1000, "recharge");
        assertEquals(10000, atm.getAccountBalance());
    }

    @Test
    void ATMCannotPerformTransactionWithInsufficientBalance() {
        atm.performTransaction(1000, "withdraw");
        assertEquals(0, atm.getAccountBalance());
        atm.performTransaction(1000, "transfer");
        assertEquals(0, atm.getAccountBalance());
        atm.performTransaction(1000, "recharge");
        assertEquals(0, atm.getAccountBalance());
    }
}
