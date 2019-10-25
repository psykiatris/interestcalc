package org.palczewski;

import java.util.Scanner;

public class APY {

    APY(double balance, double intRate) {
        double apr = intRate / 100;
        // first part of formula
        double compoundRate = 12;
        double form = 1 + (apr / compoundRate);

        // The rest of the formula
        double res = (Math.pow(form, compoundRate) - 1);

        System.out.printf("Balance: $%,.2f%nInterest rate: %.2f%%%nInterest paid yearly: $%,.2f%n= monthly: $%,.2f%n", balance,
                intRate,
                balance * res, (balance * res) / 12);
        System.out.printf("True APY is: %,.2f%%%n", res * 100);
    }

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            // Get figures
            System.out.print("Enter a balance: ");
            double bal = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double interest = in.nextDouble();

            // Pass along
            new APY(bal, interest);
        }

    }
}
