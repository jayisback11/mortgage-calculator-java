package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte periodInYears = scanner.nextByte();

        //Mortgage Formula = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
        //Here’s a breakdown of each of the variables:
        //  M = Total monthly payment
        //  P = The total amount of your loan
        //  I = Your interest rate, as a monthly percentage
        //  N = The total amount of months in your timeline for paying off your mortgage

        double annualInterestRateToMonthly = (annualInterestRate/100)/12;
        double mortgage = principal * (annualInterestRateToMonthly*(Math.pow(1+annualInterestRateToMonthly, periodInYears*12))) / (Math.pow(1+annualInterestRateToMonthly, periodInYears*12) - 1 );

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
