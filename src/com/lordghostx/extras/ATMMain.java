package com.lordghostx.extras;

import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner input = new Scanner(System.in);

        while (true) {
            if (!atm.hasInitialPin()) {
                setUserInitialPin(atm, input);
                continue;
            }

            System.out.print("\nEnter your ATM pin: ");
            String accountPin = input.next();
            if (!atm.isPinValid(accountPin)) {
                System.out.println("The pin provided is invalid, try again");
                continue;
            }

            System.out.print("""

                    Welcome to the ATM

                    1. Deposit
                    2. Withdraw
                    3. Transfer
                    4. Buy Airtime
                    5. Check Balance
                    6. Change PIN

                    Choose your option: """);
            int userChoice = input.nextInt();

            processUserTransaction(atm, input, accountPin, userChoice);

            System.out.print("\nDo you want to perform another transaction? (1/0): ");
            int anotherTransaction = input.nextInt();
            if (anotherTransaction == 0) {
                break;
            }
        }

        System.out.println("\nBye Bye!!!");
    }

    private static void setUserInitialPin(ATM atm, Scanner input) {
        System.out.print("You don't have an initial pin, set one now\nEnter ATM initial pin: ");
        String initialPin = input.next();
        atm.setInitialPin(initialPin);
    }

    private static void processUserTransaction(ATM atm, Scanner input, String accountPin, int userChoice) {
        switch (userChoice) {
            case 1 -> {
                System.out.print("\nEnter the amount you want to deposit: ");
                double depositAmount = input.nextDouble();
                boolean isDepositValid = depositAmount > 0;
                if (isDepositValid) {
                    atm.depositMoney(depositAmount);
                    System.out.println("\nYour account has been successfully credited with " + depositAmount);
                } else {
                    System.out.println("\nYou have provided an invalid deposit amount");
                }
            }
            case 2 -> {
                System.out.print("\nEnter the amount you want to withdraw: ");
                double withdrawalAmount = input.nextDouble();
                boolean isWithdrawalValid = withdrawalAmount > 0 && withdrawalAmount <= atm.getAccountBalance();
                if (isWithdrawalValid) {
                    atm.performTransaction(withdrawalAmount, "withdraw");
                    System.out.println("\nYour account has been successfully debited with " + withdrawalAmount);
                } else {
                    System.out.println("\nYou have provided an invalid withdrawal amount");
                }
            }
            case 3 -> {
                System.out.print("\nEnter the amount you want to transfer: ");
                double transferAmount = input.nextDouble();
                boolean isTransferValid = transferAmount > 0 && transferAmount <= atm.getAccountBalance();
                if (isTransferValid) {
                    atm.performTransaction(transferAmount, "transfer");
                    System.out.println("\nYour account has been successfully debited with " + transferAmount);
                } else {
                    System.out.println("\nYou have provided an invalid transfer amount");
                }
            }
            case 4 -> {
                System.out.print("\nEnter the amount you want to recharge: ");
                double rechargeAmount = input.nextDouble();
                boolean isRechargeValid = rechargeAmount > 0 && rechargeAmount <= atm.getAccountBalance();
                if (isRechargeValid) {
                    atm.performTransaction(rechargeAmount, "recharge");
                    System.out.println("\nYour account has been successfully debited with " + rechargeAmount);
                } else {
                    System.out.println("\nYou have provided an invalid recharge amount");
                }
            }
            case 5 -> System.out.println("\nYour account balance is " + atm.getAccountBalance());
            case 6 -> {
                System.out.print("\nEnter the PIN you want to change to: ");
                String newAccountPin = input.next();
                atm.changePin(accountPin, newAccountPin);
                if (atm.isPinValid(newAccountPin)) {
                    System.out.println("\nYou have successfully changed ATM pin");
                } else {
                    System.out.println("\nYou have supplied an invalid ATM pin");
                }
            }
            default -> System.out.println("\nThe option chosen is not supported");
        }
    }
}
