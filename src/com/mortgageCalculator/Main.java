package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal;
        double annualInterestRate;
        byte periodInYears;

        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            try {
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1_000_000)
                    break;
                System.out.println("Enter a number between $1,000 and $1,000,000");
            } catch(Exception ex) {
                System.out.println("Enter a number between $1,000 and $1,000,000");
                scanner.nextLine();
            }
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            try {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate >= 0 && annualInterestRate <= 30)
                    break;
                System.out.println("Enter a number between 0 and 30");
            } catch(Exception ex) {
                System.out.println("Enter a number between 0 and 30");
                scanner.nextLine();
            }
        }

        while(true){
            System.out.print("Period (Years): ");
            try {
                periodInYears = scanner.nextByte();
                if (periodInYears >= 1 && periodInYears <= 30)
                    break;
                System.out.println("Enter a number between 1 and 30");
            } catch(Exception ex) {
                System.out.println("Enter a number between 1 and 30");
                scanner.nextLine();
            }
        }

        //Mortgage Formula = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
        //Here’s a breakdown of each of the variables:
        //  M = Total monthly payment
        //  P = The total amount of your loan
        //  I = Your interest rate, as a monthly percentage
        //  N = The total amount of months in your timeline for paying off your mortgage

        double annualInterestRateToMonthly = (annualInterestRate/100)/12;
        double mortgage = principal * (annualInterestRateToMonthly*(Math.pow(1+annualInterestRateToMonthly, periodInYears*12))) / (Math.pow(1+annualInterestRateToMonthly, periodInYears*12) - 1 );

        System.out.println("Calculating Mortgage...");

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
