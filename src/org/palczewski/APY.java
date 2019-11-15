package org.palczewski;

import java.time.LocalDate;
import java.util.Scanner;

public class APY {

    APY(double balance, double intRate) {
        double apr = intRate / 100;
        // first part of formula
        double compoundRate = 12;
        double form = 1 + (apr / compoundRate);

        // The rest of the formula
        double res = (StrictMath.pow(form, compoundRate) - 1);

        System.out.printf("Balance: $%,.2f%nInterest rate: %.2f%%%nInterest paid yearly: $%,.2f%n= monthly: $%,.2f%n", balance,
                intRate,
                balance * res, (balance * res) / 12);
        System.out.printf("True APY is: %,.2f%%%n", res * 100);

    }

    private static void growthTable(double startBal, double rate, LocalDate date
            , double invBal, double term) {

        LocalDate localDate = date;
        double bal = startBal;
        double moRate = rate / (12 * 100);
        double month = term * 12;
        double newBal = 0;

        for(int i = 0; i < month; i++) {
            double moInt = bal * moRate;
            newBal = bal + moInt;
            System.out.printf("%1$tb %tY - Bal: $%,.2f Int: $%,.2f%n",
                    localDate, newBal, moInt);
            bal = newBal + invBal;
            localDate = localDate.plusMonths(1);
        }
        System.out.println("\t===Results===");
        System.out.printf("After %.0f months, with an initail balance of %n$%,.2f and a momthly deposit of $%,.2f,%n your final balance would be $%,.2f", month, startBal, invBal
                , newBal);
    }

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            // Get figures
            System.out.print("Enter a balance: ");
            double bal = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double interest = in.nextDouble();
            System.out.print("Enter amount to invest monthly: ");
            double invBal = in.nextDouble();
            System.out.print("Enter term in years: ");
            double term = in.nextDouble();

            growthTable(bal, interest,LocalDate.now(), invBal, term);

            // Pass along
            // new APY(bal, interest);
        }

    }
}
