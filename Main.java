package com.sharan;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Principal: ");
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate:");
        double monthlyInterestRate = (scanner.nextDouble() / 100 / 12);
        System.out.print("Payment Length, in years: ");
        int numOfPayments = scanner.nextInt() * 12;
        System.out.println(NumberFormat.getCurrencyInstance().format(principal));
        System.out.println(monthlyInterestRate);
        System.out.println(numOfPayments);

        Double numerator = monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numOfPayments));
        Double denominator = (Math.pow((1 + monthlyInterestRate), numOfPayments) - 1);

        Double mortgagePayment = (numerator / denominator) * principal;
        System.out.println(mortgagePayment); //testing

    }
}
