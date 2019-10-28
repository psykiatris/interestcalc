package org.palczewski;

import javax.swing.*;
import java.util.Scanner;

/*
Daclulates amoritzed payments for loans, mortgages, etc.
 */
public class Amortized {



    Amortized(double p, double rate, double periods) {
        double moInt = (rate / 100) / 12;

        double payment =
                p * (moInt / (1 - (Math.pow(1/(1 + moInt), periods))));
        System.out.printf("Based on principal of $%,.2f for %.1f months," +
                        "%nat %.2f%%, your payments would be $%,.2f%n", p
                , periods,
                rate,
                payment);

    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Calculated payments on mortgage");
            System.out.print("Enter principal amt: ");
            double prin = in.nextDouble();
            System.out.print("Enter interest rate: ");
            double rate = in.nextDouble();
            System.out.print("How many years? ");
            double periods = in.nextDouble() * 12;
            new Amortized(prin, rate, periods);
        }

    }
}
