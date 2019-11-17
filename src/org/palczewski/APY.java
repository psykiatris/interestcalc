package org.palczewski;

import java.time.LocalDate;
import java.util.Scanner;

public class APY {

    APY(double totalInt, double intRate,
        double period) {
        double apr = intRate / 100;
        // first part of formula
        double compoundRate = period * 12;
        double form = 1 + (apr / compoundRate);

        // The rest of the formula
        double res = (StrictMath.pow(form, compoundRate) - 1);

        System.out.println("\t===APY===");
        System.out.printf("Total interest paid: $%,.2f%nInterest rate: %" +
                        ".2f%%%nYearly interest: $%,.2f%n=  average " +
                        "monthly " +
                        "interest of: $%,.2f%n",
                totalInt,
                intRate,
                (totalInt / period), (totalInt /
                compoundRate));
        System.out.printf("True APY is: %,.2f%%%n", res * 100);

    }

    private static double growthTable(double startBal, double rate,
                                 LocalDate date
            , double invBal, double term) {

        LocalDate localDate = date;
        double bal = startBal;
        double moRate = rate / (12 * 100);
        double month = term * 12;
        double newBal = 0;
        double totalInt = 0;

        for(int i = 0; i < month; i++) {
            double moInt = bal * moRate;
            totalInt += moInt;
            newBal = bal + moInt;
            System.out.printf("%1$tb %tY - Bal: $%,.2f Int: $%,.2f%n",
                    localDate, newBal, moInt);
            bal = newBal + invBal;
            localDate = localDate.plusMonths(1);
        }
        System.out.println("\t===Results===");
        System.out.printf("After %.0f months, with an initail balance of %n$%,.2f and a monthly deposit of $%,.2f,%n your final balance would be $%,.2f%n", month, startBal, invBal
                , newBal);
        return totalInt;
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

            double resBal = growthTable(bal, interest,LocalDate.now(),
                    invBal, term);

            // Pass along
            new APY(resBal, interest, term);
        }

    }
}
