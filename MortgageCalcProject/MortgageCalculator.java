package com.sharan;

import java.text.NumberFormat;

import static com.sharan.Main.MONTHS_IN_YEAR;

public class MortgageCalculator {
    private int principal;
    private double annualInterest;
    private int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }


    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterest = annualInterest / Main.PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        double monthlyInterest = annualInterest / Main.PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    public int getNumOfPayments() {
        return years * MONTHS_IN_YEAR;
    }


    public void printMortgage() {

        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
