package com.sharan;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numOfMonths = 12;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        int principal = scanner.nextInt();
        while(principal < 1000 || principal > 1_000_000 ){
            System.out.println("Please enter a value between 1000 and 1000000");
            System.out.println("Enter Principal");
            principal = scanner.nextInt();
            if (principal > 1000 && principal < 1_000_000) {
                break;
            }

        }
        System.out.println("Enter Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        while(annualInterestRate < 1 || annualInterestRate > 30 ){
            System.out.println("Enter a value between 1 and 30.");
            System.out.println("Enter Annual Interest Rate: ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate > 1 && annualInterestRate < 30) {
                break;
            }
        }
        System.out.println("Enter the length of the loan, in years: ");
        int lengthOfLoan = scanner.nextInt();
        while(lengthOfLoan < 1 || lengthOfLoan > 30) {
            System.out.println("Enter a value between 1 and 30.");
            System.out.println("Enter the length of the loan, in years: ");
            lengthOfLoan = scanner.nextInt();
            if (lengthOfLoan > 0 && lengthOfLoan < 30) {
                break;
            }
        }

        double monthlyInterestRate = annualInterestRate / 100 / numOfMonths;
        int numOfPayments = lengthOfLoan * 12;

        Double numerator = monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numOfPayments));
        Double denominator = (Math.pow((1 + monthlyInterestRate), numOfPayments) - 1);

        Double mortgagePayment = (numerator / denominator) * principal;
        System.out.println(mortgagePayment);



    }
}
