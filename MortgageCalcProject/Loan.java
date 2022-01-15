package com.sharan;

public class Loan {

    public static final int monthsInYear = 12;
    public static final int percent = 100;

    private int principal;
    private double interestRate;
    private int loanLength;

    public Loan(int principal, double interestRate, int loanLength) {
        this.principal = setPrincipal(principal);
        this.interestRate = setInterestRate(interestRate);
        this.loanLength = setLoanLength(loanLength);
    }

    private int setPrincipal(int principal) {
        if (principal < 1000 || principal > 1_000_000) {
            throw new IllegalArgumentException("Value must be between 1,000 and 1,000,000");
        }
        else{
            return principal;
        }
    }

    private double setInterestRate(double interestRate) {
        if (interestRate < 1 || interestRate > 30) {
            throw new IllegalArgumentException("Interest rate must be between 1 and 30");
        }
        else {
            return interestRate;
        }
    }
    private int setLoanLength(int loanLength) {
        if (loanLength < 1 || loanLength > 30) {
            throw new IllegalArgumentException("Loan length must be between 1 and 30");
        }
        else {
            return loanLength;
        }
    }
    public double getMortgagePayment() {
        return calculateMortgagePayment(principal, interestRate, loanLength);
    }

    private double calculateMortgagePayment(int principal, double interestRate, int length) {
        double monthlyInterest = interestRate / percent / monthsInYear;
        double numberOfPayments = length * monthsInYear;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

    }

    private static double calculateRemBalance(int principal, double interestRate, int years, int numberOfPaymentsMade) {
        double monthlyInterest = interestRate / percent / monthsInYear;
        double numberOfPayments = years * monthsInYear;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);


    }
    public  void printPaymentSchedule() {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("--------------------");

        for (int month = 1; month <= loanLength * monthsInYear; month++){
            double balance = calculateRemBalance(principal, interestRate, loanLength, month);
            System.out.println(balance);
        }
    }

}
