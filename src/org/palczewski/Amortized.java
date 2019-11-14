package org.palczewski;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/*
Daclulates amoritzed payments for loans, mortgages, etc.
 */
public class Amortized {



    Amortized(double p, double rate, double periods) {
        double moInt = rate / (12 * 100);

        double payment =
                p * (moInt / (1 - (StrictMath.pow(1/(1 + moInt), periods))));
        // print table
        amortizationSchedule(p, rate, LocalDate.now(),

                periods / 12, payment);
        System.out.println("\t===Summary of payments===");
        System.out.printf("Based on principal of $%,.2f for %.0f months," +
                        "%nat %.3f%%, your payments would be $%,.2f%n", p
                , periods,
                rate,
                payment);


    }

    private void amortizationSchedule(double prin, double rate,
                                      LocalDate startDate, double years,
                                      double pmt) {
        // Change interest to decimal format
        LocalDate date = startDate;
        double v = prin;
        double moRate = rate / (12 * 100);
        double period = years * 12;

        System.out.println("\t===Amortization Table===");
        // Loop to display table
        for(int i = 0; i < period; i++) {
            double moInterest = v * moRate;
            double newPrin = pmt - moInterest;
            double newBal = v - newPrin;
            System.out.printf("%1$tb %tY Bal: $%,.2f P: $%,.2f I: $%," +
                            ".2f%n",
                    date, v, newPrin, moInterest);
            v = newBal;
            date = date.plusMonths(1);

        }




    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {
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
