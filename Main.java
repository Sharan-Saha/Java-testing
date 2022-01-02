package com.sharan;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        int principal = (int)(readNumber("Principal: ", 1000, 1_000_000));
        double annualInterestRate = readNumber("Annual interest rate: ", 1, 30);
        byte lengthOfLoan= (byte)(readNumber("Length of loan: ", 1, 30 ));

        int numOfPayments = 12 * (int)lengthOfLoan;

        printPaymentSchedule(formatter, principal, annualInterestRate, lengthOfLoan, numOfPayments);

//        String moneyString = formatter.format(calculateMortgage(principal, annualInterestRate, lengthOfLoan));
//        System.out.println(moneyString);

        //System.out.println(getRemBalance(100000, 3.92, 360, 360));
    }

    private static void printPaymentSchedule(NumberFormat formatter, int principal, double annualInterestRate, byte lengthOfLoan, int numOfPayments) {
        String paymentString = formatter.format(calculateMortgage(principal, annualInterestRate, lengthOfLoan));
        System.out.println("Monthly Payment: " + paymentString);

        System.out.println("------------------------");
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------------------");

        for (int i = 1; i < numOfPayments + 1; i++) {
            String remBalanceString = formatter.format(getRemBalance(principal, annualInterestRate, numOfPayments, i));

            System.out.println("Payment " + i + ": " + remBalanceString);
        }
    }

    public static double calculateMortgage(int principal, double annualInterest, byte years){
        double monthlyInterestRate = annualInterest / 100/ 12;
        int numOfPayments = years * 12;

        return ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numOfPayments))) / ((Math.pow((1 + monthlyInterestRate), numOfPayments) - 1))) * principal;
    }
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + "and" + max);
        }
        return value;
    }
    public static double getRemBalance(int principal, double annualInterestRate, int numPayments, int paymentsMade) {
        int PERCENT = 100;
        int monthsInYear = 12;
        double monthlyInterestRate = annualInterestRate / PERCENT / monthsInYear;
        double numerator = (Math.pow((1 + monthlyInterestRate), numPayments)) - (Math.pow((1 + monthlyInterestRate), paymentsMade));
        double denominator = (Math.pow((1 + monthlyInterestRate), numPayments)) -1;

        return (numerator / denominator) * principal;
    }
}
