package com.lordghostx.extras;

import java.util.Scanner;

public class QuestionGame {
    public static void main(String[] args) {
        int grade = 0, questionLimit = 10, firstNumber, secondNumber, thirdNumber;
        char firstOperand, secondOperand;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questionLimit; i++) {
            firstNumber = generateRandomNumber(10);
            secondNumber = generateRandomNumber(10);
            thirdNumber = generateRandomNumber(10);

            firstOperand = generateOperand();
            secondOperand = generateOperand();

            System.out.printf("%d %c %d %c %d = ", firstNumber, firstOperand, secondNumber, secondOperand, thirdNumber);
            int userAnswer = scanner.nextInt();

            int firstAnswer = evaluateSubmission(firstNumber, secondNumber, firstOperand);
            int secondAnswer = evaluateSubmission(firstAnswer, thirdNumber, secondOperand);
            boolean isUserAnswerCorrect = userAnswer == secondAnswer;
            if (isUserAnswerCorrect) {
                grade++;
            }
        }

        System.out.printf("Your score is %d/%d%n", grade, questionLimit);
    }

    private static int evaluateSubmission(int firstNumber, int secondNumber, char operand) {
        int expectedAnswer = 0;
        switch (operand) {
            case '+':
                expectedAnswer = firstNumber + secondNumber;
                break;
            case '-':
                expectedAnswer = firstNumber - secondNumber;
                break;
            case '*':
                expectedAnswer = firstNumber * secondNumber;
                break;
            case '/':
                expectedAnswer = firstNumber / secondNumber;
                break;
            case '%':
                expectedAnswer = firstNumber % secondNumber;
                break;
        }

        return expectedAnswer;
    }

    public static int generateRandomNumber(int limit) {
        int randomNumber;
        randomNumber = (int) (Math.random() * limit) % limit;
        return randomNumber;
    }

    public static char generateOperand() {
        int seed = generateRandomNumber(5);
        char operand = ' ';
        switch (seed) {
            case 0:
                operand = '+';
                break;
            case 1:
                operand = '-';
                break;
            case 2:
                operand = '*';
                break;
            case 3:
                operand = '/';
                break;
            case 4:
                operand = '%';
                break;
        }
        return operand;
    }
}
